public interface Device {
    String getId();
    String getType();
    void turnOn();
    void turnOff();
    String getStatus();
}