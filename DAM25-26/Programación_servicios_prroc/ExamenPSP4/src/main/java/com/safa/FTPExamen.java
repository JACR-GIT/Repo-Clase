package com.safa;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.swing.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class FTPExamen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FTPClient cliente = new FTPClient();

        int informesLeidos = 0;
        int solicitudesNuevas = 0;

        cliente.enterLocalPassiveMode();

        String contra = "1234";

        while (true) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine().trim();

            try {
                cliente.connect("localhost");
                int reply = cliente.getReplyCode();

                if (!FTPReply.isPositiveCompletion(reply)) {
                    System.out.println("No se pudo conectar al servidor FTP");
                }

                boolean login = cliente.login(usuario, contra);
                if (!login) {
                    System.out.println("Login incorrecto para " + usuario);
                    cliente.disconnect();
                }

                System.out.println("Login correcto para " + usuario);

                cliente.changeWorkingDirectory("/REPORTS");

                FTPFile[] archivos = cliente.listFiles();
                boolean existePendiente = false;

                for (FTPFile f : archivos) {
                    if (f.getName().equals("tarea_pendiente.txt")) {
                        existePendiente = true;
                        break;
                    }
                }

                if (existePendiente) {
                    cliente.rename("tarea_pendiente.txt", "leido_" + usuario + ".txt");

                    File fileTempora = new File("temporal_" + usuario + ".txt");
                    FileOutputStream fos = new FileOutputStream(fileTempora);
                    cliente.retrieveFile("leido_" + usuario + ".txt", fos);
                    fos.close();

                    System.out.println("Contenido del informe leido_" + usuario + ".txt:");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileTempora));
                    String linea;
                    while ((linea = bufferedReader.readLine()) != null) {
                        System.out.println(linea);
                    }
                    bufferedReader.close();

                    informesLeidos++;

                } else {

                    File solicitud = new File("solicitud.txt");
                    FileWriter fileWriter = new FileWriter(solicitud);
                    fileWriter.write("Por favor, suba su informe semanal.");
                    fileWriter.close();

                    FileInputStream fileInputStream = new FileInputStream(solicitud);
                    cliente.storeFile("SOLICITUD.txt", fileInputStream);
                    fileInputStream.close();

                    System.out.println("Creada SOLICITUD.txt para " + usuario);
                    solicitudesNuevas++;
                }

                cliente.logout();
                cliente.disconnect();

            } catch (Exception e) {
                System.out.println("Error procesando " + usuario + ": " + e.getMessage());
            }
        }

        resumen(informesLeidos, solicitudesNuevas);

        scanner.close();
    }

    private static void resumen(int leidos, int nuevas) {
        AuthenticatingSMTPClient cliente = new AuthenticatingSMTPClient();

        String server = "smtp.gmail.com";
        int puerto = 25;
        String remitente = "correo@servidor.es";
        String claveSMTP = "";
        String destinatario = "admin@localhost";

        try {
            cliente.connect(server, puerto);
            cliente.login(server);

            boolean auth = cliente.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, remitente, claveSMTP);
            if (auth) {
                System.out.println("4 - " + cliente.getReplyString());
            } else {
                System.out.println("Autenticación fallida");
            }
            String asunto = "Resumen de Auditoría FTP - " + new Date().toString();

            String cuerpo = "Se han procesado " + leidos + " informes correctamente " +
                    "y se han generado " + nuevas + " solicitudes de archivo nuevas.";

            SimpleSMTPHeader header = new SimpleSMTPHeader(remitente, destinatario, asunto);

            cliente.setSender(remitente);
            cliente.addRecipient(destinatario);
            System.out.println("5 - " + cliente.getReplyString());

            Writer writer = cliente.sendMessageData();
            if (writer != null) {
                writer.write(header.toString());
                writer.write(cuerpo);
                writer.close();
                System.out.println("6 - " + cliente.getReplyString());

                boolean exito = cliente.completePendingCommand();
                System.out.println("7 - " + cliente.getReplyString());

                if (exito) {
                    JOptionPane.showMessageDialog(null, "Correo enviado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Fallo al enviar correo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println("Error enviando resumen: " + e.getMessage());
        }
    }
}

