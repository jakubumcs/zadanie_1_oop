package smarthome.core;

import smarthome.visitor.DeviceVisitor;

public interface ManageableDevice {
    void turnOn();
    void turnOff();
    void getStatus();
    void accept(DeviceVisitor visitor);
}
