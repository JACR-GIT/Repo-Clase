package com.safa;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClienteFTPBasicoPractica extends JFrame {

    private FTPClient clienteFTP;
    private String servidorActual;

    // Componentes principales
    private JTextArea areaMensajes;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaArchivos;

    // Botones de operaciones
    private JButton btnSubir, btnDescargar, btnEliminar, btnCrearDir, btnEliminarDir, btnRenombrar, btnActualizar;

    // Botones conexión
    private JButton btnConectar;
    private JButton btnDesconectar;

    // Campos de login (se mostrarán en ventana emergente)
    private JTextField txtServidor;
    private JTextField txtUsuario;
    private JPasswordField txtClave;

    public ClienteFTPBasicoPractica() {
        super("Cliente FTP Dinámico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        clienteFTP = new FTPClient();

        crearInterfazPrincipal();

        // Al abrir → mostramos ventana de conexión
        mostrarVentanaConexion();

        setVisible(true);
    }

    private void crearInterfazPrincipal() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        // Área de mensajes
        areaMensajes = new JTextArea(5, 50);
        areaMensajes.setEditable(false);
        JScrollPane scrollMensajes = new JScrollPane(areaMensajes);
        panelPrincipal.add(scrollMensajes, BorderLayout.SOUTH);

        // Lista de archivos
        modeloLista = new DefaultListModel<>();
        listaArchivos = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaArchivos);
        panelPrincipal.add(scrollLista, BorderLayout.CENTER);

        // Panel botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnConectar = new JButton("Conectar");
        btnDesconectar = new JButton("Desconectar");
        btnSubir = new JButton("Subir archivo");
        btnDescargar = new JButton("Descargar");
        btnEliminar = new JButton("Eliminar");
        btnCrearDir = new JButton("Crear carpeta");
        btnEliminarDir = new JButton("Eliminar carpeta");
        btnRenombrar = new JButton("Renombrar");
        btnActualizar = new JButton("Actualizar lista");

        // Inicialmente deshabilitados
        btnDesconectar.setEnabled(false);
        btnSubir.setEnabled(false);
        btnDescargar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCrearDir.setEnabled(false);
        btnEliminarDir.setEnabled(false);
        btnRenombrar.setEnabled(false);
        btnActualizar.setEnabled(false);

        panelBotones.add(btnConectar);
        panelBotones.add(btnDesconectar);
        panelBotones.add(btnSubir);
        panelBotones.add(btnDescargar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCrearDir);
        panelBotones.add(btnEliminarDir);
        panelBotones.add(btnRenombrar);
        panelBotones.add(btnActualizar);

        panelPrincipal.add(panelBotones, BorderLayout.NORTH);

        add(panelPrincipal);

        // Listeners
        btnConectar.addActionListener(e -> mostrarVentanaConexion());

        btnDesconectar.addActionListener(e -> desconectar());

        btnActualizar.addActionListener(e -> listarDirectorio());

        btnSubir.addActionListener(e -> subirArchivo());

        btnDescargar.addActionListener(e -> descargarArchivo());

        btnEliminar.addActionListener(e -> eliminarArchivo());

        btnCrearDir.addActionListener(e -> crearCarpeta());

        // ... puedes añadir los demás listeners siguiendo la misma lógica del cliente original
    }

    private void mostrarVentanaConexion() {
        JPanel panelLogin = new JPanel(new GridLayout(4, 2, 10, 10));

        panelLogin.add(new JLabel("Servidor:"));
        txtServidor = new JTextField("localhost", 20);
        panelLogin.add(txtServidor);

        panelLogin.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField("usuario", 20);
        panelLogin.add(txtUsuario);

        panelLogin.add(new JLabel("Contraseña:"));
        txtClave = new JPasswordField(20);
        panelLogin.add(txtClave);

        int opcion = JOptionPane.showConfirmDialog(
                this,
                panelLogin,
                "Conectar a servidor FTP",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            conectar();
        }
    }

    private void conectar() {
        String servidor = txtServidor.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword());

        if (servidor.isEmpty() || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Servidor y usuario son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            clienteFTP.connect(servidor);
            int reply = clienteFTP.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                clienteFTP.disconnect();
                throw new Exception("Servidor rechazó conexión");
            }

            boolean login = clienteFTP.login(usuario, clave);
            if (!login) {
                clienteFTP.disconnect();
                throw new Exception("Usuario o contraseña incorrectos");
            }

            clienteFTP.enterLocalPassiveMode(); // modo pasivo recomendado
            clienteFTP.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

            servidorActual = servidor;
            JOptionPane.showMessageDialog(this, "CONEXIÓN REALIZADA CON ÉXITO", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Habilitar botones
            btnConectar.setEnabled(false);
            btnDesconectar.setEnabled(true);
            btnSubir.setEnabled(true);
            btnDescargar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnCrearDir.setEnabled(true);
            btnEliminarDir.setEnabled(true);
            btnRenombrar.setEnabled(true);
            btnActualizar.setEnabled(true);

            listarDirectorio();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desconectar() {
        try {
            if (clienteFTP.isConnected()) {
                clienteFTP.logout();
                clienteFTP.disconnect();
            }
            JOptionPane.showMessageDialog(this, "Desconectado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al desconectar");
        }

        modeloLista.clear();
        btnConectar.setEnabled(true);
        btnDesconectar.setEnabled(false);
        btnSubir.setEnabled(false);
        btnDescargar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCrearDir.setEnabled(false);
        btnEliminarDir.setEnabled(false);
        btnRenombrar.setEnabled(false);
        btnActualizar.setEnabled(false);
    }

    private void listarDirectorio() {
        modeloLista.clear();
        try {
            FTPFile[] files = clienteFTP.listFiles();
            for (FTPFile file : files) {
                String tipo = file.isDirectory() ? "[DIR] " : "[Archivo] ";
                modeloLista.addElement(tipo + file.getName());
            }
        } catch (Exception e) {
            areaMensajes.append("Error al listar: " + e.getMessage() + "\n");
        }
    }

    private void subirArchivo() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(archivo)) {
                boolean ok = clienteFTP.storeFile(archivo.getName(), fis);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Archivo subido correctamente");
                    listarDirectorio();
                } else {
                    JOptionPane.showMessageDialog(this, "Fallo al subir", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void descargarArchivo() {
        String seleccionado = listaArchivos.getSelectedValue();
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un archivo");
            return;
        }
        String nombre = seleccionado.substring(seleccionado.indexOf("] ") + 2).trim();

        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File(nombre));
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File destino = chooser.getSelectedFile();
            try (FileOutputStream fos = new FileOutputStream(destino)) {
                boolean ok = clienteFTP.retrieveFile(nombre, fos);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Descargado en: " + destino.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(this, "Fallo al descargar");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void eliminarArchivo() {
        String seleccionado = listaArchivos.getSelectedValue();
        if (seleccionado == null || seleccionado.startsWith("[DIR]")) {
            JOptionPane.showMessageDialog(this, "Selecciona un archivo (no carpeta)");
            return;
        }
        String nombre = seleccionado.substring(seleccionado.indexOf("] ") + 2).trim();

        int confirma = JOptionPane.showConfirmDialog(this, "¿Eliminar " + nombre + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                boolean ok = clienteFTP.deleteFile(nombre);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Eliminado");
                    listarDirectorio();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void crearCarpeta() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre de la nueva carpeta:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            try {
                boolean ok = clienteFTP.makeDirectory(nombre.trim());
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Carpeta creada");
                    listarDirectorio();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo crear");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteFTPBasicoPractica());
    }
}