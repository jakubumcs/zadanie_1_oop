public class DiagnosticsVisitor implements DeviceVisitor {
    private final StringBuilder report;

    public DiagnosticsVisitor() {
        this.report = new StringBuilder();
    }

    @Override
    public void visit(SmartBulb bulb) {
        report.append("Żarówka: ")
                .append(bulb.getName())
                .append(", ID: ")
                .append(bulb.getId())
                .append(", pokój: ")
                .append(bulb.getRoom())
                .append(", MAC: ")
                .append(bulb.getMacAddress())
                .append(", firmware: ")
                .append(bulb.getFirmwareVersion())
                .append(System.lineSeparator());
    }

    @Override
    public void visit(SmartDevice device) {
        report.append("Urządzenie: ")
                .append(device.getName())
                .append(", ID: ")
                .append(device.getId())
                .append(", pokój: ")
                .append(device.getRoom())
                .append(", MAC: ")
                .append(device.getMacAddress())
                .append(", firmware: ")
                .append(device.getFirmwareVersion())
                .append(System.lineSeparator());
    }

    @Override
    public void visit(ThermostatAdapter thermostat) {
        report.append("Termostat: adapter aktywny, temperatura docelowa eco: ")
                .append(thermostat.calculateTargetTemperature(21, true))
                .append("°C")
                .append(System.lineSeparator());
    }

    @Override
    public void visit(LegacyThermostat thermostat) {
        report.append("Stary termostat: dostępny przez adapter")
                .append(System.lineSeparator());
    }

    @Override
    public void visit(DeviceDecorator decorator) {
        report.append("Dekorator urządzenia: ")
                .append(decorator.getClass().getSimpleName())
                .append(System.lineSeparator());
    }

    @Override
    public void visit(EnergyMonitoringDecorator decorator) {
        report.append("Monitoring energii: aktywny")
                .append(System.lineSeparator());
    }

    public String getReport() {
        return report.toString();
    }
}
