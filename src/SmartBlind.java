public class SmartBlind {
    private BlindState state;

    public SmartBlind() {
        this.state = new ClosedState(this);
    }

    public void setState(BlindState state) {
        this.state = state;
    }

    public void openBlind() {
        state.open();
    }

    public void closeBlind() {
        state.close();
    }

    public void stopBlind() {
        state.stop();
    }
}
