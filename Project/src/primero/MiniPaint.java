package primero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MiniPaint extends JFrame {
    private BufferedImage canvas;
    private Graphics2D g2;
    private int lastX, lastY;

    public MiniPaint() {
        setTitle("MiniPaint en Java");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        g2 = canvas.createGraphics();
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, 800, 600);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                g2.setColor(Color.BLACK);
                g2.drawLine(lastX, lastY, x, y);
                lastX = x;
                lastY = y;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(canvas, 0, 0, null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MiniPaint().setVisible(true);
        });
    }
}   