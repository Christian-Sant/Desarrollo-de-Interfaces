package primero;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

public class prueba4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba4 frame = new prueba4();
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
	public prueba4() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Crear el menú "Archivo"
		JMenu fileMenu = new JMenu("Archivo");
		// Crear los elementos del menú "Abrir" y "Guardar"
		
		// Asignar aceleradores de teclado a los elementos del menú
		openItem.setAccelerator (KeyStroke.getKeyStroke("ctrl A")); // Ctrl+A
		saveItem.setAccelerator (KeyStroke.getKeyStroke("ctrl G")); // Ctrl+G
		// Agregar acciones a los elementos del menú
		openItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Opción 'Abrir' seleccionada.");
		}
		});
		saveItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Opción 'Guardar' seleccionada.");
		}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		mnNewMenu.setMnemonic (KeyEvent.VK_A);

		JMenuItem mntmCerrar = new JMenuItem("New menu item");
		mnNewMenu.add(mntmCerrar);
		
		JMenuItem mntmAbrir = new JMenuItem("New menu item");
		mnNewMenu.add(mntmAbrir);
		
		mntmAbrir.setAccelerator (KeyStroke.getKeyStroke("ctrl A")); // Ctrl+A
		mntmCerrar.setAccelerator (KeyStroke.getKeyStroke("ctrl G")); // Ctrl+G
		setContentPane(contentPane);
		contentPane.setLayout(null);*/
	}
}
