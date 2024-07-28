public class DeviceFactory {
    public static Device createDevice(String type, String id, int temperature) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, temperature);
            case "doorlock":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Invalid device type: " + type);
        }
    }
}