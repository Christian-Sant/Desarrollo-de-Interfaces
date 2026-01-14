package Cine;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class GraficoPeliculas extends JFrame {

    private static final long serialVersionUID = 1L;
    private DefaultListModel<Pelicula> modeloPeliculas;
    private PanelGrafico panelGrafico;
    private CineApp menu; 

    public GraficoPeliculas(CineApp menu, DefaultListModel<Pelicula> modeloPeliculas) {
        this.menu = menu;
        this.modeloPeliculas = modeloPeliculas;

        setTitle("Gráfico de películas por tipo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panelGrafico = new PanelGrafico();
        panelGrafico.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(panelGrafico, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(e -> {
            menu.volverAlMenu(); 
            dispose();          
        });
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);

        modeloPeliculas.addListDataListener(new javax.swing.event.ListDataListener() {
            @Override
            public void intervalAdded(javax.swing.event.ListDataEvent e) {
                panelGrafico.repaint();
            }
            @Override
            public void intervalRemoved(javax.swing.event.ListDataEvent e) {
                panelGrafico.repaint();
            }
            @Override
            public void contentsChanged(javax.swing.event.ListDataEvent e) {
                panelGrafico.repaint();
            }
        });
    }

    private class PanelGrafico extends JPanel {
        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int accion = 0, comedia = 0, drama = 0, ciencia = 0;

            for (int i = 0; i < modeloPeliculas.size(); i++) {
                Pelicula p = modeloPeliculas.get(i);
                switch (p.getTipo()) {
                    case "Acción": accion++; break;
                    case "Comedia": comedia++; break;
                    case "Drama": drama++; break;
                    case "Ciencia ficción": ciencia++; break;
                }
            }

            int[] valores = {accion, comedia, drama, ciencia};
            String[] tipos = {"Acción", "Comedia", "Drama", "Ciencia ficción"};

            int anchoBarra = 100;
            int espacio = 40;
            int x = 50;

            int max = 1;
            for (int v : valores) if (v > max) max = v;
            int alturaMax = getHeight() - 50;

            for (int i = 0; i < valores.length; i++) {
                int altura = (int)(((double)valores[i]/max) * alturaMax);
                g.setColor(Color.BLUE);
                g.fillRect(x, getHeight() - altura - 30, anchoBarra, altura);
                g.setColor(Color.BLACK);
                g.drawRect(x, getHeight() - altura - 30, anchoBarra, altura);
                g.drawString(tipos[i] + " (" + valores[i] + ")", x, getHeight() - 10);
                x += anchoBarra + espacio;
            }
        }
    }
}
