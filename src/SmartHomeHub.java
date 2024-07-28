import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Scanner;

public class SmartHomeHub {
    private Map<String, Device> devices = new HashMap<>();
    private List<ScheduledTask> scheduledTasks = new ArrayList<>();
    private TriggerManager triggerManager = new TriggerManager();

    public void addDevice(Device device) {
        DeviceProxy proxy = new DeviceProxy(device);
        devices.put(device.getId(), proxy);
    }

    public void removeDevice(String id) {
        devices.remove(id);
    }

    public void turnOnDevice(String id) {
        Device device = devices.get(id);
        if (device != null) {
            device.turnOn();
        }
    }

    public void turnOffDevice(String id) {
        Device device = devices.get(id);
        if (device != null) {
            device.turnOff();
        }
    }

    public void setSchedule(String id, String time, String command) {
        Device device = devices.get(id);
        if (device != null) {
            scheduledTasks.add(new ScheduledTask(device, time, command));
        }
    }

    public void addTrigger(String condition, String action) {
        triggerManager.addTrigger(new Trigger(condition, action));
    }

    public void showStatus() {
        StringBuilder status = new StringBuilder();
        for (Device device : devices.values()) {
            status.append(device.getStatus()).append(". ");
        }
        System.out.println("Status Report: \"" + status.toString().trim() + "\"");
    }

    public void showScheduledTasks() {
        StringBuilder taskReport = new StringBuilder("[");
        for (ScheduledTask task : scheduledTasks) {
            taskReport.append("{device: ").append(task.getDevice().getId())
                      .append(", time: \"").append(task.getTime())
                      .append("\", command: \"").append(task.getCommand())
                      .append("\"}, ");
        }
        if (!scheduledTasks.isEmpty()) {
            taskReport.setLength(taskReport.length() - 2); // Remove trailing comma
        }
        taskReport.append("]");
        System.out.println("Scheduled Tasks: \"" + taskReport.toString() + "\"");
    }

    public void showTriggers() {
        List<Trigger> triggers = triggerManager.getTriggers();
        StringBuilder triggerReport = new StringBuilder("[");
        for (Trigger trigger : triggers) {
            triggerReport.append("{condition: \"").append(trigger.getCondition())
                         .append("\", action: \"").append(trigger.getAction())
                         .append("\"}, ");
        }
        if (!triggers.isEmpty()) {
            triggerReport.setLength(triggerReport.length() - 2); // Remove trailing comma
        }
        triggerReport.append("]");
        System.out.println("Automated Triggers: \"" + triggerReport.toString() + "\"");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeHub hub = new SmartHomeHub();

        while (true) {
            System.out.println("Enter command (e.g., add, remove, turnOn, turnOff, schedule, trigger, status, tasks, triggers, exit):");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                break;
            }

            String[] commandParts = command.split(" ", 2);
            switch (commandParts[0]) {
                case "add":
                    System.out.println("Enter device type (light, thermostat, doorlock):");
                    String type = scanner.nextLine();
                    System.out.println("Enter device ID:");
                    String id = scanner.nextLine();
                    if (type.equals("thermostat")) {
                        System.out.println("Enter temperature:");
                        int temp = Integer.parseInt(scanner.nextLine());
                        hub.addDevice(DeviceFactory.createDevice(type, id, temp));
                    } else {
                        hub.addDevice(DeviceFactory.createDevice(type, id, 0));
                    }
                    break;

                case "remove":
                    System.out.println("Enter device ID to remove:");
                    String removeId = scanner.nextLine();
                    hub.removeDevice(removeId);
                    break;

                case "turnOn":
                    System.out.println("Enter device ID to turn on:");
                    String turnOnId = scanner.nextLine();
                    hub.turnOnDevice(turnOnId);
                    break;

                case "turnOff":
                    System.out.println("Enter device ID to turn off:");
                    String turnOffId = scanner.nextLine();
                    hub.turnOffDevice(turnOffId);
                    break;

                case "schedule":
                    System.out.println("Enter device ID to schedule:");
                    String scheduleId = scanner.nextLine();
                    System.out.println("Enter time to schedule (HH:MM):");
                    String time = scanner.nextLine();
                    System.out.println("Enter command (Turn On, Turn Off):");
                    String scheduleCommand = scanner.nextLine();
                    hub.setSchedule(scheduleId, time, scheduleCommand);
                    break;

                case "trigger":
                    System.out.println("Enter condition for trigger (e.g., temperature > 75):");
                    String condition = scanner.nextLine();
                    System.out.println("Enter action for trigger (e.g., turnOff(1)):");
                    String action = scanner.nextLine();
                    hub.addTrigger(condition, action);
                    break;

                case "status":
                    hub.showStatus();
                    break;

                case "tasks":
                    hub.showScheduledTasks();
                    break;

                case "triggers":
                    hub.showTriggers();
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        scanner.close();
    }
}
