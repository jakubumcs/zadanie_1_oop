public interface ManageableDevice {
    void turnOn();
    void turnOff();
    void getStatus();
    void accept(DeviceVisitor visitor);
}
