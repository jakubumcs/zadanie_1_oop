import java.util.ArrayList;
import java.util.List;

public class HomeHub {
    private static HomeHub instance;

    private final List<SmartDevice> devices;

    private HomeHub() {
        this.devices = new ArrayList<>();
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }
}
