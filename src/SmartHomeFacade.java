public class SmartHomeFacade {
    private final HomeHub homeHub;

    public SmartHomeFacade(HomeHub homeHub) {
        this.homeHub = homeHub;
    }

    public void goodNightRoutine() {
        System.out.println("Starting good night routine...");

        for (ManageableDevice device : homeHub.getDevices()) {
            ManageableDevice baseDevice = unwrap(device);

            if (isLight(baseDevice)) {
                device.turnOff();
            } else if (isThermostat(baseDevice)) {
                System.out.println("Lowering thermostat temperature for the night.");
                device.turnOff();
            }
        }

        System.out.println("Energy saving mode enabled.");
    }

    public void movieMode() {
        System.out.println("Starting movie mode...");

        for (ManageableDevice device : homeHub.getDevices()) {
            ManageableDevice baseDevice = unwrap(device);

            if (isMainLight(baseDevice)) {
                device.turnOff();
            } else if (isTv(baseDevice)) {
                device.turnOn();
            }
        }
    }

    private ManageableDevice unwrap(ManageableDevice device) {
        while (device instanceof DeviceDecorator) {
            device = ((DeviceDecorator) device).device;
        }
        return device;
    }

    private boolean isLight(ManageableDevice device) {
        if (!(device instanceof SmartDevice)) {
            return false;
        }

        String name = ((SmartDevice) device).getName().toLowerCase();
        return name.contains("bulb") || name.contains("light") || name.contains("lamp");
    }

    private boolean isMainLight(ManageableDevice device) {
        if (!(device instanceof SmartDevice)) {
            return false;
        }

        String name = ((SmartDevice) device).getName().toLowerCase();
        return name.contains("main light") || name.contains("bulb") || name.contains("light");
    }

    private boolean isThermostat(ManageableDevice device) {
        if (device instanceof ThermostatAdapter) {
            return true;
        }

        if (!(device instanceof SmartDevice)) {
            return false;
        }

        String name = ((SmartDevice) device).getName().toLowerCase();
        return name.contains("thermostat");
    }

    private boolean isTv(ManageableDevice device) {
        if (!(device instanceof SmartDevice)) {
            return false;
        }

        String name = ((SmartDevice) device).getName().toLowerCase();
        return name.contains("tv") || name.contains("television");
    }
}
