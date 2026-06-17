package practicas;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * ACTIVIDAD 2 - SERVIDOR MULTICAST UDP
 * Envía mensajes a todos los clientes del grupo multicast.
 */
public class Actividad2_ServidorMulticast extends JFrame {
    
    private JTextField campoMensaje;
    private JTextArea areaMensajes;
    private MulticastSocket socket;
    private InetAddress grupo;
    private final String GRUPO_MULTICAST = "225.0.0.1";
    private final int PUERTO = 12345;
    
    public Actividad2_ServidorMulticast() {
        // Configurar ventana
        setTitle("Servidor Multicast");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel superior con campo de texto
        JPanel panelSup = new JPanel(new BorderLayout());
        campoMensaje = new JTextField();
        panelSup.add(new JLabel("Mensaje: "), BorderLayout.WEST);
        panelSup.add(campoMensaje, BorderLayout.CENTER);
        
        // Área de texto para mostrar mensajes enviados
        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaMensajes);
        
        // Panel de botones
        JPanel panelBot = new JPanel();
        JButton btnEnviar = new JButton("Enviar");
        JButton btnSalir = new JButton("Salir");
        
        btnEnviar.addActionListener(e -> enviarMensaje());
        btnSalir.addActionListener(e -> System.exit(0));
        
        panelBot.add(btnEnviar);
        panelBot.add(btnSalir);
        
        // Añadir componentes
        add(panelSup, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBot, BorderLayout.SOUTH);
        
        // Inicializar socket multicast
        iniciarSocket();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void iniciarSocket() {
        try {
            socket = new MulticastSocket();
            grupo = InetAddress.getByName(GRUPO_MULTICAST);
            areaMensajes.append("Servidor multicast iniciado\n");
            areaMensajes.append("Grupo: " + GRUPO_MULTICAST + "\n");
            areaMensajes.append("Puerto: " + PUERTO + "\n\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al iniciar: " + e.getMessage());
        }
    }
    
    private void enviarMensaje() {
        String mensaje = campoMensaje.getText();
        if (mensaje.isEmpty()) return;
        
        try {
            // Convertir mensaje a bytes
            byte[] buffer = mensaje.getBytes();
            
            // Crear paquete con destino al grupo multicast
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, grupo, PUERTO);
            
            // Enviar paquete
            socket.send(paquete);
            
            // Mostrar mensaje enviado
            areaMensajes.append("Enviado: " + mensaje + "\n");
            campoMensaje.setText("");
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al enviar: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Actividad2_ServidorMulticast();
    }
}
