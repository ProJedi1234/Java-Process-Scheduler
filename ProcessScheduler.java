// driver
import java.io.File; 
import java.util.Scanner; 

class ProcessScheduler {
    public static void main(String[] args) throws Exception {
        Process p1 = new Process(1, 500, 1);

        System.out.println(p1.toString());

        File file = new File(args[0]); 
        Scanner sc = new Scanner(file); 
    
        while (sc.hasNextLine()) 
            System.out.println(sc.nextLine()); 
    }
}