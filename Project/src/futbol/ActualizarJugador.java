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

public class ActualizarJugador extends JFrame {

    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textPosicion;
    private String nombreOriginal;
    private String nombreEquipo;

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
