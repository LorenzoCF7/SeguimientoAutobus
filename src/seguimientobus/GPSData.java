package seguimientobus;

import java.util.ArrayList;

public class GPSData {
    private int busId;
    private String timestamp;
    private float latitude;
    private float longitude;
    private float speed;


    public GPSData() {
        setBusId(0);
        setTimestamp("");
        setLatitude(0);
        setLongitude(0);
        setSpeed(0);
    }

    public GPSData(int busId) {
        setBusId(busId);
        setTimestamp("");
        setLatitude(0);
        setLongitude(0);
        setSpeed(0);
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
