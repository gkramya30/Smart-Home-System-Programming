import java.util.ArrayList;
import java.util.List;

public class TriggerManager {
    private List<Trigger> triggers = new ArrayList<>();

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }
}