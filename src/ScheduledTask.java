public class ScheduledTask {
    private Device device;
    private String time;
    private String command;

    public ScheduledTask(Device device, String time, String command) {
        this.device = device;
        this.time = time;
        this.command = command;
    }

    public Device getDevice() {
        return device;
    }

    public String getTime() {
        return time;
    }

    public String getCommand() {
        return command;
    }
}