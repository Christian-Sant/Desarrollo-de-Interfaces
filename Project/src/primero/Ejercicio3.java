package primero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
//CHRISTIAN JAY LAGO
public class Ejercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSeleccionado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 frame = new Ejercicio3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxToyota = new JCheckBox("Toyota");
		chckbxToyota.setBounds(6, 7, 97, 23);
		contentPane.add(chckbxToyota);
		
		JCheckBox chckbxHonda = new JCheckBox("Honda");
		chckbxHonda.setBounds(6, 33, 97, 23);
		contentPane.add(chckbxHonda);
		
		JCheckBox chckbxTesla = new JCheckBox("Tesla");
		chckbxTesla.setBounds(6, 59, 97, 23);
		contentPane.add(chckbxTesla);
		String frases[] = {"No se ha seleccionado ninguna marca","Has seleccionado Toyota", "Has seleccionado Honda", "Has seleccionado Tesla", "Has seleccionado Toyota y Honda", "Has seleccionado Honda y Tesla", "Has seleccionado Toyota y Tesla", "Has seleccionado Toyota, Honda y Tesla"};
		JButton btnComprobarSeleccion = new JButton("Comprobar Selección");
		btnComprobarSeleccion.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(chckbxToyota.isSelected() && chckbxHonda.isSelected() && chckbxTesla.isSelected()) {
					lblSeleccionado.setText(frases[7]);
				}
				else if(chckbxToyota.isSelected() && !chckbxHonda.isSelected() && chckbxTesla.isSelected()) {
					lblSeleccionado.setText(frases[6]);
				}
				else if(!chckbxToyota.isSelected() && chckbxHonda.isSelected() && chckbxTesla.isSelected()) {
					lblSeleccionado.setText(frases[5]);
				}
				else if(chckbxToyota.isSelected() && chckbxHonda.isSelected() && !chckbxTesla.isSelected()) {
					lblSeleccionado.setText(frases[4]);
				}
				else if(!chckbxToyota.isSelected() && !chckbxHonda.isSelected() && chckbxTesla.isSelected()) {
					lblSeleccionado.setText(frases[3]);
				}
				else if(!chckbxToyota.isSelected() && chckbxHonda.isSelected() && !chckbxTesla.isSelected()) {
					lblSeleccionado.setText(frases[2]);
				}
				else if(chckbxToyota.isSelected() && !chckbxHonda.isSelected() && !chckbxTesla.isSelected()) {
					lblSeleccionado.setText(frases[1]);
				}
				else {
					lblSeleccionado.setText(frases[0]);
				}
			}
		});
		btnComprobarSeleccion.setBounds(135, 20, 157, 49);
		contentPane.add(btnComprobarSeleccion);
		
		lblSeleccionado = new JLabel("");
		lblSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionado.setBounds(6, 136, 368, 63);
		contentPane.add(lblSeleccionado);
	}
}
