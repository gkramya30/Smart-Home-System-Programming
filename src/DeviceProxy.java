// DeviceProxy.java
public class DeviceProxy implements Device {
    private Device realDevice;

    public DeviceProxy(Device realDevice) {
        this.realDevice = realDevice;
    }

    @Override
    public String getId() {
        return realDevice.getId();
    }

    @Override
    public String getType() {
        return realDevice.getType();
    }

    @Override
    public void turnOn() {
        System.out.println("Proxy: Turning on device " + realDevice.getId());
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Proxy: Turning off device " + realDevice.getId());
        realDevice.turnOff();
    }

    @Override
    public String getStatus() {
        return realDevice.getStatus();
    }
}
