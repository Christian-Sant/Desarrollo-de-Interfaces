package futbol;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana para actualizar los datos de un equipo de fútbol.
 * Permite modificar nombre, ciudad y estadio de un equipo existente.
 * 
 * @author Christian
 * @version 1.0
 * @since 2026-01-19
 */
public class ActualizarEquipo extends JFrame {

    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textCiudad;
    private JTextField textEstadio;
    private String nombreOriginal;

    /**
     * Constructor de la ventana ActualizarEquipo.
     * Carga los datos actuales del equipo y permite modificarlos.
     * 
     * @param nombreEquipo Nombre del equipo que se desea actualizar.
     */
    public ActualizarEquipo(String nombreEquipo) {
        this.nombreOriginal = nombreEquipo;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 350, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(20, 11, 80, 14);
        contentPane.add(lblNombre);

        JLabel lblCiudad = new JLabel("Ciudad");
        lblCiudad.setBounds(20, 50, 80, 14);
        contentPane.add(lblCiudad);

        JLabel lblEstadio = new JLabel("Estadio");
        lblEstadio.setBounds(20, 90, 80, 14);
        contentPane.add(lblEstadio);

        textNombre = new JTextField(nombreEquipo);
        textNombre.setBounds(110, 8, 200, 20);
        contentPane.add(textNombre);

        String ciudad = BaseDeDatos.obtenerCiudadEquipo(nombreEquipo);
        textCiudad = new JTextField(ciudad);
        textCiudad.setBounds(110, 47, 200, 20);
        contentPane.add(textCiudad);

        String estadio = BaseDeDatos.obtenerEstadioEquipo(nombreEquipo);
        textEstadio = new JTextField(estadio);
        textEstadio.setBounds(110, 87, 200, 20);
        contentPane.add(textEstadio);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(110, 130, 120, 23);
        contentPane.add(btnActualizar);

        btnActualizar.addActionListener(new ActionListener() {
            /**
             * Evento que se ejecuta al presionar el botón Actualizar.
             * Toma los valores de los campos de texto y actualiza el equipo
             * en la base de datos si todos los campos están completos.
             */
            public void actionPerformed(ActionEvent e) {
                String nuevoNombre = textNombre.getText();
                String nuevaCiudad = textCiudad.getText();
                String nuevoEstadio = textEstadio.getText();

                if(nuevoNombre.isEmpty() || nuevaCiudad.isEmpty() || nuevoEstadio.isEmpty()) return;

                BaseDeDatos.actualizarEquipo(nombreOriginal, nuevoNombre, nuevaCiudad, nuevoEstadio);
                dispose();
            }
        });
    }
}
