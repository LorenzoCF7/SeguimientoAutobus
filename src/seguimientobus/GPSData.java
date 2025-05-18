package seguimientobus;

import java.util.ArrayList;
import java.util.Random;

public class GPSData {
    private int busId;
    private String timestamp;
    private int latitude;
    private int longitude;
    private int speed;


    public GPSData() {
        setBusId(0);
        setTimestamp("");
        setLatitude(0);
        setLongitude(0);
        setSpeed(0);
    }

    public GPSData(int busId, int latitude, int longitude) {
        setBusId(busId);
        setTimestamp("");
        setLatitude(latitude);
        setLongitude(longitude);
        setSpeed(0);
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSpeed() {
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        this.speed = randomNumber*10;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "GPSData{" +
                "busId=" + busId +
                ", timestamp='" + timestamp + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", speed=" + speed +
                '}';
    }
}


