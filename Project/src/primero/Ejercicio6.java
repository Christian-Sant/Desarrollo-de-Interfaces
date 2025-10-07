package primero;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Ejercicio6 extends JFrame {
	//CHRISTIAN JAY LAGO 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int numeroSpinner;
	int numeroSlider;
	JSpinner spinner;
	JSlider slider;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 frame = new Ejercicio6();
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
	public Ejercicio6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 411);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);
		
		slider = new JSlider();
		slider.setValue(12);
		slider.setMaximum(500);
		slider.setFont(new Font("Arial", Font.PLAIN, 12));
		numeroSlider = slider.getValue();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				numeroSlider = slider.getValue();
				textArea.setFont(new Font("Arial", Font.PLAIN, numeroSlider));
				spinner.setValue(numeroSlider);
			}
		});
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setOrientation(SwingConstants.VERTICAL);
		scrollPane.setRowHeaderView(slider);
		
		spinner = new JSpinner();
		spinner.setValue(12);
		numeroSpinner = (int) spinner.getNextValue() - 1;
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				numeroSpinner = (int) spinner.getNextValue() - 1;
				textArea.setFont(new Font("Arial", Font.PLAIN, numeroSpinner));
				slider.setValue(numeroSpinner);
			}
		});
		scrollPane.setColumnHeaderView(spinner);
	}
}