import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeHub {
    private static HomeHub instance;
    private List<ManageableDevice> devices;


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
        for (ManageableDevice manageableDevice : devices) {
            if (!(manageableDevice instanceof SmartDevice)) {
                continue;
            }
            SmartDevice existingDevice = (SmartDevice) manageableDevice;

            if (existingDevice.getId().equals(device.getId())
                    || (existingDevice.getMacAddress() != null
                    && device.getMacAddress() != null
                    && existingDevice.getMacAddress().equals(device.getMacAddress()))) {
                throw new DuplicateDeviceException("Device already registered");
            }
        }
        devices.add(device);
    }

    public List<SmartDevice> getDevicesByRoom(String room) {
        List<SmartDevice> devicesByRoom = new ArrayList<>();
        for (ManageableDevice manageableDevice : devices) {
            if (!(manageableDevice instanceof SmartDevice)) {
                continue;
            }
            SmartDevice device = (SmartDevice) manageableDevice;
            if (device.getRoom() != null && device.getRoom().equals(room)) {
                devicesByRoom.add(device);
            }
        }
        Collections.sort(devicesByRoom);
        return devicesByRoom;
    }
    public void registerDevice(ManageableDevice device) {
        devices.add(device);
    }

    public List<ManageableDevice> getDevices() {
        return new ArrayList<>(devices);
    }
}
