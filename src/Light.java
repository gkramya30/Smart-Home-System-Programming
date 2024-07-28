public class Light implements Device {
    private String id;
    private boolean isOn;

    public Light(String id) {
        this.id = id;
        this.isOn = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "light";
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + (isOn ? "On" : "Off");
    }
}
