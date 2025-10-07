package primero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
//CHRISTIAN JAY LAGO
public class Ejercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
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
	public Ejercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 384, 22);
		contentPane.add(menuBar);
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);
		
		JMenuItem itemNuevo = new JMenuItem("Nuevo");
		menuArchivo.add(itemNuevo);
		
		JMenuItem itemAbrir = new JMenuItem("Abrir");
		menuArchivo.add(itemAbrir);
		
		JMenuItem itemSalir = new JMenuItem("Salir");
		menuArchivo.add(itemSalir);
		
		JMenu menuEditar = new JMenu("Editar");
		menuBar.add(menuEditar);
		
		JMenuItem itemCopiar = new JMenuItem("Copiar");
		menuEditar.add(itemCopiar);
		
		JMenuItem itemPegarDentro = new JMenuItem("Pegar dentro");
		menuEditar.add(itemPegarDentro);
		
		JMenu menuFormato = new JMenu("Formato");
		menuBar.add(menuFormato);
		
		JMenuItem itemNegrita = new JMenuItem("Negrita");
		menuFormato.add(itemNegrita);
		
		JMenuItem itemCursiva = new JMenuItem("Cursiva");
		menuFormato.add(itemCursiva);
	}
}
