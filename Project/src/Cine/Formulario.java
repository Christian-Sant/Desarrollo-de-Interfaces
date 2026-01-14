package Cine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Formulario extends JFrame {

    private static final long serialVersionUID = 1L;
    private CineApp menu;
    private DefaultListModel<Pelicula> modelo;

    private JTextField titulo;
    private JComboBox<String> tipo;
    private JTextArea resumen;
    private String rutaImagen;

    public Formulario(CineApp menu, DefaultListModel<Pelicula> modelo) {
        this.menu = menu;
        this.modelo = modelo;

        setTitle("Nueva Película");
        setBounds(100, 100, 450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(30, 20, 80, 14);
        contentPane.add(lblTitulo);

        titulo = new JTextField();
        titulo.setBounds(110, 17, 180, 20);
        contentPane.add(titulo);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 60, 80, 14);
        contentPane.add(lblTipo);

        tipo = new JComboBox<>(new String[]{"", "Acción", "Comedia", "Drama", "Ciencia ficción"});
        tipo.setBounds(110, 57, 180, 22);
        contentPane.add(tipo);

        JLabel lblResumen = new JLabel("Resumen:");
        lblResumen.setBounds(30, 110, 80, 14);
        contentPane.add(lblResumen);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(110, 110, 260, 150);
        contentPane.add(scroll);

        resumen = new JTextArea();
        resumen.setLineWrap(true);
        resumen.setWrapStyleWord(true);
        scroll.setViewportView(resumen);

        JButton btnImagen = new JButton("Seleccionar imagen");
        btnImagen.setBounds(110, 280, 160, 23);
        btnImagen.addActionListener(e -> seleccionarImagen());
        contentPane.add(btnImagen);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(300, 320, 90, 23);
        btnAceptar.addActionListener(e -> aceptar());
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 320, 90, 23);
        btnCancelar.addActionListener(e -> cancelar());
        contentPane.add(btnCancelar);
    }

    private void seleccionarImagen() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            rutaImagen = chooser.getSelectedFile().getAbsolutePath();
    }

    private void aceptar() {
        if (titulo.getText().trim().isEmpty() || tipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Completa título y tipo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pelicula pelicula = new Pelicula(
            titulo.getText(),
            (String) tipo.getSelectedItem(),
            resumen.getText(),
            rutaImagen
        );

        modelo.addElement(pelicula);
        menu.volverAlMenu(); 
        dispose();
    }

    private void cancelar() {
        menu.volverAlMenu();
        dispose();
    }
}
