package Cine;

import javax.swing.*;
import java.awt.*;

public class TaskCellRenderer extends JPanel implements ListCellRenderer<Pelicula> {

    private static final long serialVersionUID = 1L;

    private JLabel lblTitulo;
    private JLabel lblTipo;
    private JTextArea txtResumen;
    private JLabel lblImagen;

    public TaskCellRenderer() {

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(80, 80));

        lblTitulo = new JLabel();
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

        lblTipo = new JLabel();
        lblTipo.setFont(new Font("Arial", Font.ITALIC, 12));

        txtResumen = new JTextArea();
        txtResumen.setFont(new Font("Arial", Font.PLAIN, 12));
        txtResumen.setLineWrap(true);
        txtResumen.setWrapStyleWord(true);
        txtResumen.setEditable(false);
        txtResumen.setOpaque(false);

        JPanel panelTexto = new JPanel(new GridLayout(3, 1));
        panelTexto.setOpaque(false);
        panelTexto.add(lblTitulo);
        panelTexto.add(lblTipo);
        panelTexto.add(txtResumen);

        add(lblImagen, BorderLayout.WEST);
        add(panelTexto, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Pelicula> list,
            Pelicula pelicula,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        lblTitulo.setText(pelicula.getTitulo());
        lblTipo.setText("Tipo: " + pelicula.getTipo());
        txtResumen.setText(pelicula.getResumen());

        if (pelicula.getRutaImagen() != null && !pelicula.getRutaImagen().isEmpty()) {
            ImageIcon icon = new ImageIcon(pelicula.getRutaImagen());
            Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        } else {
            lblImagen.setIcon(null);
        }

 
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }

        setOpaque(true);
        return this;
    }
}
