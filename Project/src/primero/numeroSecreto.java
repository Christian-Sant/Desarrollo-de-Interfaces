package primero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class numeroSecreto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					numeroSecreto frame = new numeroSecreto();
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
	public static int numeroRandom() {
		numeroAleatorio=min+random.nextInt(max - min + 1)
		return 
	}
	public numeroSecreto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Adivina el numero secreto: Entre el 0 y el 100");
		lblTitulo.setFont(new Font("Serif", Font.BOLD, 21));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 414, 60);
		contentPane.add(lblTitulo);
		
		textField = new JTextField();
		textField.setBounds(138, 134, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(172, 165, 89, 23);
		contentPane.add(btnVerificar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(172, 82, 89, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNumeroSecreto = new JLabel("");
		lblNumeroSecreto.setFont(new Font("Serif", Font.BOLD, 21));
		lblNumeroSecreto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroSecreto.setBounds(0, 0, 89, 41);
		panel.add(lblNumeroSecreto);
	}
}
