package Cine;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CineApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private DefaultListModel<Pelicula> modeloPeliculas = new DefaultListModel<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CineApp frame = new CineApp();
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
    public CineApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 71);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 584, 561);
        contentPane.add(scrollPane);

        JMenuBar menuBar = new JMenuBar();
        scrollPane.setColumnHeaderView(menuBar);

        JMenuItem mntmPeliculas = new JMenuItem("Películas");
        menuBar.add(mntmPeliculas);
        mntmPeliculas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Peliculas pelis = new Peliculas(CineApp.this, modeloPeliculas);
                pelis.setVisible(true);
                setVisible(false); 
            }
        });

        JMenuItem mntmNuevaPelicula = new JMenuItem("Añadir nueva Película");
        menuBar.add(mntmNuevaPelicula);
        mntmNuevaPelicula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formulario form = new Formulario(CineApp.this, modeloPeliculas);
                form.setVisible(true);
                setVisible(false); 
            }
        });

        JMenuItem mntmGrafico = new JMenuItem("Gráfico");
        menuBar.add(mntmGrafico);
        menuBar.add(mntmGrafico);
        mntmGrafico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GraficoPeliculas grafico = new GraficoPeliculas(CineApp.this, modeloPeliculas);
                grafico.setVisible(true);
                setVisible(false); 
            }
        });
    }

    public void volverAlMenu() {
        setVisible(true);
    }
}
