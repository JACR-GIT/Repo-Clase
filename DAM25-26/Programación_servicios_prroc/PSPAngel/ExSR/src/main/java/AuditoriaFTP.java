import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.swing.*;
import java.io.*;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class AuditoriaFTP {
    static FTPClient cliente = new FTPClient();
    static String direcInicial = "/REPORTES";

    public static Integer solicitud = 0;
    public static Integer procesado = 0;
    public static void main(String[] args) {
        String servidor = "localhost";
        Scanner sc = new Scanner(System.in);

        try {
            cliente.connect(servidor);
            System.out.println("Conexión realizada con éxito.");
            cliente.enterLocalPassiveMode();

            while (true) {
                System.out.print("Usuario (\"*\" para salir): ");
                String usuario = sc.nextLine();
                if ("*".equals(usuario)) {
                    System.out.println("Saliendo...");
                    notificacionSMTP();
                    break;
                }
                System.out.print("Password: ");
                String password = sc.nextLine();

                try {
                    boolean login = cliente.login(usuario, password);
                    if (login) {
                        System.out.println("Login correcto para usuario: " + usuario);
                        verificarArchivo(usuario);
                        cliente.logout();
                        cliente.disconnect();
                        cliente.connect(servidor);
                        cliente.enterLocalPassiveMode();
                    } else {
                        System.out.println("Login fallido para usuario: " + usuario);
                    }
                } catch (Exception e) {
                    System.out.println("Error durante login: " + e.getMessage());
                    try {
                        if (cliente.isConnected()) {
                            cliente.disconnect();
                        }
                        cliente.connect(servidor);
                        cliente.enterLocalPassiveMode();
                    } catch (Exception reconnect) {
                        System.out.println("Error al reconectar: " + reconnect.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        } finally {
            try {
                if (cliente.isConnected()) {
                    cliente.disconnect();
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }

    static void verificarArchivo(String usuario) {
        try {
            cliente.changeWorkingDirectory(direcInicial);
            String[] archivos = cliente.listNames();
            boolean encontrado = false;
            for (String archivo : archivos) {
                if (archivo.equals("tarea_pendiente.txt")) {
                    encontrado = true;
                    procesado++;
                    ByteArrayOutputStream contenidoDescargado = new ByteArrayOutputStream();
                    cliente.retrieveFile(archivo, contenidoDescargado);
                    String contenido = contenidoDescargado.toString();

                    System.out.println("Contenido de tarea_pendiente.txt");
                    System.out.println(contenido);
                    System.out.println("Fin del contenido");

                    String renombrar = "leido_" + usuario + ".txt";
                    if (cliente.listNames(renombrar).length > 0) {
                        cliente.deleteFile(renombrar);
                    }
                    cliente.rename(archivo, renombrar);
                    System.out.println("Archivo renombrado a: leido_" + usuario + ".txt");

                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Archivo tarea_pendiente.txt no encontrado.");
                solicitud++;
                String contenidoSolicitud = "Por favor, suba su informe semanal";
                InputStream inputStream = new ByteArrayInputStream(contenidoSolicitud.getBytes());
                boolean subido = cliente.storeFile("SOLICITUD.txt", inputStream);

                if (subido) {
                    System.out.println("Archivo SOLICITUD.txt creado y subido con exito.");
                } else {
                    System.out.println("Error al subir archivo SOLICITUD.txt");
                }
                inputStream.close();
            }

        } catch (Exception e) {
            System.out.println("Error al verificar archivo: " + e.getMessage());
        }
    }

    static void notificacionSMTP() {
        AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();
        String server = "smtp.gmail.com";
        String username = "angelroldanrabanal@fundacionsafa.es";
        String password = "nn";
        int puerto = 587;
        String remitente = "angelroldanrabanal@fundacionsafa.es";


        try {
            int respuesta;
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(null, null);
            KeyManager km = kmf.getKeyManagers()[0];
            client.connect(server, puerto);
            client.setKeyManager(km);
            respuesta = client.getReplyCode();
            if (!SMTPReply.isPositiveCompletion(respuesta)) {
                client.disconnect();
                JOptionPane.showMessageDialog(null, "Conexión Rechazada.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                System.err.println("CONEXIÓN RECHAZADA.");
                return;
            }
            client.ehlo(server);
            if (client.execTLS()) {
                if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {
                    String destino1 = "aroldanrabanal@safareyes.es";
                    String asunto = "Resumen de Auditoría FTP - " + java.time.LocalDate.now();
                    String mensaje = "Se han procesado " + procesado + " informes y se han generado " + solicitud + " solicitudes de archivo nuevas.";

                    SimpleSMTPHeader header = new SimpleSMTPHeader(remitente, destino1, asunto);

                    client.setSender(remitente);
                    client.addRecipient(destino1);

                    Writer writer = client.sendMessageData();
                    if (writer == null) {
                        JOptionPane.showMessageDialog(null, "Error al enviar el sender.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("FALLO AL ENVIAR DATA.");
                        return;
                    }

                    writer.write(header.toString());
                    writer.write(mensaje);
                    writer.close();

                    boolean exito = client.completePendingCommand();

                    if (exito) {
                        JOptionPane.showMessageDialog(null, "Se ha enviado el correo con exito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Correo enviado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido enviar el correo.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Error al enviar correo.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Autenticación fallida.", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error: Autenticación fallida.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo establecer conexión segura (TLS).", "Error TLS", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error: No se pudo establecer TLS.");
            }
        } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException | IOException |
                 InvalidKeySpecException | InvalidKeyException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (client.isConnected()) {
                    client.disconnect();
                }
            } catch (IOException e) {
                System.out.println("Error al desconectar SMTP: " + e.getMessage());
            }
        }
    }
}