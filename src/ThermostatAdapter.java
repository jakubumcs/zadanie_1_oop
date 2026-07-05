public class ThermostatAdapter implements ManageableDevice {
    private LegacyThermostat thermostat;
    private HeatingStrategy strategy;

    public ThermostatAdapter(LegacyThermostat thermostat) {
        this.thermostat = thermostat;
        this.strategy = new EcoStrategy();
    }

    public void setStrategy(HeatingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateTargetTemperature(double currentTemp, boolean isSomeoneHome) {
        return strategy.calculateTargetTemperature(currentTemp, isSomeoneHome);
    }

    public void adjustTemperature(double currentTemp, boolean isSomeoneHome) {
        double targetTemperature = calculateTargetTemperature(currentTemp, isSomeoneHome);
        System.out.println("Thermostat target temperature: " + targetTemperature + "°C.");
    }

    @Override
    public void turnOn() {
        thermostat.enableHeating();
    }

    @Override
    public void turnOff() {
        thermostat.disableHeating();
    }

    @Override
    public void getStatus() {
        thermostat.fetchCurrentTemperature();
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}
