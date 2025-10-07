package primero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
//CHRISTIAN JAY LAGO
public class Ejercicio4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 frame = new Ejercicio4();
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
	public Ejercicio4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(149, 10, 140, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(35, 13, 81, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña: ");
		lblPassword.setBounds(35, 42, 104, 14);
		contentPane.add(lblPassword);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(10, 140, 364, 31);
		contentPane.add(lblMensaje);
		
		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(149, 41, 140, 20);
		contentPane.add(passwordPassword);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textUsuario.getText().equals("admin") && !passwordPassword.getText().equals("1234")) {
					lblMensaje.setText("El usuario y la password son incorrectos.");
				
				}
				else if(!textUsuario.getText().equals("admin")) {
					lblMensaje.setText("El usuario introducido no es correcto.");
				}
				else if(!passwordPassword.getText().equals("1234")) {
					lblMensaje.setText("La password introducida no es correcta.");
					
				}
				else {
					lblMensaje.setText("Todo esta correcto");
				}
			}
		});
		btnVerificar.setBounds(149, 88, 89, 23);
		contentPane.add(btnVerificar);
		
		
	}
}