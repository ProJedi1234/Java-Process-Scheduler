import java.util.List;

public class FCFS extends Scheduler {
    public FCFS(List<Process> processes) {
        super(processes);
    }

    @Override
    public void runScheduler() {
        int timePassed = 0;
        for (Process process : processList) {
            csvFile.rows.add(new CSVRow(timePassed, process.PID, process.burstTime, 0, process.burstTime));
            timePassed += process.burstTime;
        }

        System.out.println(csvFile);
    }
}
