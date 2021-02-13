import java.util.ArrayList;

public class CSVFile {
    ArrayList<CSVRow> rows;

    public CSVFile() {
        rows = new ArrayList<CSVRow>();
    }
    public CSVFile(ArrayList<CSVRow> rows) {
        this.rows = rows;
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
