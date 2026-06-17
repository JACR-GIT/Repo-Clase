import org.apache.commons.net.ftp.*;
import org.apache.commons.net.smtp.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AuditoriaFTPyMail {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int informesLeidos = 0;
        int solicitudesNuevas = 0;

        String contraseñaComun = "usu1";  // misma contraseña para los 3 técnicos

        while (true) {

            System.out.print("Usuario (tecnico1, tecnico2, tecnico3 o * para terminar): ");
            String usuario = sc.nextLine().trim();

            if (usuario.equals("*")) {
                break;
            }

            // Solo aceptamos los 3 usuarios válidos
            if (!usuario.equals("tecnico1") && !usuario.equals("tecnico2") && !usuario.equals("tecnico3")) {
                System.out.println("Usuario no válido. Usa tecnico1, tecnico2 o tecnico3.");
                continue;
            }

            FTPClient ftp = new FTPClient();

            try {
                ftp.connect("localhost");
                int reply = ftp.getReplyCode();
                if (!FTPReply.isPositiveCompletion(reply)) {
                    System.out.println("No se pudo conectar al servidor FTP");
                    continue;
                }

                boolean login = ftp.login(usuario, contraseñaComun);
                if (!login) {
                    System.out.println("Login incorrecto para " + usuario);
                    ftp.disconnect();
                    continue;
                }

                System.out.println("Login correcto para " + usuario);

                ftp.changeWorkingDirectory("/REPORTS");

                FTPFile[] archivos = ftp.listFiles();
                boolean existePendiente = false;

                for (FTPFile f : archivos) {
                    if (f.getName().equals("tarea_pendiente.txt")) {
                        existePendiente = true;
                        break;
                    }
                }

                if (existePendiente) {
                    // Renombrar a leido_[usuario].txt
                    ftp.rename("tarea_pendiente.txt", "leido_" + usuario + ".txt");

                    // Descargar y mostrar por consola
                    File temp = new File("temporal_" + usuario + ".txt");
                    FileOutputStream fos = new FileOutputStream(temp);
                    ftp.retrieveFile("leido_" + usuario + ".txt", fos);
                    fos.close();

                    System.out.println("Contenido del informe leido_" + usuario + ".txt:");
                    BufferedReader br = new BufferedReader(new FileReader(temp));
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                    br.close();

                    informesLeidos++;

                } else {
                    // Crear y subir SOLICITUD.txt
                    File solicitud = new File("solicitud.txt");
                    FileWriter fw = new FileWriter(solicitud);
                    fw.write("Por favor, suba su informe semanal.");
                    fw.close();

                    FileInputStream fis = new FileInputStream(solicitud);
                    ftp.storeFile("SOLICITUD.txt", fis);
                    fis.close();

                    System.out.println("Creada SOLICITUD.txt para " + usuario);
                    solicitudesNuevas++;
                }

                ftp.logout();
                ftp.disconnect();

            } catch (Exception e) {
                System.out.println("Error procesando " + usuario + ": " + e.getMessage());
            }
        }

        // Fase 2: Enviar resumen por correo
        enviarResumen(informesLeidos, solicitudesNuevas);

        sc.close();
    }

    private static void enviarResumen(int leidos, int nuevas) {

        AuthenticatingSMTPClient smtp = new AuthenticatingSMTPClient();

        // Configura según tu entorno (Mercury o Gmail)
        String servidor = "localhost";     // o "smtp.gmail.com"
        int puerto = 25;                   // o 587
        String remitente = "postmaster@localhost";  // o tu gmail
        String claveSMTP = "";             // vacía si usas Mercury sin auth, o tu app password
        String destinatario = "admin@localhost";    // cámbialo por el correo real del administrador

        try {
            smtp.connect(servidor, puerto);
            System.out.println("1 - " + smtp.getReplyString());

            smtp.ehlo(servidor);
            System.out.println("2 - " + smtp.getReplyString());

            if (puerto == 587) {
                smtp.execTLS();
                System.out.println("3 - " + smtp.getReplyString());
            }

            boolean auth = smtp.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, remitente, claveSMTP);
            if (auth) {
                System.out.println("4 - " + smtp.getReplyString());
            } else {
                System.out.println("Autenticación fallida");
            }

            String asunto = "Resumen de Auditoría FTP - " + new java.util.Date().toString();

            String cuerpo = "Se han procesado " + leidos + " informes correctamente " +
                    "y se han generado " + nuevas + " solicitudes de archivo nuevas.";

            SimpleSMTPHeader header = new SimpleSMTPHeader(remitente, destinatario, asunto);

            smtp.setSender(remitente);
            smtp.addRecipient(destinatario);
            System.out.println("5 - " + smtp.getReplyString());

            Writer writer = smtp.sendMessageData();
            if (writer != null) {
                writer.write(header.toString());
                writer.write(cuerpo);
                writer.close();
                System.out.println("6 - " + smtp.getReplyString());

                boolean exito = smtp.completePendingCommand();
                System.out.println("7 - " + smtp.getReplyString());

                if (exito) {
                    JOptionPane.showMessageDialog(null, "Correo enviado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Fallo al enviar correo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en SMTP:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                smtp.disconnect();
            } catch (Exception ignored) {}
        }
    }
}