public class Process {
    int PID;
    int burstTime;
    int priority;

    public Process(int PID, int burstTime, int priority) {
        this.PID = PID;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ID: " + PID + ", BurstTime: " + burstTime + ", Priority: " + priority;
    }
}
