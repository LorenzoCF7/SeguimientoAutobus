package seguimientobus.Interfaz;

import javax.swing.*;
import java.awt.*;

public class InicioPanel extends JPanel {
    public JButton btnIrAlMapa;
    public JButton btnCerrar;

    public InicioPanel() {
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Menú Principal");
        btnIrAlMapa = new JButton("Ir al mapa");
        btnCerrar = new JButton("Cerrar");

        add(label);
        add(btnIrAlMapa);
        add(btnCerrar);
    }
}
