public class DeviceFactory {
    public static SmartDevice createLivingRoomBulb(String id, String name) throws InvalidMacAddressException {
        return new SmartDevice.Builder(id, name)
                .withRoom("Living Room")
                .withMacAddress("AA:BB:CC:DD:EE:FF")
                .withFirmwareVersion(2.0)
                .build();
    }

    public static SmartDevice createBasicThermostat(String id) {
        return new SmartDevice.Builder(id, "Thermostat")
                .withFirmwareVersion(1.0)
                .build();
    }
}
