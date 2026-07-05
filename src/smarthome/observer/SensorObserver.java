package smarthome.observer;

public interface SensorObserver {
    void onSensorTriggered(String sensorId, String eventDetails);
}
