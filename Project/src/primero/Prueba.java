package primero;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Prueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BufferedImage ventana;
	private Graphics2D grafico;
	private int x, y;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Prueba frame = new Prueba();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// Crear el panel personalizado
		contentPane = new MiPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Crear imagen del tamaño del panel
		ventana = new BufferedImage(440, 260, BufferedImage.TYPE_INT_RGB);
		grafico = ventana.createGraphics();
		grafico.setColor(Color.WHITE);
		grafico.fillRect(0, 0, ventana.getWidth(), ventana.getHeight());

		// Listeners del mouse
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				dibujar(x, y);
			}
		});

		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				dibujar(x, y);
			}
		});
	}

	private void dibujar(int x, int y) {
		grafico.setColor(Color.RED);
		grafico.fillOval(x - 5, y - 5, 10, 10);
		repaint();
	}

	// Subclase de JPanel para pintar la imagen
	private class MiPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(ventana, 0, 0, null);
		}
	}
}
