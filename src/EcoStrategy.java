public class EcoStrategy implements HeatingStrategy {
    @Override
    public double calculateTargetTemperature(double currentTemp, boolean isSomeoneHome) {
        if (isSomeoneHome) {
            return 19;
        }
        return 15;
    }
}
