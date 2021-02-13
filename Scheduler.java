import java.util.List;

public abstract class Scheduler {
    List<Process> processList;

    public Scheduler(List<Process> processList) {
        this.processList = processList;
    }
    public abstract void runScheduler();
}
