public class DiagnosticReportVisitor implements DeviceVisitor {
    @Override
    public void visit(SmartBulb bulb) {
        System.out.println("Raport żarówki: " + bulb.getName() + ", pokój: " + bulb.getRoom() + ", firmware: " + bulb.getFirmwareVersion());
    }

    @Override
    public void visit(SmartDevice device) {
        System.out.println("Raport urządzenia: " + device.getName() + ", pokój: " + device.getRoom() + ", firmware: " + device.getFirmwareVersion());
    }

    @Override
    public void visit(ThermostatAdapter thermostat) {
        System.out.println("Raport termostatu: adapter aktywny");
    }

    @Override
    public void visit(LegacyThermostat thermostat) {
        System.out.println("Raport starego termostatu: urządzenie zgodne przez adapter");
    }

    @Override
    public void visit(DeviceDecorator decorator) {
        System.out.println("Raport dekoratora: dodatkowa funkcja urządzenia");
    }

    @Override
    public void visit(EnergyMonitoringDecorator decorator) {
        System.out.println("Raport monitoringu energii: aktywny");
    }
}
