public abstract class DeviceDecorator implements ManageableDevice {
    protected ManageableDevice device;

    public DeviceDecorator(ManageableDevice device) {
        this.device = device;
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void getStatus() {
        device.getStatus();
    }
}