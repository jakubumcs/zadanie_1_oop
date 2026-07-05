package smarthome.strategy;

public interface HeatingStrategy {
    double calculateTargetTemperature(double currentTemp, boolean isSomeoneHome);
}
