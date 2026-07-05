import java.util.ArrayList;
import java.util.List;

public class MotionSensor {
    private final String sensorId;
    private final List<SensorObserver> observers;

    public MotionSensor(String sensorId) {
        this.sensorId = sensorId;
        this.observers = new ArrayList<>();
    }

    public void attach(SensorObserver observer) {
        observers.add(observer);
    }

    public void detach(SensorObserver observer) {
        observers.remove(observer);
    }

    public void detectMotion() {
        for (SensorObserver observer : observers) {
            observer.onSensorTriggered(sensorId, "Wykryto ruch");
        }
    }
}
