package seguimientobus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class escritura {
    public static void writer(File archivo, ArrayList<GPSData> autobuses) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true)); // el true es para que no borre el contenido previo
        //escribo el contenido del array en el txt

        for (GPSData autobus : autobuses) {
            bw.write("ID: " + autobus.getBusId() + ", hora: " + autobus.getTimestamp() + ", latitud: " + autobus.getLatitude() + ", longitud: " + autobus.getLongitude() + ", velocidad: " + autobus.getSpeed());
            bw.newLine(); //salto de linea para separar cada contacto en el txt
        }

        bw.close();
    }

    public static void writer(File archivo, GPSData autobus) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false)); // false para sobrescribir

        bw.write("{");
        bw.newLine();
        bw.write("  \"busId\": \"" + autobus.getBusId() + "\",");
        bw.newLine();
        bw.write("  \"latitude\": " + autobus.getLatitude() + ",");
        bw.newLine();
        bw.write("  \"longitude\": " + autobus.getLongitude() + ",");
        bw.newLine();
        bw.write("  \"timestamp\": \"" + autobus.getTimestamp() + "\"");
        bw.newLine();
        bw.write("}");
        bw.newLine(); // separador entre entradas JSON

        bw.close();
    }

}
