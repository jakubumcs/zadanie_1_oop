package smarthome.factory;

import smarthome.devices.SmartBulb;
import smarthome.devices.SmartDevice;
import smarthome.exceptions.InvalidMacAddressException;

public class DeviceFactory {
    public static SmartBulb createLivingRoomBulb(String id, String name) throws InvalidMacAddressException {
        SmartDevice device = new SmartDevice.Builder(id, name)
                .withRoom("Living Room")
                .withMacAddress("AA:BB:CC:DD:EE:FF")
                .withFirmwareVersion(2.0)
                .build();
        return new SmartBulb(device.getId(), device.getName(), device.getRoom(), device.getMacAddress(), device.getFirmwareVersion());
    }

    public static SmartDevice createBasicThermostat(String id) {
        return new SmartDevice.Builder(id, "Thermostat")
                .withFirmwareVersion(1.0)
                .build();
    }
}
