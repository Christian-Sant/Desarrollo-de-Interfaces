package lambda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSi;
	private JButton btnNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSi= new JButton("Si");
		btnSi.addActionListener(e -> {
			if(btnNo.getText().equals("No")){
				btnNo.setText("Si");
			}
			else {
				btnNo.setText("No");
			}
		});
		btnSi.setBounds(10, 46, 180, 44);
		contentPane.add(btnSi);
		
		btnNo = new JButton("No");
		btnNo.addActionListener(e -> {
			if(btnSi.getText().equals("No")){
				btnSi.setText("Si");
			}
			else {
				btnSi.setText("No");
			}
		});
		btnNo.setBounds(229, 46, 180, 44);
		contentPane.add(btnNo);
	}
}
