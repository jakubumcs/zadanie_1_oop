void main() {
    try {
        new SmartDevice.Builder("1", "Sensor")
                .withMacAddress("123")
                .build();
    } catch (InvalidMacAddressException e) {
        IO.println(e.getMessage());
    }
    LegacyThermostat legacyThermostat = new LegacyThermostat();
    ThermostatAdapter thermostatAdapter = new ThermostatAdapter(legacyThermostat);

    HomeHub homeHub = HomeHub.getInstance();
    homeHub.registerDevice(thermostatAdapter);

    thermostatAdapter.turnOn();
    thermostatAdapter.getStatus();
    thermostatAdapter.turnOff();
}
