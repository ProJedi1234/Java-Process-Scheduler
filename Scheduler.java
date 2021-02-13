import java.util.List;

public abstract class Scheduler {
    CSVFile csvFile;
    List<Process> processList;

    public Scheduler(List<Process> processList) {
        this.csvFile = new CSVFile();
        this.processList = processList;
    }
    public abstract void runScheduler();
    public abstract void saveCSVData() throws Exception;
}
