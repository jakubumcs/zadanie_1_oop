package smarthome.decorators;

import smarthome.core.ManageableDevice;
import smarthome.visitor.DeviceVisitor;

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

    public ManageableDevice getWrappedDevice() {
        return device;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}
