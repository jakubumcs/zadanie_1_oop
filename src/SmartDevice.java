public class SmartDevice {
    private final String id;
    private final String name;
    private final String room;
    private final String macAddress;
    private final double firmwareVersion;

    public SmartDevice(String id, String name, String room, String macAddress, double firmwareVersion) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.macAddress = macAddress;
        this.firmwareVersion = firmwareVersion;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public double getFirmwareVersion() {
        return firmwareVersion;
    }
}
