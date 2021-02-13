import java.util.ArrayList;
import java.util.List;

public class RoundRobin extends Scheduler {
    int quantum;

    public RoundRobin(List<Process> processes, int quantum) {
        super(processes);
        this.quantum = quantum;
    }

    @Override
    public void runScheduler() {
        int timePassed = 0;

        ArrayList<Process> processesList = new ArrayList<>();
        for (Process process : this.processList) {
            processesList.add(process);
        }

        while (getTotalBurst(processesList) > 0) {
            for (Process process : processesList) {
                if (process.burstTime > quantum) {
                    csvFile.rows.add(new CSVRow(timePassed, process.PID, process.burstTime, 0, 0));
                    timePassed += quantum + 2;
                    process.burstTime = process.burstTime - quantum;
                } else if (process.burstTime != 0) {
                    csvFile.rows.add(new CSVRow(timePassed, process.PID, process.burstTime, 0, timePassed + process.burstTime));
                    timePassed += process.burstTime + 2;
                    process.burstTime = 0;
                }
            }
        }
    }

    @Override
    public void saveCSVData() throws Exception {
        csvFile.saveFile("RB-" + quantum + "-testfile.csv");
    }

    private int getTotalBurst(ArrayList<Process> list) {
        int total = 0;
        for (Process process : list) {
            total += process.burstTime;
        }

        return total;
    }
}
