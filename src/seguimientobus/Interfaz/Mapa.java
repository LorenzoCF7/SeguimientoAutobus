package seguimientobus.Interfaz;

import seguimientobus.GPSData;
import seguimientobus.escritura;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Mapa extends JPanel {
    public JButton btnVolver;

    private int[][] mapa; // Mapa de valores 0 vacio, 1 autobuses.get(0), 2 autobuses.get(1), 3 autobuses.get(2), 4 zona compartida
    private Image imgAutobus, imgParadas, imgRuta1, imgRuta2 , imgRuta3 , imgRutaComb, imgFondo;
    private ArrayList<GPSData> autobuses = new ArrayList<>();
    private Random rand = new Random();
    private Timer timer;
    private String hora = "12:00";
    Label lblhora = new Label("Hora: " + hora);
    String nombreArchivo = "gps_data.csv";
    File file = new File(nombreArchivo);

    File bus1 = new File("bus01_status.json");
    File bus2 = new File("bus02_status.json");
    File bus3 = new File("bus3_status.json");


    public Mapa() {
        setLayout(null);

        lblhora.setBounds(10, 10, 150, 30); // Posición y tamaño
        lblhora.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblhora);
        btnVolver = new JButton("Volver al menú");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 15));
        btnVolver.setBounds(325, 40, 150, 30);
        add(btnVolver);
        autobuses.add(new GPSData(1, 12, 17));
        autobuses.add(new GPSData(2, 38, 38));
        autobuses.add(new GPSData(3, 73, 94));

        // Crear un mapa simple de ejemplo
        mapa = new int[86][95];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                // Inicializar el mapa con ceros
                mapa[i][j] = 0;
            }
        }

        for (int i = 0; i < mapa.length; i++) { //MAPEADO
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
                if (j < 28 && j > 19 && i == 64) { // Shirow
                    mapa[i][j] = 1;
                }
                if (j == 20 && i < 76 && i > 63) { // Shirow - Vriaor
                    mapa[i][j] = 1;
                }
                if (i == 76 && j > 19 && j < 40) { // Shirow - Vriaor 2
                    mapa[i][j] = 1;
                }
                if (i < 77 && i > 10 && j == 40) { // Vriaor
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
                if (j == 20 && i == 10) { // Sunnyside
                    mapa[i][j] = 5;
                }

                if (i == 33 && j == 17) { // Fritpat
                    mapa[i][j] = 5;
                }

                if (j == 23 && i == 64) { // Shirow
                    mapa[i][j] = 5;
                }
                if (i == 36 && j == 40) { // Vriaor
                    mapa[i][j] = 5;
                }
                if (j == 38 && i == 36) { // Vriaor
                    mapa[i][j] = 5;
                }
                if (i == 65 && j == 61) { // Altamount
                    mapa[i][j] = 5;
                }
                if (j == 66 && i == 51) { // Araton
                    mapa[i][j] = 5;
                }
                if (j == 64 && i == 51) { // Araton
                    mapa[i][j] = 5;
                }
                if (j == 94 && (i == 30 || i == 75)) { // Flotsam & Onmitron
                    mapa[i][j] = 5;
                }
                if (j == 75 && i == 20) { // Zarelli
                    mapa[i][j] = 5;
                }
            }
        }
        cargarImagenes();
        iniciarMovimientoAutobus();
    }



    private void iniciarMovimientoAutobus() {
        int delay = 100; // ms entre ticks

        int[] zonaAutoAntigua = { mapa[autobuses.get(0).getLatitude()][autobuses.get(0).getLongitude()] };
        int[] zonaAutoAntigua2 = { mapa[autobuses.get(1).getLatitude()][autobuses.get(1).getLongitude()] };
        int[] zonaAutoAntigua3 = { mapa[autobuses.get(2).getLatitude()][autobuses.get(2).getLongitude()] };

        final boolean[] parado = { false, false, false };
        final String[] direccion = { "abajo", "abajo", "arriba"};
        final int[] contador = {0};
        final int[] total_velocidad = {0,0,0};
        final int[] total_paradas = {0,0,0};



        timer = new Timer(delay, e -> {
            // Obtenemos fecha y hora actuales con zona horaria del sistema
            ZonedDateTime fechaHoraActual = ZonedDateTime.now();

            // Calculamos segundos simulados (cada tick son 10 segundos)
            int segundosSimulados = contador[0] * 10 - 1;

            // Sumamos segundos simulados a la fecha y hora actual
            ZonedDateTime fechaHoraSimulada = fechaHoraActual.plusSeconds(segundosSimulados);

            // Formateamos según el patrón ISO 8601 con zona horaria
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

            String fechaHoraFormateada = fechaHoraSimulada.format(formatter);

            // Actualizamos el label
            lblhora.setText(fechaHoraFormateada);
            for (GPSData autobus : autobuses) {
                autobus.setTimestamp(fechaHoraFormateada);
            }
            if (contador[0] >= 360) {
                timer.stop(); // detener el timer después de 60 ejecuciones
                System.out.println("Velocidad media autobus 1: " + total_velocidad[0]/contador[0] + " km/h");
                System.out.println("Velocidad media autobus 2: " + total_velocidad[1]/contador[0] + " km/h");
                System.out.println("Velocidad media autobus 3: " + total_velocidad[2]/contador[0] + " km/h");
                System.out.println("Total de paradas autobus 1: " + total_paradas[0]);
                System.out.println("Total de paradas autobus 2: " + total_paradas[1]);
                System.out.println("Total de paradas autobus 3: " + total_paradas[2]);
                try {
                    escritura.writer(file, autobuses);
                    escritura.writer(bus1, autobuses.get(0));
                    escritura.writer(bus2, autobuses.get(1));
                    escritura.writer(bus3, autobuses.get(2));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                return;
            }
            contador[0]++; // incrementar contador en cada tick
            if (parado[0]) {
                parado[0] = false;
                total_paradas[0]++;
                repaint();
                return;
            }
            if (parado[1]) {
                parado[1] = false;
                total_paradas[1]++;
                repaint();
                return;
            }
            if (parado[2]) {
                parado[2] = false;
                total_paradas[2]++;
                repaint();
                return;
            }

            mapa[autobuses.get(0).getLatitude()][autobuses.get(0).getLongitude()] = zonaAutoAntigua[0];
            mapa[autobuses.get(1).getLatitude()][autobuses.get(1).getLongitude()] = zonaAutoAntigua2[0];
            mapa[autobuses.get(2).getLatitude()][autobuses.get(2).getLongitude()] = zonaAutoAntigua3[0];

            autobuses.get(0).setSpeed();
            autobuses.get(1).setSpeed();
            autobuses.get(2).setSpeed();
            total_velocidad[0] += autobuses.get(0).getSpeed();
            total_velocidad[1] += autobuses.get(1).getSpeed();
            total_velocidad[2] += autobuses.get(2).getSpeed();
            int []velocidad = {autobuses.get(0).getSpeed()/10, autobuses.get(1).getSpeed()/10, autobuses.get(2).getSpeed()/10};

            // Fritpat
            if (autobuses.get(0).getLatitude() == 58 && autobuses.get(0).getLongitude() == 17) {
                direccion[0] = "derecha";
            }

            if (autobuses.get(0).getLatitude() == 58 && autobuses.get(0).getLongitude() == 27) {
                direccion[0] = "abajo";
            }
            if (autobuses.get(0).getLatitude() == 64 && autobuses.get(0).getLongitude() == 27) {
                direccion[0] = "izquierda";
            }
            if (autobuses.get(0).getLatitude() == 64 && autobuses.get(0).getLongitude() == 20) {
                direccion[0] = "abajo";
            }

            if (autobuses.get(0).getLatitude() == 76 && autobuses.get(0).getLongitude() == 20) {
                direccion[0] = "derecha";
            }
            if (autobuses.get(0).getLatitude() == 76 && autobuses.get(0).getLongitude() == 40) {
                direccion[0] = "arriba";
            }
            if (autobuses.get(0).getLatitude() == 10 && autobuses.get(0).getLongitude() == 40) {
                direccion[0] = "izquierda";
            }
            if (autobuses.get(0).getLatitude() == 10 && autobuses.get(0).getLongitude() == 17) {
                direccion[0] = "abajo";
            }
            if (autobuses.get(1).getLatitude() == 55 && autobuses.get(1).getLongitude() == 38) {
                direccion[1] = "derecha";
            }
            if (autobuses.get(1).getLatitude() == 55 && autobuses.get(1).getLongitude() == 55) {
                direccion[1] = "abajo";
            }
            if (autobuses.get(1).getLatitude() == 65 && autobuses.get(1).getLongitude() == 55) {
                direccion[1] = "derecha";
            }
            if (autobuses.get(1).getLatitude() == 65 && autobuses.get(1).getLongitude() == 66) {
                direccion[1] = "arriba";
            }
            if (autobuses.get(1).getLatitude() == 20 && autobuses.get(1).getLongitude() == 66) {
                direccion[1] = "izquierda";
            }
            if (autobuses.get(1).getLatitude() == 20 && autobuses.get(1).getLongitude() == 55) {
                direccion[1] = "abajo";
            }
            if (autobuses.get(1).getLatitude() == 26 && autobuses.get(1).getLongitude() == 55) {
                direccion[1] = "izquierda";
            }
            if (autobuses.get(1).getLatitude() == 26 && autobuses.get(1).getLongitude() == 38) {
                direccion[1] = "abajo";
            }
            if (autobuses.get(2).getLatitude() == 20 && autobuses.get(2).getLongitude() == 94) {
                direccion[2] = "izquierda";
            }
            if (autobuses.get(2).getLatitude() == 20 && autobuses.get(2).getLongitude() == 64) {
                direccion[2] = "abajo";
            }
            if (autobuses.get(2).getLatitude() == 85 && autobuses.get(2).getLongitude() == 64) {
                direccion[2] = "derecha";
            }
            if (autobuses.get(2).getLatitude() == 85 && autobuses.get(2).getLongitude() == 94) {
                direccion[2] = "arriba";
            }


            int []nuevaLatitud = {autobuses.get(0).getLatitude(), autobuses.get(1).getLatitude(), autobuses.get(2).getLatitude()};
            int []nuevaLongitud = {autobuses.get(0).getLongitude(), autobuses.get(1).getLongitude(), autobuses.get(2).getLongitude()};

            if (direccion[0].equals("abajo")) {
                nuevaLatitud[0] += velocidad[0];

                // Verificar parada Fritpat al bajar
                if (autobuses.get(0).getLatitude() < 33 && 33 < autobuses.get(0).getLatitude() + velocidad[0] && autobuses.get(0).getLongitude() == 17) {
                    nuevaLatitud[0] = 33; // Forzar la parada exacta en 33
                }
                if (autobuses.get(0).getLatitude() < 58 && 58 < autobuses.get(0).getLatitude()+velocidad[0] && autobuses.get(0).getLongitude() == 17) {
                    nuevaLatitud[0] = 58;
                }
                if (autobuses.get(0).getLatitude() < 64 && 64 < autobuses.get(0).getLatitude()+velocidad[0] && autobuses.get(0).getLongitude() == 27) {
                    nuevaLatitud[0] = 64;
                }
                if (autobuses.get(0).getLatitude() < 76 && 76 < autobuses.get(0).getLatitude()+velocidad[0] && autobuses.get(0).getLongitude() == 20) {
                    nuevaLatitud[0] = 76;
                }

            } else if (direccion[0].equals("derecha")) {
                nuevaLongitud[0] += velocidad[0];
                if (autobuses.get(0).getLongitude() < 27 && 27 < autobuses.get(0).getLongitude()+velocidad[0] && autobuses.get(0).getLatitude() == 58) {
                    nuevaLongitud[0] = 27;
                }
                if (autobuses.get(0).getLongitude() < 40 && 40 < autobuses.get(0).getLongitude()+velocidad[0] && autobuses.get(0).getLatitude() == 76) {
                    nuevaLongitud[0] = 40;
                }
            } else if (direccion[0].equals("izquierda")) {
                nuevaLongitud[0] -= velocidad[0];
                if (autobuses.get(0).getLongitude() > 23 && 23 > autobuses.get(0).getLongitude()-velocidad[0] && autobuses.get(0).getLatitude() == 64) { // parada shirow
                    nuevaLongitud[0] = 23;
                }
                if (autobuses.get(0).getLongitude() > 20 && 20 > autobuses.get(0).getLongitude()-velocidad[0] && autobuses.get(0).getLatitude() == 64) { // shirow
                    nuevaLongitud[0] = 20;
                }
                if (autobuses.get(0).getLongitude() > 20 && 20 > autobuses.get(0).getLongitude()-velocidad[0] && autobuses.get(0).getLatitude() == 10) { // parada
                    nuevaLongitud[0] = 20;
                }
                if (autobuses.get(0).getLongitude() > 17 && 17 > autobuses.get(0).getLongitude()-velocidad[0] && autobuses.get(0).getLatitude() == 10) {
                    nuevaLongitud[0] = 17;
                }


            } else if (direccion[0].equals("arriba")) {
                nuevaLatitud[0] -= velocidad[0];
                if (autobuses.get(0).getLatitude() > 36 && 36 > autobuses.get(0).getLatitude()-velocidad[0] && autobuses.get(0).getLongitude() == 40) {
                    nuevaLatitud[0] = 36;
                }
                if (autobuses.get(0).getLatitude() > 10 && 10 > autobuses.get(0).getLatitude()-velocidad[0] && autobuses.get(0).getLongitude() == 40) {
                    nuevaLatitud[0] = 10;
                }

            }

            if (direccion[1].equals("abajo")) {
                nuevaLatitud[1] += velocidad[1];
                if (autobuses.get(1).getLatitude() < 55 && 55 < autobuses.get(1).getLatitude()+velocidad[1] && autobuses.get(1).getLongitude() == 38) {
                    nuevaLatitud[1] = 55;
                }
                if (autobuses.get(1).getLatitude() < 65 && 65 < autobuses.get(1).getLatitude()+velocidad[1] && autobuses.get(1).getLongitude() == 55) {
                    nuevaLatitud[1] = 65;
                }
                if (autobuses.get(1).getLatitude() < 26 && 26 < autobuses.get(1).getLatitude()+velocidad[1] && autobuses.get(1).getLongitude() == 55) {
                    nuevaLatitud[1] = 26;
                }
                if (autobuses.get(1).getLatitude() < 36 && 36 < autobuses.get(1).getLatitude()+velocidad[1] && autobuses.get(1).getLongitude() == 38) { //parada Vriaor
                    nuevaLatitud[1] = 36;
                }
            }
            else if (direccion[1].equals("derecha")) {
                nuevaLongitud[1] += velocidad[1];
                if (autobuses.get(1).getLongitude() < 55 && 55 < autobuses.get(1).getLongitude()+velocidad[1] && autobuses.get(1).getLatitude() == 55) {
                    nuevaLongitud[1] = 55;
                }
                if (autobuses.get(1).getLongitude() < 61 && 61 < autobuses.get(1).getLongitude()+velocidad[1] && autobuses.get(1).getLatitude() == 65) {
                    nuevaLongitud[1] = 61;
                }
                if (autobuses.get(1).getLongitude() < 66 && 66 < autobuses.get(1).getLongitude()+velocidad[1] && autobuses.get(1).getLatitude() == 65) {
                    nuevaLongitud[1] = 66;
                }
            }
            else if (direccion[1].equals("arriba")) {
                nuevaLatitud[1] -= velocidad[1];

                if (autobuses.get(1).getLatitude() > 20 && 20 > autobuses.get(1).getLatitude()-velocidad[1] && autobuses.get(1).getLongitude() == 66) {
                    nuevaLatitud[1] = 20;
                }
                if (autobuses.get(1).getLatitude() > 51 && 51 > autobuses.get(1).getLatitude()-velocidad[1] && autobuses.get(1).getLongitude() == 66) { // parada araton
                    nuevaLatitud[1] = 51;
                }
            }
            else if (direccion[1].equals("izquierda")) {
                nuevaLongitud[1] -= velocidad[1];
                if (autobuses.get(1).getLongitude() > 55 && 55 > autobuses.get(1).getLongitude()-velocidad[1] && autobuses.get(1).getLatitude() == 20) {
                    nuevaLongitud[1] = 55;
                }
                if (autobuses.get(1).getLongitude() > 38 && 38 > autobuses.get(1).getLongitude()-velocidad[1] && autobuses.get(1).getLatitude() == 26) {
                    nuevaLongitud[1] = 38;
                }



            }
            if (direccion[2].equals("abajo")) {
                nuevaLatitud[2] += velocidad[2];
                if (autobuses.get(2).getLatitude() < 51 && 51 < autobuses.get(2).getLatitude()+velocidad[2] && autobuses.get(2).getLongitude() == 64) {
                    nuevaLatitud[2] = 51;
                }
                if (autobuses.get(2).getLatitude() < 85 && 85 < autobuses.get(2).getLatitude()+velocidad[2] && autobuses.get(2).getLongitude() == 64) {
                    nuevaLatitud[2] = 85;
                }
            }
            else if (direccion[2].equals("derecha")) {
                nuevaLongitud[2] += velocidad[2];
                if (autobuses.get(2).getLongitude() < 94 && 94 < autobuses.get(2).getLongitude()+velocidad[2] && autobuses.get(2).getLatitude() == 85) {
                    nuevaLongitud[2] = 94;
                }
            }
            else if (direccion[2].equals("arriba")) {
                nuevaLatitud[2] -= velocidad[2];

                if (autobuses.get(2).getLatitude() > 30 && 30 > autobuses.get(2).getLatitude()-velocidad[2] && autobuses.get(2).getLongitude() == 94) {
                    nuevaLatitud[2] = 30;
                }
                if (autobuses.get(2).getLatitude() > 75 && 75 > autobuses.get(2).getLatitude()-velocidad[2] && autobuses.get(2).getLongitude() == 94) {
                    nuevaLatitud[2] = 75;
                }
                if (autobuses.get(2).getLatitude() > 20 && 20 > autobuses.get(2).getLatitude()-velocidad[2] && autobuses.get(2).getLongitude() == 94) {
                    nuevaLatitud[2] = 20;
                }

            }
            else if (direccion[2].equals("izquierda")) {
                nuevaLongitud[2] -= velocidad[2];
                if (autobuses.get(2).getLongitude() > 75 && 75 > autobuses.get(2).getLongitude()-velocidad[2] && autobuses.get(2).getLatitude() == 20) {
                    nuevaLongitud[2] = 75;
                }
                if (autobuses.get(2).getLongitude() > 64 && 64 > autobuses.get(2).getLongitude()-velocidad[2] && autobuses.get(2).getLatitude() == 20) {
                    nuevaLongitud[2] = 64;
                }
            }


            zonaAutoAntigua[0] = mapa[nuevaLatitud[0]][nuevaLongitud[0]];
            zonaAutoAntigua2[0] = mapa[nuevaLatitud[1]][nuevaLongitud[1]];
            zonaAutoAntigua3[0] = mapa[nuevaLatitud[2]][nuevaLongitud[2]];

            // Actualizar posición del bus
            autobuses.get(0).setLatitude(nuevaLatitud[0]);
            autobuses.get(0).setLongitude(nuevaLongitud[0]);

            autobuses.get(1).setLatitude(nuevaLatitud[1]);
            autobuses.get(1).setLongitude(nuevaLongitud[1]);

            autobuses.get(2).setLatitude(nuevaLatitud[2]);
            autobuses.get(2).setLongitude(nuevaLongitud[2]);

            if (zonaAutoAntigua[0] == 5) {
                parado[0] = true;
            }
            if (zonaAutoAntigua2[0] == 5) {
                parado[1] = true;
            }
            if (zonaAutoAntigua3[0] == 5) {
                parado[2] = true;
            }

            mapa[autobuses.get(0).getLatitude()][autobuses.get(0).getLongitude()] = 6;
            mapa[autobuses.get(1).getLatitude()][autobuses.get(1).getLongitude()] = 6;
            mapa[autobuses.get(2).getLatitude()][autobuses.get(2).getLongitude()] = 6;

            repaint();
        });
        timer.start();
    }




    private void cargarImagenes() {
        try {
            imgAutobus = new ImageIcon(getClass().getResource("/seguimientobus/img/autobus.png")).getImage();
            imgParadas = new ImageIcon(getClass().getResource("/seguimientobus/img/paradas.png")).getImage();
            imgRuta1 = new ImageIcon(getClass().getResource("/seguimientobus/img/marco.png")).getImage();
            imgRuta2 = new ImageIcon(getClass().getResource("/seguimientobus/img/marco2.png")).getImage();
            imgRuta3 = new ImageIcon(getClass().getResource("/seguimientobus/img/marco.png")).getImage();
            imgRutaComb = new ImageIcon(getClass().getResource("/seguimientobus/img/marco3.png")).getImage();
            imgFondo = new ImageIcon(getClass().getResource("/seguimientobus/img/ciudad.png")).getImage();
        } catch (Exception e) {
            System.err.println("Error al cargar las imágenes");
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

    }
}
