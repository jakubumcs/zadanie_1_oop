import java.util.ArrayList;
import java.util.List;

public class HomeHub {
    private static HomeHub instance;

    private final List<SmartDevice> devices;

    private HomeHub() {
        this.devices = new ArrayList<>();
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }

    public void registerDevice(SmartDevice device) throws DuplicateDeviceException {
        for (SmartDevice existingDevice : devices) {
            if (existingDevice.getId().equals(device.getId())
                    || existingDevice.getMacAddress().equals(device.getMacAddress())) {
                throw new DuplicateDeviceException("Device already registered");
            }
        }
        devices.add(device);
    }
}
