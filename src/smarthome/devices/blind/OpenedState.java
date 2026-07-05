package smarthome.devices.blind;

public class OpenedState implements BlindState {
    private final SmartBlind smartBlind;

    public OpenedState(SmartBlind smartBlind) {
        this.smartBlind = smartBlind;
    }

    @Override
    public void open() {
        System.out.println("Roleta już jest otwarta");
    }

    @Override
    public void close() {
        smartBlind.setState(new MovingState(smartBlind));
        System.out.println("Roleta zaczyna się zamykać");
    }

    @Override
    public void stop() {
        System.out.println("Roleta jest otwarta");
    }
}
