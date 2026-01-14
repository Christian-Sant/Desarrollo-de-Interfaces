package futbol;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearJugadores extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldPosicion;
    private int contador = 0;
    private int totalJugadores = 0;
    private String nombreEquipo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CrearJugadores frame = new CrearJugadores();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CrearJugadores() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        JLabel lblNombre = new JLabel("Nombre jugador");
        lblNombre.setBounds(20, 11, 120, 14);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(150, 8, 200, 20);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblPosicion = new JLabel("Posición");
        lblPosicion.setBounds(20, 50, 120, 14);
        contentPane.add(lblPosicion);

        textFieldPosicion = new JTextField();
        textFieldPosicion.setBounds(150, 47, 200, 20);
        contentPane.add(textFieldPosicion);
        textFieldPosicion.setColumns(10);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(150, 90, 100, 23);
        contentPane.add(btnAceptar);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreJugador = textFieldNombre.getText();
                String posicion = textFieldPosicion.getText();

                if (nombreJugador.isEmpty() || posicion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                BaseDeDatos.aniadirJugador(nombreJugador, posicion, nombreEquipo);

                contador++;

                if (contador < totalJugadores) {
                    textFieldNombre.setText("");
                    textFieldPosicion.setText("");
                    JOptionPane.showMessageDialog(null, "Jugador creado. Siguiente...");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los jugadores creados");
                    dispose();
                    futbol frame = new futbol();
                    frame.setVisible(true);
                }
            }
        });
    }

    public void preguntarNumeroJugadores() {
        String input = JOptionPane.showInputDialog("¿Cuántos jugadores quieres crear para el equipo " + nombreEquipo + "?");
        try {
            totalJugadores = Integer.parseInt(input);
            if (totalJugadores <= 0) {
                JOptionPane.showMessageDialog(null, "Número inválido, se tomará 1 jugador por defecto");
                totalJugadores = 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida, se tomará 1 jugador por defecto");
            totalJugadores = 1;
        }
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        preguntarNumeroJugadores();
    }
}
