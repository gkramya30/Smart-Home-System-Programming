public class Thermostat implements Device {
    private String id;
    private int temperature;

    public Thermostat(String id, int temperature) {
        this.id = id;
        this.temperature = temperature;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "thermostat";
    }

    @Override
    public void turnOn() {
        // Thermostats don't have an on/off state in this implementation
    }

    @Override
    public void turnOff() {
        // Thermostats don't have an on/off state in this implementation
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees";
    }
}