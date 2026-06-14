import java.time.LocalDateTime;

public class EnergyMonitoringDecorator extends DeviceDecorator {
    public EnergyMonitoringDecorator(ManageableDevice device) {
        super(device);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Device turned on at: " + LocalDateTime.now());
    }
}