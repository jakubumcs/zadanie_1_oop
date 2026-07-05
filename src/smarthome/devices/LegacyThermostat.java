package smarthome.devices;

import smarthome.visitor.DeviceVisitor;

public class LegacyThermostat {
    void enableHeating() {
        System.out.println("Legacy thermostat: heating enabled.");
    }

    void disableHeating() {
        System.out.println("Legacy thermostat: heating disabled.");
    }

    void fetchCurrentTemperature() {
        System.out.println("Legacy thermostat: current temperature is 21°C.");
    }

    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}
