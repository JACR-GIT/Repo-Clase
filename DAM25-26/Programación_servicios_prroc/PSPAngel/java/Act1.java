import org.apache.commons.net.ftp.FTPClient;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Act1 extends JFrame {

    private JTextField txtServidor = new JTextField(15);
    private JTextField txtUsuario = new JTextField(15);
    private JPasswordField txtContrasena = new JPasswordField(15);

    private JButton btnConectar = new JButton("Conectar");
    private JButton btnOpcion1 = new JButton("Btn 1");
    private JButton btnOpcion2 = new JButton("Btn 2");

    private FTPClient cliente = new FTPClient();

    public Act1() {
        setTitle("Cliente FTP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setSize(300, 230);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new JLabel("Servidor FTP:"));  add(txtServidor);
        add(new JLabel("Usuario:"));       add(txtUsuario);
        add(new JLabel("Contraseña:"));    add(txtContrasena);
        add(btnConectar);
        add(btnOpcion1);
        add(btnOpcion2);

        btnOpcion1.setEnabled(false);
        btnOpcion2.setEnabled(false);

        btnConectar.addActionListener(e -> conectar());
    }

    private void conectar() {
        try {
            cliente.connect(txtServidor.getText().trim().toLowerCase());
            boolean login = cliente.login(txtUsuario.getText().trim(),
                    new String(txtContrasena.getPassword()));
            if (login) {
                JOptionPane.showMessageDialog(this, "CONEXIÓN REALIZADA CON ÉXITO");
                btnOpcion1.setEnabled(true);
                btnOpcion2.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Login incorrecto.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                cliente.disconnect();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se puede realizar la conexión:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Act1().setVisible(true));
    }
}