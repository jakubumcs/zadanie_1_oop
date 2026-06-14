public class ThermostatAdapter implements ManageableDevice {
    private LegacyThermostat thermostat;

    public ThermostatAdapter(LegacyThermostat thermostat) {
        this.thermostat = thermostat;
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
}