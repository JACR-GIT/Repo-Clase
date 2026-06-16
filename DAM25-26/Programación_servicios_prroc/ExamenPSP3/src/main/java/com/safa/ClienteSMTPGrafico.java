package com.safa;

import org.apache.commons.net.smtp.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ClienteSMTPGrafico extends JFrame {

    private SMTPClient smtpClient;

    private JTextField txtServidor;
    private JTextField txtPuerto;
    private JTextField txtUsuario;
    private JPasswordField txtClave;

    private JRadioButton rbSinTLS;
    private JRadioButton rbConTLS;

    private JTextField txtDe;
    private JTextField txtPara;
    private JTextField txtAsunto;
    private JTextArea txtCuerpo;

    private JButton btnConectar;
    private JButton btnEnviar;
    private JButton btnDesconectar;

    public ClienteSMTPGrafico() {
        super("Cliente SMTP");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        smtpClient = new SMTPClient();

        crearInterfaz();
        setVisible(true);
    }

    private void crearInterfaz() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelCentro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // ── Conexión ─────────────────────────────────────────────
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("Servidor SMTP:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtServidor = new JTextField("localhost", 30);
        panelCentro.add(txtServidor, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("Puerto:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 2;
        txtPuerto = new JTextField("25", 30);
        panelCentro.add(txtPuerto, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("Usuario:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 2;
        txtUsuario = new JTextField(30);
        panelCentro.add(txtUsuario, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 2;
        txtClave = new JPasswordField(30);
        panelCentro.add(txtClave, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("Seguridad:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 1;
        rbSinTLS = new JRadioButton("Sin TLS", true);
        rbConTLS = new JRadioButton("Con TLS", false);
        ButtonGroup grupoTLS = new ButtonGroup();
        grupoTLS.add(rbSinTLS);
        grupoTLS.add(rbConTLS);

        JPanel panelTLS = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTLS.add(rbSinTLS);
        panelTLS.add(rbConTLS);
        panelCentro.add(panelTLS, gbc);

        // ── Mensaje ───────────────────────────────────────────────
        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("De:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 2;
        txtDe = new JTextField(30);
        panelCentro.add(txtDe, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("Para:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 2;
        txtPara = new JTextField(30);
        panelCentro.add(txtPara, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("Asunto:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 2;
        txtAsunto = new JTextField(30);
        panelCentro.add(txtAsunto, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 1;
        panelCentro.add(new JLabel("Mensaje:"), gbc);

        gbc.gridx = 1; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        txtCuerpo = new JTextArea(10, 40);
        txtCuerpo.setLineWrap(true);
        JScrollPane scrollCuerpo = new JScrollPane(txtCuerpo);
        panelCentro.add(scrollCuerpo, gbc);

        add(panelCentro, BorderLayout.CENTER);

        // Botones inferiores
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnConectar = new JButton("Conectar");
        btnEnviar = new JButton("Enviar mensaje");
        btnDesconectar = new JButton("Desconectar");

        btnEnviar.setEnabled(false);
        btnDesconectar.setEnabled(false);

        panelBotones.add(btnConectar);
        panelBotones.add(btnEnviar);
        panelBotones.add(btnDesconectar);

        add(panelBotones, BorderLayout.SOUTH);

        // Listeners
        btnConectar.addActionListener(e -> conectarSMTP());
        btnEnviar.addActionListener(e -> enviarMensaje());
        btnDesconectar.addActionListener(e -> desconectarSMTP());
    }

    private void conectarSMTP() {
        String servidor = txtServidor.getText().trim();
        String puertoStr = txtPuerto.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword());

        if (servidor.isEmpty() || puertoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Servidor y puerto obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int puerto;
        try {
            puerto = Integer.parseInt(puertoStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Puerto inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            smtpClient.connect(servidor, puerto);
            JOptionPane.showMessageDialog(this, "Conexión realizada");

            if (!usuario.isEmpty()) {
                boolean auth = smtpClient.login(usuario, clave);
                if (auth) {
                    JOptionPane.showMessageDialog(this, "Usuario autenticado");
                } else {
                    JOptionPane.showMessageDialog(this, "Fallo de autenticación", "Error", JOptionPane.ERROR_MESSAGE);
                    smtpClient.disconnect();
                    return;
                }
            }

            if (rbConTLS.isSelected()) {
                smtpClient.execTLS();  // Puede lanzar excepción si falla
                JOptionPane.showMessageDialog(this, "TLS negociado");
            }

            btnConectar.setEnabled(false);
            btnEnviar.setEnabled(true);
            btnDesconectar.setEnabled(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void enviarMensaje() {
        String de = txtDe.getText().trim();
        String para = txtPara.getText().trim();
        String asunto = txtAsunto.getText().trim();
        String cuerpo = txtCuerpo.getText();

        if (de.isEmpty() || para.isEmpty() || asunto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "De, Para y Asunto son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            SimpleSMTPHeader header = new SimpleSMTPHeader(de, para, asunto);

            Writer writer = smtpClient.sendMessageData();

            if (writer != null) {
                writer.write(header.toString());
                writer.write(cuerpo);
                writer.close();

                if (!smtpClient.completePendingCommand()) {
                    throw new Exception("Fallo al completar envío");
                }

                JOptionPane.showMessageDialog(this, "Mensaje enviado correctamente");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al enviar:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desconectarSMTP() {
        try {
            if (smtpClient.isConnected()) {
                smtpClient.logout();
                smtpClient.disconnect();
            }
            JOptionPane.showMessageDialog(this, "Desconectado");

            btnConectar.setEnabled(true);
            btnEnviar.setEnabled(false);
            btnDesconectar.setEnabled(false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al desconectar");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClienteSMTPGrafico::new);
    }
}