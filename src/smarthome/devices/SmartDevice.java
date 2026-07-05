package smarthome.devices;

import smarthome.core.ManageableDevice;
import smarthome.exceptions.InvalidMacAddressException;
import smarthome.visitor.DeviceVisitor;

public class SmartDevice implements Comparable<SmartDevice>, ManageableDevice {
    private final String id;
    private final String name;
    private final String room;
    private final String macAddress;
    private final double firmwareVersion;

    private SmartDevice(Builder builder) {
        this(builder.id, builder.name, builder.room, builder.macAddress, builder.firmwareVersion);
    }

    public SmartDevice(String id, String name, String room, String macAddress, double firmwareVersion) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.macAddress = macAddress;
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public double getFirmwareVersion() {
        return firmwareVersion;
    }

    @Override
    public int compareTo(SmartDevice other) {
        int nameComparison = name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        if (room == null && other.room == null) {
            return 0;
        }
        if (room == null) {
            return -1;
        }
        if (other.room == null) {
            return 1;
        }
        return room.compareTo(other.room);
    }

    @Override
    public void turnOn() {
        System.out.println("Smart device " + name + " is turned on.");

    }

    @Override
    public void turnOff() {
        System.out.println("Smart device " + name + " is turned off.");

    }

    @Override
    public void getStatus() {
        System.out.println("Smart device " + name + " is running firmware version " + firmwareVersion);

    }

    public static class Builder {
        private final String id;
        private final String name;
        private String room;
        private String macAddress;
        private double firmwareVersion;

        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder withRoom(String room) {
            this.room = room;
            return this;
        }

        public Builder withMacAddress(String macAddress) throws InvalidMacAddressException {
            if (macAddress.length() < 17 || !macAddress.contains(":")) {
                throw new InvalidMacAddressException("Invalid MAC address");
            }
            this.macAddress = macAddress;
            return this;
        }

        public Builder withFirmwareVersion(double firmwareVersion) {
            this.firmwareVersion = firmwareVersion;
            return this;
        }

        public SmartDevice build() {
            return new SmartDevice(this);
        }
    }
}
