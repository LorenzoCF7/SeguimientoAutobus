package seguimientobus.Interfaz;

import javax.swing.*;
import java.awt.*;

public class Mapa extends JPanel {
    public JButton btnVolver;

    private int[][] mapa; // Mapa de valores 0, 1 y 2
    private Image imgJugador, imgPared;

    public Mapa() {
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Estás en el Mapa");
        btnVolver = new JButton("Volver al menú");

        add(label);
        add(btnVolver);

        // Crear un mapa simple de ejemplo
        mapa = new int[50][50];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                // Inicializar el mapa con ceros y unos aleatorios
                mapa[i][j] = (int) Math.round(Math.random());
            }
        }

        // Cargar las imágenes
        try {
            imgPared = new ImageIcon(getClass().getResource("/seguimientobus/img/pared.jpg")).getImage();
        } catch (Exception e) {
            System.err.println("Error 1");
        }

        try {
            imgJugador = new ImageIcon(getClass().getResource("/seguimientobus/img/pinguino2.jpg")).getImage();
        } catch (Exception e) {
            System.err.println("Error 2");
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el mapa
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == 1) {
                    // Dibuja una pared (por ejemplo, un cuadrado rojo)

                    g.fillRect(j * 20, i * 20, 20, 20);// dibuja un rectángulo sólido (relleno) en las coordenadas que se le pasan
                    g.drawImage(imgPared, j * 20, i * 20, 20, 20, this); // Imagen encima
                } else {
                    // Dibuja el fondo (por ejemplo, blanco)
                    g.setColor(Color.WHITE);
                    g.fillRect(j * 20, i * 20, 20, 20);
                }
            }
        }

        // Dibuja un jugador (por ejemplo, con una imagen)
        g.drawImage(imgJugador, 70, 70, 70, 70, this); // Ejemplo de jugador en una posición fija
    }
}
