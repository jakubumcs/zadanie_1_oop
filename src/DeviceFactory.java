public class DeviceFactory {
    public static SmartBulb createLivingRoomBulb(String id, String name) throws InvalidMacAddressException {
        String macAddress = "AA:BB:CC:DD:EE:FF";
        if (macAddress.length() < 17 || !macAddress.contains(":")) {
            throw new InvalidMacAddressException("Invalid MAC address");
        }
        return new SmartBulb(id, name, "Living Room", macAddress, 2.0);
    }

    public static SmartDevice createBasicThermostat(String id) {
        return new SmartDevice.Builder(id, "Thermostat")
                .withFirmwareVersion(1.0)
                .build();
    }
}
