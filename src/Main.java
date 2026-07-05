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
    DiagnosticReportVisitor diagnosticReportVisitor = new DiagnosticReportVisitor();

    homeHub.registerDevice(thermostatAdapter);

    thermostatAdapter.turnOn();
    thermostatAdapter.getStatus();
    thermostatAdapter.turnOff();
    thermostatAdapter.setStrategy(new EcoStrategy());
    thermostatAdapter.adjustTemperature(21, false);
    thermostatAdapter.adjustTemperature(21, true);
    thermostatAdapter.setStrategy(new ComfortStrategy());
    thermostatAdapter.adjustTemperature(21, false);

    try {
        SmartDevice bulb = DeviceFactory.createLivingRoomBulb("2", "Bulb");
        ManageableDevice monitoredBulb = new EnergyMonitoringDecorator(bulb);

        homeHub.registerDevice(monitoredBulb);

        monitoredBulb.turnOn();
        bulb.accept(diagnosticReportVisitor);
        monitoredBulb.accept(diagnosticReportVisitor);
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
        tv.accept(diagnosticReportVisitor);
    } catch (InvalidMacAddressException e) {
        IO.println(e.getMessage());
    }

    thermostatAdapter.accept(diagnosticReportVisitor);
    legacyThermostat.accept(diagnosticReportVisitor);

    SmartHomeFacade smartHomeFacade = new SmartHomeFacade(homeHub);
    smartHomeFacade.movieMode();
    smartHomeFacade.goodNightRoutine();

    MotionSensor motionSensor = new MotionSensor("MOTION-1");
    motionSensor.attach(homeHub);
    motionSensor.detectMotion();

    SmartBlind smartBlind = new SmartBlind();
    smartBlind.openBlind();
    smartBlind.openBlind();
    smartBlind.closeBlind();
    smartBlind.closeBlind();
}
