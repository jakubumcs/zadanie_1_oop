public interface DeviceVisitor {
    void visit(SmartBulb bulb);
    void visit(SmartDevice device);
    void visit(ThermostatAdapter thermostat);
    void visit(LegacyThermostat thermostat);
    void visit(DeviceDecorator decorator);
    void visit(EnergyMonitoringDecorator decorator);
}
