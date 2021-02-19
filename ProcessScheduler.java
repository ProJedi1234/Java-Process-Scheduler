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

        RoundRobin rb2 = new RoundRobin(processes, 50);
        rb2.runScheduler();
        rb2.saveCSVData();

        Lottery lottery = new Lottery(processes, 50);
        lottery.runScheduler();
        lottery.saveCSVData();

        getAverageLottery(processes, 1000);

        //Print summary
        System.out.printf("FCFS:\t\t%.4f%n", fcfs.csvFile.getAverageCompletionTime());
        System.out.printf("SJF:\t\t%.4f%n", sjf.csvFile.getAverageCompletionTime());
        System.out.printf("RR 20:\t\t%.4f%n", rb.csvFile.getAverageCompletionTime());
        System.out.printf("RR 50:\t\t%.4f%n", rb2.csvFile.getAverageCompletionTime());
        System.out.printf("Lottery Avg:\t%.4f%n", getAverageLottery(processes, 1000));
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

    private static float getAverageLottery(List<Process> processes, int numberOfTimes) {
        float total = 0;
        for (int i = 0; i < numberOfTimes; i++) {
            Lottery lotto = new Lottery(processes, 50);
            lotto.runScheduler();
            total += lotto.csvFile.getAverageCompletionTime();
        }

        return total/numberOfTimes;
    }
}