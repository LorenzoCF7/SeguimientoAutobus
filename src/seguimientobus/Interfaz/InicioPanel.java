package seguimientobus.Interfaz;

import javax.swing.*;
import java.awt.*;

public class InicioPanel extends JPanel {
    public JButton btnIrAlMapa;
    public JButton btnCerrar;

    public InicioPanel() {
        // Establecer diseño vertical y centrado
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(245, 245, 245)); // Color de fondo claro

        // Crear y configurar el título
        JLabel label = new JLabel("Menú Principal");
        label.setFont(new Font("Arial", Font.BOLD, 26));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // espacio arriba y abajo

        // Crear botones con estilo
        btnIrAlMapa = new JButton("Ir al mapa");
        btnCerrar = new JButton("Cerrar");

        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        btnIrAlMapa.setFont(buttonFont);
        btnCerrar.setFont(buttonFont);

        btnIrAlMapa.setMaximumSize(new Dimension(200, 40));
        btnCerrar.setMaximumSize(new Dimension(200, 40));

        btnIrAlMapa.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir espaciado entre componentes
        add(Box.createVerticalGlue());
        add(label);
        add(Box.createVerticalStrut(20));
        add(btnIrAlMapa);
        add(Box.createVerticalStrut(15));
        add(btnCerrar);
        add(Box.createVerticalGlue());

        // Añadir borde alrededor del panel
        setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
    }
}
