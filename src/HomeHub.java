import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeHub {
    private static HomeHub instance;

    private final List<String> devices;

    private HomeHub() {
        this.devices = new ArrayList<>();
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }

    public void addDevice(String device) {
        devices.add(device);
    }

    public List<String> getDevices() {
        return Collections.unmodifiableList(devices);
    }
}
