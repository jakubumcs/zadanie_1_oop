package smarthome.devices;

import smarthome.visitor.DeviceVisitor;

public class SmartBulb extends SmartDevice {
    public SmartBulb(String id, String name, String room, String macAddress, double firmwareVersion) {
        super(id, name, room, macAddress, firmwareVersion);
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}
