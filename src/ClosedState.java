public class ClosedState implements BlindState {
    private final SmartBlind smartBlind;

    public ClosedState(SmartBlind smartBlind) {
        this.smartBlind = smartBlind;
    }

    @Override
    public void open() {
        smartBlind.setState(new MovingState(smartBlind));
        System.out.println("Roleta zaczyna się otwierać");
    }

    @Override
    public void close() {
        System.out.println("Roleta już jest zamknięta");
    }

    @Override
    public void stop() {
        System.out.println("Roleta jest zamknięta");
    }
}
