# Java Scheduler
This is a simple project for simulating an operating system task scheduler. Make sure java is installed on your machine before attempting to compile
## Included schedulers
- First-Come-First-Serve (FCFS)
- Shortest-Job-First (SJF)
- Round-Robin with time quantum = 20
- Round-Robin with time quantum = 50
- Lottery with time quantum = 50

## Building Instructions
- Navigate to source code folder in command line
- `javac ProcessScheduler.java`
- `java ProcessScheduler data_file.dat`

## Formatting Datasets

Each line of the text files needs to contain data about the processes

The line structure is as follows:

1. Process ID
2. Burst time
3. Priority