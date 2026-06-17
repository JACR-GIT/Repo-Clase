import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.swing.*;
import java.awt.*;
import java.io.Writer;

public class Act2 extends JFrame {

    AuthenticatingSMTPClient client;

    public JTextField txtServidor = new JTextField(15);
    public JTextField txtPuerto = new JTextField(15);
    public JTextField txtUsuario = new JTextField(15);
    public JPasswordField txtContrasena = new JPasswordField(15);

    public JTextField txtRemitente = new JTextField(15);
    public JTextField txtDestinatario = new JTextField(15);
    public JTextField txtAsunto = new JTextField(15);
    public JTextArea txtCuerpo = new JTextArea(5, 15);

    public JRadioButton rbSinTLS = new JRadioButton("Sin TLS", true);
    public JRadioButton rbConTLS = new JRadioButton("Con TLS");

    public JButton btnConectar = new JButton("Conectar");
    public JButton btnDesconectar = new JButton("Desconectar");
    public JButton btnEnviar = new JButton("Enviar mensaje");

    public Act2() {
        setTitle("Cliente SMTP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelConexion = new JPanel(new GridLayout(5, 2, 8, 8));
        panelConexion.setBorder(BorderFactory.createTitledBorder("Conexión"));
        panelConexion.add(new JLabel("Servidor SMTP:"));  panelConexion.add(txtServidor);
        panelConexion.add(new JLabel("Puerto:"));         panelConexion.add(txtPuerto);
        panelConexion.add(new JLabel("Usuario:"));        panelConexion.add(txtUsuario);
        panelConexion.add(new JLabel("Contraseña:"));     panelConexion.add(txtContrasena);

        ButtonGroup grupTLS = new ButtonGroup();
        grupTLS.add(rbSinTLS);
        grupTLS.add(rbConTLS);
        JPanel panelTLS = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelTLS.add(rbSinTLS);
        panelTLS.add(rbConTLS);
        panelConexion.add(new JLabel("Negociación SSL/TLS:"));
        panelConexion.add(panelTLS);

        JPanel panelCorreo = new JPanel(new GridLayout(4, 2, 8, 8));
        panelCorreo.setBorder(BorderFactory.createTitledBorder("Datos del correo"));
        panelCorreo.add(new JLabel("Remitente:"));    panelCorreo.add(txtRemitente);
        panelCorreo.add(new JLabel("Destinatario:")); panelCorreo.add(txtDestinatario);
        panelCorreo.add(new JLabel("Asunto:"));       panelCorreo.add(txtAsunto);
        panelCorreo.add(new JLabel("Cuerpo:"));
        panelCorreo.add(new JScrollPane(txtCuerpo));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnDesconectar.setEnabled(false);
        btnEnviar.setEnabled(false);
        panelBotones.add(btnConectar);
        panelBotones.add(btnDesconectar);
        panelBotones.add(btnEnviar);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(panelConexion);
        panelPrincipal.add(Box.createVerticalStrut(10));
        panelPrincipal.add(panelCorreo);
        panelPrincipal.add(Box.createVerticalStrut(10));
        panelPrincipal.add(panelBotones);

        add(panelPrincipal);

        btnConectar.addActionListener(e -> conectar());
        btnEnviar.addActionListener(e -> enviar());
        btnDesconectar.addActionListener(e -> desconectar());
    }

    public void conectar() {
        try {
            String server = txtServidor.getText().trim();
            int puerto = Integer.parseInt(txtPuerto.getText().trim());
            String username = txtUsuario.getText().trim();
            String password = new String(txtContrasena.getPassword());

            if (rbConTLS.isSelected()) {
                client = new AuthenticatingSMTPClient();
            } else {
                client = new AuthenticatingSMTPClient("SSL");
            }

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(null, null);
            KeyManager km = kmf.getKeyManagers()[0];
            client.setKeyManager(km);

            client.connect(server, puerto);

            int respuesta = client.getReplyCode();
            if (!SMTPReply.isPositiveCompletion(respuesta)) {
                client.disconnect();
                JOptionPane.showMessageDialog(this, "Conexión rechazada por el servidor.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            client.ehlo(server);

            if (rbConTLS.isSelected()) {
                if (!client.execTLS()) {
                    JOptionPane.showMessageDialog(this, "No se pudo establecer TLS.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    client.disconnect();
                    return;
                }
                client.ehlo(server);
            }

            if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {
                JOptionPane.showMessageDialog(this, "Usuario autenticado. Conexión realizada.");
                btnConectar.setEnabled(false);
                btnDesconectar.setEnabled(true);
                btnEnviar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Login incorrecto.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                client.disconnect();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El puerto debe ser un número.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede realizar la conexión:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void enviar() {
        try {
            String remitente    = txtRemitente.getText().trim();
            String destinatario = txtDestinatario.getText().trim();
            String asunto       = txtAsunto.getText().trim();
            String cuerpo       = txtCuerpo.getText().trim();

            SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destinatario, asunto);

            client.setSender(remitente);
            client.addRecipient(destinatario);

            Writer writer = client.sendMessageData();
            if (writer == null) {
                JOptionPane.showMessageDialog(this, "Fallo al iniciar el envío de datos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            writer.write(cabecera.toString());
            writer.write(cuerpo);
            writer.close();

            if (client.completePendingCommand()) {
                JOptionPane.showMessageDialog(this, "Mensaje enviado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "Fallo al enviar el mensaje.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al enviar el mensaje:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void desconectar() {
        try {
            if (client != null && client.isConnected()) {
                client.disconnect();
            }
            JOptionPane.showMessageDialog(this, "Desconexión realizada.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al desconectar:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            btnConectar.setEnabled(true);
            btnDesconectar.setEnabled(false);
            btnEnviar.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Act2().setVisible(true));
    }
}