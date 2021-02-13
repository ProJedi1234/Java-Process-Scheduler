import java.util.ArrayList;
import java.util.List;

public class SJF extends Scheduler {
    public SJF(List<Process> processes) {
        super(processes);
    }

    @Override
    public void runScheduler() {
        int timePassed = 0;

        ArrayList<Process> processesList = new ArrayList<>();
        for (Process process : this.processList) {
            processesList.add(process);
        }

        while (processesList.size() > 0) {
            Process shortestProcess = processesList.get(0);
            for (Process process : processesList) {
                if (process.burstTime < shortestProcess.burstTime) {
                    shortestProcess = process;
                }
            }
            csvFile.rows.add(new CSVRow(timePassed, shortestProcess.PID, shortestProcess.burstTime, 0, timePassed + shortestProcess.burstTime));
            timePassed += shortestProcess.burstTime + 2;

            processesList.remove(shortestProcess);
        }
    }

    @Override
    public void saveCSVData() throws Exception {
        csvFile.saveFile("SJF-testfile.csv");
    }
}
