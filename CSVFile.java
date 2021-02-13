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
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
        } catch (Exception e) {
            System.out.println("An error occurred while saving your file");
        }
    }

    @Override
    public String toString() {
        String toReturn = "";

        for (CSVRow row : rows) {
            toReturn += row.toString() + "\n";
        }

        return toReturn;
    }
}
