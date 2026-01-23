package futbol;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Ventana principal de la aplicación de gestión de fútbol.
 * Permite crear, actualizar y eliminar equipos y jugadores.
 * Muestra listas de equipos y jugadores y gestiona la navegación entre ventanas.
 * 
 * @author Christian
 * @version 1.0
 * @since 2026-01-19
 * @see Crear
 * @see ActualizarEquipo
 * @see ActualizarJugador
 * @see BaseDeDatos
 */
public class futbol extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblEquipos;
    private JLabel lblJugadores;
    private static Crear crear = new Crear();

    private JList<String> listEquipos;
    private JList<String> listJugadores;

    /**
     * Método principal que inicia la ventana principal de la aplicación.
     * 
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    futbol frame = new futbol();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor de la ventana principal.
     * Inicializa botones, listas y etiquetas, y carga los equipos existentes.
     */
    public futbol() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 557, 479);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            /**
             * Muestra la ventana Crear para añadir un nuevo equipo.
             */
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                crear.setVisible(true);
            }
        });
        btnCrear.setBounds(20, 389, 89, 23);
        contentPane.add(btnCrear);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            /**
             * Abre la ventana de actualización para el equipo o jugador seleccionado.
             * Muestra un aviso si no se ha seleccionado ningún elemento.
             */
            public void actionPerformed(ActionEvent e) {
                String equipoSeleccionado = listEquipos.getSelectedValue();
                String jugadorSeleccionado = listJugadores.getSelectedValue();

                if (equipoSeleccionado != null) {
                    ActualizarEquipo frameEquipo = new ActualizarEquipo(equipoSeleccionado);
                    frameEquipo.setVisible(true);
                } else if (jugadorSeleccionado != null) {
                    String nombreEquipo = listEquipos.getSelectedValue(); 
                    ActualizarJugador frameJugador = new ActualizarJugador(jugadorSeleccionado, nombreEquipo);
                    frameJugador.setVisible(true);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "Selecciona un equipo o un jugador para actualizar",
                        "Aviso",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });
        btnActualizar.setBounds(209, 389, 110, 23);
        contentPane.add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            /**
             * Elimina el equipo seleccionado y todos sus jugadores.
             * Solicita confirmación antes de eliminar.
             */
            public void actionPerformed(ActionEvent e) {
                String equipoSeleccionado = listEquipos.getSelectedValue();

                if (equipoSeleccionado == null) {
                    javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "Selecciona un equipo para eliminar",
                        "Aviso",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quieres eliminar el equipo y todos sus jugadores?",
                    "Confirmar eliminación",
                    javax.swing.JOptionPane.YES_NO_OPTION
                );

                if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                    BaseDeDatos.eliminarEquipoPorNombre(equipoSeleccionado);
                    cargarEquipos();
                    cargarJugadores(null);
                }
            }
        });
        btnEliminar.setBounds(430, 389, 89, 23);
        contentPane.add(btnEliminar);

        listEquipos = new JList<String>();
        listEquipos.setBounds(20, 104, 149, 221);
        listEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contentPane.add(listEquipos);

        listJugadores = new JList<String>();
        listJugadores.setBounds(232, 104, 259, 221);
        contentPane.add(listJugadores);

        lblEquipos = new JLabel("Equipos");
        lblEquipos.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipos.setBounds(20, 68, 149, 14);
        contentPane.add(lblEquipos);

        lblJugadores = new JLabel("Jugadores");
        lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
        lblJugadores.setBounds(292, 68, 149, 14);
        contentPane.add(lblJugadores);

        cargarEquipos();

        listEquipos.addListSelectionListener(new ListSelectionListener() {
            /**
             * Al seleccionar un equipo, carga la lista de jugadores correspondientes.
             */
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String equipoSeleccionado = listEquipos.getSelectedValue();
                    cargarJugadores(equipoSeleccionado);
                }
            }
        });
    }

    /**
     * Carga todos los equipos desde la base de datos y los muestra en la lista.
     */
    private void cargarEquipos() {
        DefaultListModel<String> modelo = new DefaultListModel<String>();
        ArrayList<String> equipos = BaseDeDatos.obtenerNombresEquipos();

        for (String nombre : equipos) {
            modelo.addElement(nombre);
        }

        listEquipos.setModel(modelo);
    }

    /**
     * Carga los jugadores del equipo especificado y los muestra en la lista.
     * 
     * @param nombreEquipo Nombre del equipo cuyos jugadores se cargarán. Puede ser null.
     */
    private void cargarJugadores(String nombreEquipo) {
        DefaultListModel<String> modelo = new DefaultListModel<String>();

        if (nombreEquipo != null) {
            ArrayList<String> jugadores = BaseDeDatos.obtenerJugadoresPorEquipo(nombreEquipo);
            for (String jugador : jugadores) {
                modelo.addElement(jugador);
            }
        }

        listJugadores.setModel(modelo);
    }
}
