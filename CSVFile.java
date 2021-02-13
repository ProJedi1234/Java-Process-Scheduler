import java.io.FileWriter;
import java.util.ArrayList;

public class CSVFile {
    ArrayList<CSVRow> rows;

    public CSVFile() {
        rows = new ArrayList<CSVRow>();
    }
    public CSVFile(ArrayList<CSVRow> rows) {
        this.rows = rows;
    }

    public void saveFile(String fileName) throws Exception {
        try(FileWriter myWriter = new FileWriter(fileName)) {
            myWriter.write(toString());
        } catch (Exception e) {
            System.out.println("An error occurred while saving your file");
        }
    }

    public Float getAverageCompletionTime() {
        Float total = 0f;
        for (CSVRow row : rows) {
            total += row.Complete;
        }

        return total/rows.size();
    }

    @Override
    public String toString() {
        String toReturn = "";

        toReturn += "Proc Time,PID,Start Burst,End Burst, Complete\n";

        for (CSVRow row : rows) {
            toReturn += row.toString() + "\n";
        }

        toReturn += "Average,,,," + getAverageCompletionTime();

        return toReturn;
    }
}
