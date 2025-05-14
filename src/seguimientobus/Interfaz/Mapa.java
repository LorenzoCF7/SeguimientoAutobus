package seguimientobus.Interfaz;

import javax.swing.*;
import java.awt.*;

public class Mapa extends JPanel {
    public JButton btnVolver;

    private int[][] mapa; // Mapa de valores 0 vacio, 1 bus1, 2 bus2, 3 bus3, 4 zona compartida
    private Image imgAutobus, imgParadas, imgRuta1, imgRuta2 , imgRuta3 , imgRutaComb, imgFondo;

    public Mapa() {
        setLayout(null);

        btnVolver = new JButton("Volver al menú");
        btnVolver.setBounds(325, 40, 150, 30);

        add(btnVolver);

        // Crear un mapa simple de ejemplo
        mapa = new int[86][95];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                // Inicializar el mapa con ceros y unos aleatorios
                mapa[i][j] = 0;
            }
        }

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                //RUTA 1
                 if (j < 41 && j > 16 && i == 10) { //calle Sunnyside
                     mapa[i][j] = 1;
                 }
                if (i > 10 && j == 17 && i < 59) { //calle Sunnyside - Fritpat
                    mapa[i][j] = 1;
                }
                if (j < 28 && j > 17 && i == 58) { // Fritpat - Shirow 1
                    mapa[i][j] = 1;
                }
                if (j == 27 && i > 57 && i < 65) { // Fritpat - Shirow 2
                    mapa[i][j] = 1;
                }
                if (j < 28 && j > 19 && i == 64) { // Fritpat - Shirow 3
                    mapa[i][j] = 1;
                }
                if (j == 20 && i < 76 && i > 63) { // Fritpat - Shirow 4
                    mapa[i][j] = 1;
                }
                if (i == 76 && j > 19 && j < 40) { // Fritpat - Shirow 5
                    mapa[i][j] = 1;
                }
                if (i < 77 && i > 10 && j == 40) { // Fritpat - Shirow 6
                    mapa[i][j] = 1;
                }
                // RUTA 2
                if (j == 38 && i > 25 && i < 56) { // Vriaor
                    mapa[i][j] = 2;
                }
                if (j > 38 && j < 56 && i == 55) { // Vriaor - Altamount
                    mapa[i][j] = 2;
                }
                if (j == 55 && i > 54 && i < 66) { // Vriaor - Altamount 2
                    mapa[i][j] = 2;
                }
                if (i == 65 && j > 54 && j < 67) { // Altamount
                    mapa[i][j] = 2;
                }
                if (j == 66 && i > 19 && i < 66) { // Araton
                    mapa[i][j] = 2;
                }
                if (j > 54 && j < 67 && i == 20) { // Araton - Vriaor
                    mapa[i][j] = 2;
                }
                if (j == 55 && i > 19 && i < 27) { // Araton - Vriaor 2
                    mapa[i][j] = 2;
                }
                if (i == 26 && j > 38 && j < 56) { // Araton - Vriaor 3
                    mapa[i][j] = 2;
                }

                // RUTA 3
                if (j == 64 && i > 19 && i < 86) { // Araton
                    mapa[i][j] = 3;
                }
                if (j > 63 && j < 95 && i == 85) { // Araton - Flotsam & Onmitron
                    mapa[i][j] = 3;
                }
                if (j == 94 && i > 19 && i < 86) { // Flotsam & Onmitron
                    mapa[i][j] = 3;
                }
                if (j > 63 && j < 95 && i == 20) { // Zarelli
                    mapa[i][j] = 3;
                }

                // COMBINADO
                if ((i == 26 || i == 55) && j == 40) { // Vriaor
                    mapa[i][j] = 4;
                }
                if (i == 20 && j > 63 && j < 67 ) { // Vriaor
                    mapa[i][j] = 4;
                }
                if (i == 65 && j == 64 ) { // Vriaor
                    mapa[i][j] = 4;
                }

                //PARADAS
            }
        }

        // Cargar las imágenes
        try {
            imgAutobus = new ImageIcon(getClass().getResource("/seguimientobus/img/autobus.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error 1");
        }
        try {
            imgParadas = new ImageIcon(getClass().getResource("/seguimientobus/img/paradas.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error 1");
        }
        try {
            imgRuta1 = new ImageIcon(getClass().getResource("/seguimientobus/img/marco.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error 1");
        }

        try {
            imgRuta2 = new ImageIcon(getClass().getResource("/seguimientobus/img/marco2.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error 1.1");
        }

        try {
            imgRuta3 = new ImageIcon(getClass().getResource("/seguimientobus/img/marco.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error 1.2");
        }

        try {
            imgRutaComb = new ImageIcon(getClass().getResource("/seguimientobus/img/marco3.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error 1.3");
        }

        try {
            imgAutobus = new ImageIcon(getClass().getResource("/seguimientobus/img/pinguino2.jpg")).getImage();
        } catch (Exception e) {
            System.err.println("Error 2");
        }

        try {
            imgFondo = new ImageIcon(getClass().getResource("/seguimientobus/img/ciudad.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error 3");
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // dibuja ciudad
        if (imgFondo != null) {
            g.drawImage(imgFondo, 0, 0, getWidth(), getHeight(), this);
        }
        // Dibuja el recorrido
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == 1) {
                    // Dibuja una pared (por ejemplo, un cuadrado rojo)

                    g.drawImage(imgRuta1, j * 8, i * 8, 8, 8, this); // Imagen encima
                }
                if (mapa[i][j] == 2) {
                    // Dibuja una pared (por ejemplo, un cuadrado rojo)

                    g.drawImage(imgRuta2, j * 8, i * 8, 8, 8, this); // Imagen encima
                }
                if (mapa[i][j] == 3) {
                    // Dibuja una pared (por ejemplo, un cuadrado rojo)

                    g.drawImage(imgRuta3, j * 8, i * 8, 8, 8, this); // Imagen encima
                }
                if (mapa[i][j] == 4) {
                    // Dibuja una pared (por ejemplo, un cuadrado rojo)

                    g.drawImage(imgRutaComb, j * 8, i * 8, 8, 8, this); // Imagen encima
                }
                if (mapa[i][j] == 5) {
                    // Dibuja una pared (por ejemplo, un cuadrado rojo)

                    g.drawImage(imgParadas, j * 8, i * 8, 8, 8, this); // Imagen encima
                }
                if (mapa[i][j] == 6) {
                    // Dibuja una pared (por ejemplo, un cuadrado rojo)

                    g.drawImage(imgAutobus, j * 8, i * 8, 8, 8, this); // Imagen encima
                }
            }
        }

        // Dibuja un jugador (por ejemplo, con una imagen)
        //g.drawImage(imgJugador, 70, 70, 70, 70, this); // Ejemplo de jugador en una posición fija
    }
}
