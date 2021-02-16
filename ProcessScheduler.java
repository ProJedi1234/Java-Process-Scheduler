// driver
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class ProcessScheduler {
    public static void main(String[] args) throws Exception {
        List<Process> processes = getProcessesFromFile(args[0]);

        FCFS fcfs = new FCFS(processes);
        fcfs.runScheduler();
        fcfs.saveCSVData();

        SJF sjf = new SJF(processes);
        sjf.runScheduler();
        sjf.saveCSVData();

        RoundRobin rb = new RoundRobin(processes, 20);
        rb.runScheduler();
        rb.saveCSVData();

        RoundRobin rb2 = new RoundRobin(processes, 40);
        rb2.runScheduler();
        rb2.saveCSVData();

        Lottery lottery = new Lottery(processes, 50);
        lottery.runScheduler();
        lottery.saveCSVData();

        getAverageLottery(processes, 1000);
    }

    private static List<Process> getProcessesFromFile(String filePath) throws Exception {
        File file = new File(filePath); 
        Scanner sc = new Scanner(file); 
    
        List<Process> processList = new LinkedList<Process>();

        while (sc.hasNextLine()) {
            Process process = new Process();
            process.PID = Integer.parseInt(sc.nextLine());
            process.burstTime = Integer.parseInt(sc.nextLine());
            process.priority = Integer.parseInt(sc.nextLine());

            processList.add(process);
        }

        sc.close();

        return processList;
    }

    private static void getAverageLottery(List<Process> processes, int numberOfTimes) {
        float total = 0;
        for (int i = 0; i < numberOfTimes; i++) {
            Lottery lotto = new Lottery(processes, 50);
            lotto.runScheduler();
            total += lotto.csvFile.getAverageCompletionTime();
        }

        System.out.println("Average for lottery: " + total/numberOfTimes);
    }
}