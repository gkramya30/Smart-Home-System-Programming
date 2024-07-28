import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<ScheduledTask> tasks = new ArrayList<>();

    public void addTask(ScheduledTask task) {
        tasks.add(task);
    }

    public List<ScheduledTask> getTasks() {
        return tasks;
    }
}