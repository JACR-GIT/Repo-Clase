import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Examen1_Servidor extends JFrame {
    private JTextField campoMensaje;
    private JTextArea areaMensajes;
    private MulticastSocket socket;
    private InetAddress grupo;
    private final String GRUPO_MULTICAST = "225.0.0.1";
    private final int PUERTO = 12345;

    public Examen1_Servidor() {
        setTitle("Servidor Chat UDP");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new BorderLayout(5, 5));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        panelSuperior.add(new JLabel("Mensaje: "), BorderLayout.WEST);
        campoMensaje = new JTextField();
        panelSuperior.add(campoMensaje, BorderLayout.CENTER);

        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);
        areaMensajes.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(areaMensajes);
        scroll.setBorder(BorderFactory.createTitledBorder("Mensajes Enviados"));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnEnviar = new JButton("Enviar");
        JButton btnSalir = new JButton("Salir");

        btnEnviar.addActionListener(e -> enviarMensaje());
        btnSalir.addActionListener(e -> salir());

        panelBotones.add(btnEnviar);
        panelBotones.add(btnSalir);

        // Añadir componentes a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        iniciarSocket();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarSocket() {
        try {
            socket = new MulticastSocket();
            grupo = InetAddress.getByName(GRUPO_MULTICAST);

            areaMensajes.append("SERVIDOR CHAT UDP INICIADO\n");
            areaMensajes.append("Grupo Multicast: " + GRUPO_MULTICAST + "\n");
            areaMensajes.append("Puerto: " + PUERTO + "\n");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al iniciar socket: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void enviarMensaje() {
        String mensaje = campoMensaje.getText().trim();

        if (mensaje.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debes escribir un mensaje",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Convertir mensaje a bytes
            byte[] buffer = mensaje.getBytes();

            // Crear paquete multicast
            DatagramPacket paquete = new DatagramPacket(
                    buffer, buffer.length, grupo, PUERTO);

            // Enviar paquete
            socket.send(paquete);

            // Mostrar en el área de texto
            areaMensajes.append("Servidor: " + mensaje + "\n");

            // Limpiar campo de texto
            campoMensaje.setText("");
            campoMensaje.requestFocus();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al enviar mensaje: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void salir() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Examen1_Servidor());
    }
}
