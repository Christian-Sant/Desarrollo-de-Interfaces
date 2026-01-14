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

public class Crear extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldCiudad;
    private JTextField textFieldEstadio;
    private static futbol futbol = new futbol();
    private static BaseDeDatos bbdd = new BaseDeDatos();
    private static utilidades util = new utilidades();
    private static CrearJugadores jugadores = new CrearJugadores();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Crear frame = new Crear();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Crear() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 369, 209);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(20, 11, 46, 14);
        contentPane.add(lblNombre);

        JLabel lblCiudad = new JLabel("Ciudad");
        lblCiudad.setBounds(20, 48, 46, 14);
        contentPane.add(lblCiudad);

        JLabel lblEstadio = new JLabel("Estadio");
        lblEstadio.setBounds(20, 87, 46, 14);
        contentPane.add(lblEstadio);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(79, 8, 193, 20);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldCiudad = new JTextField();
        textFieldCiudad.setBounds(79, 45, 193, 20);
        contentPane.add(textFieldCiudad);
        textFieldCiudad.setColumns(10);

        textFieldEstadio = new JTextField();
        textFieldEstadio.setBounds(79, 84, 193, 20);
        contentPane.add(textFieldEstadio);
        textFieldEstadio.setColumns(10);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                futbol.setVisible(true);
            }
        });
        btnCancelar.setBounds(20, 136, 89, 23);
        contentPane.add(btnCancelar);

        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int id = util.generarNumeroAleatorio();
                String nombre = textFieldNombre.getText();
                String ciudad = textFieldCiudad.getText();
                String estadio = textFieldEstadio.getText();

                bbdd.sentenciaCrear = "INSERT INTO equipos (id, nombre, ciudad, estadio) VALUES (" +
                    id + ", '" + nombre + "', '" + ciudad + "', '" + estadio + "')";

                bbdd.aniadirEquipo();
                setVisible(false);

                jugadores.setNombreEquipo(nombre); 
                textFieldNombre.setText("");
                textFieldCiudad.setText("");
                textFieldEstadio.setText("");
                jugadores.setVisible(true);
            }
        });
        btnCrear.setBounds(254, 136, 89, 23);
        contentPane.add(btnCrear);
    }
}
