package practicas;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * ACTIVIDAD 5 - CLIENTE CON INTERFAZ GRÁFICA
 * Envía cadenas al servidor y recibe la versión en mayúsculas.
 */
public class Actividad5_Cliente extends JFrame {
    
    private JTextField campoTexto, campoMayusculas;
    private Socket socket;
    private DataOutputStream salida;
    private DataInputStream entrada;
    
    public Actividad5_Cliente() {
        // Configurar ventana
        setTitle("Cliente - Convertir a Mayúsculas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));
        
        // Crear componentes
        add(new JLabel("Escribe una cadena:"));
        campoTexto = new JTextField();
        add(campoTexto);
        
        add(new JLabel("Cadena en mayúsculas:"));
        campoMayusculas = new JTextField();
        campoMayusculas.setEditable(false);
        add(campoMayusculas);
        
        JButton btnEnviar = new JButton("Enviar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnSalir = new JButton("Salir");
        
        btnEnviar.addActionListener(e -> enviar());
        btnLimpiar.addActionListener(e -> limpiar());
        btnSalir.addActionListener(e -> salir());
        
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnEnviar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);
        
        add(new JLabel("")); // Espacio vacío
        add(panelBotones);
        
        // Conectar al servidor
        conectar();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void conectar() {
        try {
            socket = new Socket("localhost", 44444);
            salida = new DataOutputStream(socket.getOutputStream());
            entrada = new DataInputStream(socket.getInputStream());
            JOptionPane.showMessageDialog(this, "Conectado al servidor");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar: " + e.getMessage());
            System.exit(1);
        }
    }
    
    private void enviar() {
        String texto = campoTexto.getText();
        if (texto.isEmpty()) return;
        
        try {
            // Enviar al servidor
            salida.writeUTF(texto);
            
            // Recibir respuesta
            String mayusculas = entrada.readUTF();
            campoMayusculas.setText(mayusculas);
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void limpiar() {
        campoTexto.setText("");
        campoMayusculas.setText("");
    }
    
    private void salir() {
        try {
            // Enviar * para cerrar
            salida.writeUTF("*");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    
    public static void main(String[] args) {
        new Actividad5_Cliente();
    }
}
