package practicas;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * ACTIVIDAD 6 - CLIENTE MASTERMIND
 * Interfaz gráfica para jugar al Mastermind.
 */
public class Actividad6_ClienteMastermind extends JFrame {
    
    private JLabel lblId, lblIntentos;
    private JTextField[] campos;
    private JTextArea areaAciertos, areaCoincidencias;
    private JButton btnEnviar, btnLimpiar, btnSalir;
    
    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private int idJugador;
    
    public Actividad6_ClienteMastermind() {
        // Conectar al servidor primero
        if (!conectar()) {
            System.exit(1);
        }
        
        // Configurar ventana
        setTitle("MASTERMIND - Jugador " + idJugador);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Panel superior - ID e intentos
        JPanel panelSup = new JPanel(new GridLayout(2, 1));
        lblId = new JLabel("ID Jugador: " + idJugador, SwingConstants.CENTER);
        lblId.setFont(new Font("Arial", Font.BOLD, 16));
        lblIntentos = new JLabel("Intentos restantes: 10", SwingConstants.CENTER);
        panelSup.add(lblId);
        panelSup.add(lblIntentos);
        
        // Panel central - Números
        JPanel panelNumeros = new JPanel(new GridLayout(2, 4, 5, 5));
        campos = new JTextField[4];
        for (int i = 0; i < 4; i++) {
            panelNumeros.add(new JLabel("Número " + (i+1) + ":", SwingConstants.CENTER));
        }
        for (int i = 0; i < 4; i++) {
            campos[i] = new JTextField();
            campos[i].setHorizontalAlignment(JTextField.CENTER);
            panelNumeros.add(campos[i]);
        }
        
        // Panel de resultados
        JPanel panelResultados = new JPanel(new GridLayout(1, 2, 10, 10));
        
        areaAciertos = new JTextArea();
        areaAciertos.setEditable(false);
        JScrollPane scroll1 = new JScrollPane(areaAciertos);
        scroll1.setBorder(BorderFactory.createTitledBorder("Aciertos"));
        
        areaCoincidencias = new JTextArea();
        areaCoincidencias.setEditable(false);
        JScrollPane scroll2 = new JScrollPane(areaCoincidencias);
        scroll2.setBorder(BorderFactory.createTitledBorder("Coincidencias"));
        
        panelResultados.add(scroll1);
        panelResultados.add(scroll2);
        
        // Panel inferior - Botones
        JPanel panelBot = new JPanel();
        btnEnviar = new JButton("Enviar");
        btnLimpiar = new JButton("Limpiar");
        btnSalir = new JButton("Salir");
        
        btnEnviar.addActionListener(e -> enviar());
        btnLimpiar.addActionListener(e -> limpiar());
        btnSalir.addActionListener(e -> System.exit(0));
        
        panelBot.add(btnEnviar);
        panelBot.add(btnLimpiar);
        panelBot.add(btnSalir);
        
        // Añadir todo
        add(panelSup, BorderLayout.NORTH);
        add(panelNumeros, BorderLayout.CENTER);
        add(panelResultados, BorderLayout.SOUTH);
        add(panelBot, BorderLayout.PAGE_END);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private boolean conectar() {
        try {
            socket = new Socket("localhost", 6000);
            
            // IMPORTANTE: Crear ObjectOutputStream PRIMERO y hacer flush
            salida = new ObjectOutputStream(socket.getOutputStream());
            salida.flush();
            entrada = new ObjectInputStream(socket.getInputStream());
            
            // Recibir ID y estado del juego
            idJugador = entrada.readInt();
            boolean juegoTerminado = entrada.readBoolean();
            
            if (juegoTerminado) {
                JOptionPane.showMessageDialog(null, "El juego ya ha terminado");
                return false;
            }
            
            return true;
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar: " + e.getMessage());
            return false;
        }
    }
    
    private void enviar() {
        try {
            // Validar y obtener números
            int[] combinacion = new int[4];
            for (int i = 0; i < 4; i++) {
                String texto = campos[i].getText().trim();
                if (texto.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Completa todos los números");
                    return;
                }
                
                int num = Integer.parseInt(texto);
                if (num < 0 || num > 9) {
                    JOptionPane.showMessageDialog(this, "Los números deben ser entre 0 y 9");
                    return;
                }
                combinacion[i] = num;
            }
            
            // Verificar que no haya repetidos
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (combinacion[i] == combinacion[j]) {
                        JOptionPane.showMessageDialog(this, "No puedes repetir números");
                        return;
                    }
                }
            }
            
            // Enviar al servidor
            salida.writeObject(combinacion);
            salida.flush();
            
            // Recibir respuesta
            RespuestaMastermind resp = (RespuestaMastermind) entrada.readObject();
            
            // Actualizar interfaz
            int numIntento = 10 - resp.getIntentosRestantes();
            areaAciertos.append("Intento " + numIntento + ": " + resp.getAciertos() + " aciertos\n");
            areaCoincidencias.append("Intento " + numIntento + ": " + resp.getCoincidencias() + " coincidencias\n");
            lblIntentos.setText("Intentos restantes: " + resp.getIntentosRestantes());
            
            if (resp.isGanador()) {
                JOptionPane.showMessageDialog(this, "¡FELICIDADES! Has ganado");
                btnEnviar.setEnabled(false);
            } else if (resp.isJuegoTerminado()) {
                JOptionPane.showMessageDialog(this, "Otro jugador ha ganado");
                btnEnviar.setEnabled(false);
            } else if (resp.getIntentosRestantes() == 0) {
                JOptionPane.showMessageDialog(this, "Se acabaron los intentos");
                btnEnviar.setEnabled(false);
            }
            
            limpiar();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduce números válidos");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void limpiar() {
        for (int i = 0; i < 4; i++) {
            campos[i].setText("");
        }
    }
    
    public static void main(String[] args) {
        new Actividad6_ClienteMastermind();
    }
}
