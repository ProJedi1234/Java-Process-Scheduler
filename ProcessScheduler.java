// driver
import java.io.File;
import java.util.ArrayList;
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
        System.out.println(sjf.csvFile);
        sjf.saveCSVData();
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
}