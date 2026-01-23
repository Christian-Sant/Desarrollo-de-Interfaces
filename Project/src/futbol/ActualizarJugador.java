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
 * Ventana para actualizar los datos de un jugador de fútbol.
 * Permite modificar el nombre y la posición de un jugador existente en un equipo.
 * 
 * @author Christian
 * @version 1.0
 * @since 2026-01-19
 * @see BaseDeDatos#actualizarJugador(String, String, String, String)
 */
public class ActualizarJugador extends JFrame {

    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textPosicion;
    private String nombreOriginal;
    private String nombreEquipo;

    /**
     * Constructor de la ventana ActualizarJugador.
     * Carga los datos actuales del jugador y permite modificarlos.
     * 
     * @param nombreJugador Nombre del jugador que se desea actualizar.
     * @param equipo Nombre del equipo al que pertenece el jugador.
     */
    public ActualizarJugador(String nombreJugador, String equipo) {
        this.nombreOriginal = nombreJugador;
        this.nombreEquipo = equipo;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 350, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(20, 11, 80, 14);
        contentPane.add(lblNombre);

        JLabel lblPosicion = new JLabel("Posición");
        lblPosicion.setBounds(20, 50, 80, 14);
        contentPane.add(lblPosicion);

        textNombre = new JTextField(nombreJugador);
        textNombre.setBounds(110, 8, 200, 20);
        contentPane.add(textNombre);

        String posicion = BaseDeDatos.obtenerPosicionJugador(nombreJugador, equipo);
        textPosicion = new JTextField(posicion);
        textPosicion.setBounds(110, 47, 200, 20);
        contentPane.add(textPosicion);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(110, 90, 120, 23);
        contentPane.add(btnActualizar);

        btnActualizar.addActionListener(new ActionListener() {
            /**
             * Evento que se ejecuta al presionar el botón Actualizar.
             * Actualiza los datos del jugador en la base de datos si todos los
             * campos están completos, limpia los campos y cierra la ventana.
             */
            public void actionPerformed(ActionEvent e) {
                String nuevoNombre = textNombre.getText();
                String nuevaPosicion = textPosicion.getText();

                if(nuevoNombre.isEmpty() || nuevaPosicion.isEmpty()) return;

                BaseDeDatos.actualizarJugador(nombreOriginal, nombreEquipo, nuevoNombre, nuevaPosicion);
                textNombre.setText("");
                textPosicion.setText("");
                dispose();
            }
        });
    }
}
