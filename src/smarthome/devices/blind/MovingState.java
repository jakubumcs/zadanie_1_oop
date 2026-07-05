package smarthome.devices.blind;

public class MovingState implements BlindState {
    private final SmartBlind smartBlind;

    public MovingState(SmartBlind smartBlind) {
        this.smartBlind = smartBlind;
    }

    @Override
    public void open() {
        smartBlind.setState(new OpenedState(smartBlind));
        System.out.println("Roleta została otwarta");
    }

    @Override
    public void close() {
        smartBlind.setState(new ClosedState(smartBlind));
        System.out.println("Roleta została zamknięta");
    }

    @Override
    public void stop() {
        System.out.println("Roleta zatrzymana");
    }
}
