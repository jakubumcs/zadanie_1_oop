void main() {
    HomeHub homeHub = HomeHub.getInstance();

    try {
        new SmartDevice.Builder("1", "Sensor")
                .withMacAddress("123")
                .build();
    } catch (InvalidMacAddressException e) {
        IO.println(e.getMessage());
    }
    LegacyThermostat legacyThermostat = new LegacyThermostat();
    ThermostatAdapter thermostatAdapter = new ThermostatAdapter(legacyThermostat);

    homeHub.registerDevice(thermostatAdapter);

    thermostatAdapter.turnOn();
    thermostatAdapter.getStatus();
    thermostatAdapter.turnOff();
    try {
        SmartDevice bulb = DeviceFactory.createLivingRoomBulb("2", "Bulb");
        ManageableDevice monitoredBulb = new EnergyMonitoringDecorator(bulb);

        homeHub.registerDevice(monitoredBulb);

        monitoredBulb.turnOn();
    } catch (InvalidMacAddressException e) {
        IO.println(e.getMessage());
    }

    try {
        ManageableDevice tv = new SmartDevice.Builder("3", "TV")
                .withRoom("Living Room")
                .withMacAddress("AA:BB:CC:DD:EE:01")
                .withFirmwareVersion(1.5)
                .build();

        homeHub.registerDevice(tv);
    } catch (InvalidMacAddressException e) {
        IO.println(e.getMessage());
    }

    SmartHomeFacade smartHomeFacade = new SmartHomeFacade(homeHub);
    smartHomeFacade.movieMode();
    smartHomeFacade.goodNightRoutine();

    MotionSensor motionSensor = new MotionSensor("MOTION-1");
    motionSensor.attach(homeHub);
    motionSensor.detectMotion();
}
