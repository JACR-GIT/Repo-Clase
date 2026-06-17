import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Examen1_Cliente extends JFrame {

    private JTextArea areaMensajes;
    private MulticastSocket socket;
    private InetAddress grupo;
    private final String GRUPO_MULTICAST = "225.0.0.1";
    private final int PUERTO = 12345;
    private String nombre;
    private volatile boolean ejecutando = true;

    public Examen1_Cliente() {
        nombre = JOptionPane.showInputDialog(this,
                "Introduce tu nombre:",
                "Nombre de Usuario",
                JOptionPane.QUESTION_MESSAGE);

        if (nombre == null || nombre.trim().isEmpty()) {
            nombre = "Usuario";
        }

        setTitle("Cliente Chat - " + nombre);
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);
        areaMensajes.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(areaMensajes);
        scroll.setBorder(BorderFactory.createTitledBorder("Mensajes del Servidor"));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> salir());
        panelBotones.add(btnSalir);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        iniciarSocket();

        iniciarRecepcion();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarSocket() {
        try {
            socket = new MulticastSocket(PUERTO);
            grupo = InetAddress.getByName(GRUPO_MULTICAST);

            NetworkInterface interfaz = NetworkInterface.getByInetAddress(
                    InetAddress.getLocalHost());
            socket.joinGroup(new InetSocketAddress(grupo, PUERTO), interfaz);

            areaMensajes.append(" CONECTADO AL CHAT\n");
            areaMensajes.append("Usuario: " + nombre + "\n");
            areaMensajes.append("Esperando mensajes...\n");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al conectar: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void iniciarRecepcion() {
        Thread hiloRecepcion = new Thread(() -> {
            byte[] buffer = new byte[1024];

            while (ejecutando) {
                try {
                    DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                    socket.receive(paquete);

                    String mensaje = new String(paquete.getData(), 0, paquete.getLength());

                    SwingUtilities.invokeLater(() ->
                            areaMensajes.append("Servidor: " + mensaje + "\n"));

                } catch (IOException e) {
                    if (ejecutando) {
                        System.err.println("Error al recibir mensaje: " + e.getMessage());
                    }
                }
            }
        });

        hiloRecepcion.start();
    }

    private void salir() {
        ejecutando = false;

        try {
            if (socket != null && !socket.isClosed()) {
                // Salir del grupo multicast
                NetworkInterface interfaz = NetworkInterface.getByInetAddress(
                        InetAddress.getLocalHost());
                socket.leaveGroup(new InetSocketAddress(grupo, PUERTO), interfaz);
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Examen1_Cliente());
    }
}
