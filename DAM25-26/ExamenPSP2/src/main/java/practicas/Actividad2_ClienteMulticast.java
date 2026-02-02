package practicas;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * ACTIVIDAD 2 - CLIENTE MULTICAST UDP
 * Recibe mensajes del grupo multicast.
 */
public class Actividad2_ClienteMulticast extends JFrame {
    
    private JTextArea areaMensajes;
    private MulticastSocket socket;
    private InetAddress grupo;
    private final String GRUPO_MULTICAST = "225.0.0.1";
    private final int PUERTO = 12345;
    private String nombre;
    
    public Actividad2_ClienteMulticast() {
        // Pedir nombre al usuario
        nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
        if (nombre == null || nombre.isEmpty()) nombre = "Usuario";
        
        // Configurar ventana
        setTitle("Cliente Multicast - " + nombre);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Área de texto para mensajes recibidos
        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaMensajes);
        
        // Botón Salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        
        // Añadir componentes
        add(scroll, BorderLayout.CENTER);
        add(btnSalir, BorderLayout.SOUTH);
        
        // Inicializar y unirse al grupo multicast
        iniciarSocket();
        
        // Iniciar hilo para recibir mensajes
        iniciarRecepcion();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void iniciarSocket() {
        try {
            socket = new MulticastSocket(PUERTO);
            grupo = InetAddress.getByName(GRUPO_MULTICAST);
            
            // Unirse al grupo multicast
            NetworkInterface interfaz = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            socket.joinGroup(new InetSocketAddress(grupo, PUERTO), interfaz);
            
            areaMensajes.append("Conectado al grupo multicast\n");
            areaMensajes.append("Usuario: " + nombre + "\n\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void iniciarRecepcion() {
        // Crear hilo para recibir mensajes
        new Thread(() -> {
            byte[] buffer = new byte[1024];
            
            while (true) {
                try {
                    // Recibir paquete multicast
                    DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                    socket.receive(paquete);
                    
                    // Convertir a String
                    String mensaje = new String(paquete.getData(), 0, paquete.getLength());
                    
                    // Mostrar mensaje en la interfaz
                    SwingUtilities.invokeLater(() -> 
                        areaMensajes.append("Servidor: " + mensaje + "\n"));
                    
                } catch (IOException e) {
                    break;
                }
            }
        }).start();
    }
    
    public static void main(String[] args) {
        new Actividad2_ClienteMulticast();
    }
}
