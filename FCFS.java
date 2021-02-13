import java.util.List;

public class FCFS extends Scheduler {
    public FCFS(List<Process> processes) {
        super(processes);
    }

    @Override
    public void runScheduler() {
        int timePassed = 0;
        for (Process process : processList) {
            csvFile.rows.add(new CSVRow(timePassed, process.PID, process.burstTime, 0, timePassed + process.burstTime));
            timePassed += process.burstTime + 2;
        }

        System.out.println(csvFile);
    }
}
