package smarthome.visitor;

import smarthome.decorators.DeviceDecorator;
import smarthome.decorators.EnergyMonitoringDecorator;
import smarthome.devices.LegacyThermostat;
import smarthome.devices.SmartBulb;
import smarthome.devices.SmartDevice;
import smarthome.devices.ThermostatAdapter;

public interface DeviceVisitor {
    void visit(SmartBulb bulb);
    void visit(SmartDevice device);
    void visit(ThermostatAdapter thermostat);
    void visit(LegacyThermostat thermostat);
    void visit(DeviceDecorator decorator);
    void visit(EnergyMonitoringDecorator decorator);
}
