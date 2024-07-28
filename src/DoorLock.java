public class DoorLock implements Device {
    private String id;
    private boolean isLocked;

    public DoorLock(String id) {
        this.id = id;
        this.isLocked = true;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "doorlock";
    }

    @Override
    public void turnOn() {
        // DoorLocks don't have an on/off state in this implementation
    }

    @Override
    public void turnOff() {
        // DoorLocks don't have an on/off state in this implementation
    }

    public void lock() {
        isLocked = true;
    }

    public void unlock() {
        isLocked = false;
    }

    @Override
    public String getStatus() {
        return "DoorLock " + id + " is " + (isLocked ? "Locked" : "Unlocked");
    }
}