package Cine;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Peliculas extends JFrame {

    private static final long serialVersionUID = 1L;
    private CineApp menu;
    private DefaultListModel<Pelicula> modelo;
    private JList<Pelicula> lista;

    public Peliculas(CineApp menu, DefaultListModel<Pelicula> peliculasGuardadas) {
        this.menu = menu;

        setTitle("Películas");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        modelo = peliculasGuardadas;
        lista = new JList<>(modelo);
        lista.setCellRenderer(new TaskCellRenderer());
        lista.setFixedCellHeight(100);

        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.volverAlMenu();
                dispose();
            }
        });
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnVolver);
        contentPane.add(panelInferior, BorderLayout.SOUTH);
    }
}
