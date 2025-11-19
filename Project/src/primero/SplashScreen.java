package primero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SplashScreen extends JDialog {

    private static final long serialVersionUID = 1L;
    private JProgressBar progressBar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            SplashScreen dialog = new SplashScreen();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public SplashScreen() {
        setBounds(100, 100, 585, 470);
        setLocationRelativeTo(null);
        setUndecorated(true); 
        getContentPane().setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        JLabel lblLogo = new JLabel("PAINT", SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon("C:\\Users\\Tarde\\Downloads\\paint-logo.png"));
        lblLogo.setFont(new Font("Arial", Font.BOLD, 24));
        lblLogo.setForeground(new Color(0, 102, 204));
        
        JLabel mensaje = new JLabel("Cargando recursos para la aplicación de paint, por favor espere...", JLabel.CENTER);
        mensaje.setFont(new Font("Arial", Font.PLAIN, 14));
        mensaje.setForeground(Color.GRAY);
        
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true); 
        progressBar.setForeground(new Color(0, 102, 204));
 
        mainPanel.add(lblLogo, BorderLayout.CENTER);
        mainPanel.add(mensaje, BorderLayout.SOUTH);
        
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(progressBar, BorderLayout.SOUTH);
    }

    public void actualizarProgreso(int value) {
        progressBar.setValue(value);
    }
}