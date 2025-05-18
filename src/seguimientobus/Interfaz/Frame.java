package seguimientobus.Interfaz;

import javax.swing.*;

public class Frame extends JFrame {
    private InicioPanel panelInicio;
    private Mapa panelMapa;
    public Frame() {
        setTitle("Seguimiento Autobuses");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelInicio = new InicioPanel();
        panelMapa = new Mapa();

        setContentPane(panelInicio);

        ImageIcon icono = new ImageIcon(getClass().getResource("/seguimientobus/img/ciudad.png"));
        setIconImage(icono.getImage());

        // Acción: Ir al mapa
        panelInicio.btnIrAlMapa.addActionListener(e -> {
            setContentPane(panelMapa);
            revalidate();
            repaint();
        });

        // Acción: Cerrar
        panelInicio.btnCerrar.addActionListener(e -> {
            dispose(); // Cierra la ventana
        });

        // Acción: Volver al menú
        panelMapa.btnVolver.addActionListener(e -> {
            setContentPane(panelInicio);
            revalidate();
            repaint();
        });

        setVisible(true);
    }

}
