import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Lottery extends Scheduler {
    int quantum;

    public Lottery(List<Process> processes, int quantum) {
        super(processes);
        this.quantum = quantum;
    }

    @Override
    public void runScheduler() {
        int timePassed = 0;

        ArrayList<Process> processesList = new ArrayList<>();
        for (Process process : this.processList) {
            processesList.add(new Process(process.PID, process.burstTime, process.priority));
        }

        while (getTotalBurst(processesList) > 0) {
            int randomValue = new Random().nextInt(getTotalPriority(processesList) + 1);
            Process currentProcess = processesList.get(0);
            int totalAddedValue = 0;
            for (Process process : processesList) {
                totalAddedValue += process.priority;
                if (totalAddedValue > randomValue) {
                    currentProcess = process;
                    break;
                }
            }


            if (currentProcess.burstTime > quantum) {
                csvFile.rows.add(new CSVRow(timePassed, currentProcess.PID, currentProcess.burstTime, 0, 0));
                timePassed += quantum + 2;
                currentProcess.burstTime = currentProcess.burstTime - quantum;
            } else if (currentProcess.burstTime != 0) {
                csvFile.rows.add(new CSVRow(timePassed, currentProcess.PID, currentProcess.burstTime, 0, timePassed + currentProcess.burstTime));
                timePassed += currentProcess.burstTime + 2;
                currentProcess.burstTime = 0;
                processesList.remove(currentProcess);
            }
        }
    }

    @Override
    public void saveCSVData() throws Exception {
        csvFile.saveFile("Lottery-" + quantum + "-testfile.csv");
    }

    private int getTotalBurst(ArrayList<Process> list) {
        int total = 0;
        for (Process process : list) {
            total += process.burstTime;
        }

        return total;
    }
    private int getTotalPriority(ArrayList<Process> list) {
        int total = 0;
        for (Process process : list) {
            total += process.priority;
        }

        return total;
    }
}
