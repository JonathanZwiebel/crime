import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class
 */
public class Processing {
    public static final String FILENAME = "crimes.csv";

    public static void main(String[] args) {
        try {
            readCrimes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readCrimes() throws IOException {
        FileReader file_reader = new FileReader(FILENAME);
        BufferedReader reader = new BufferedReader(file_reader);

        String line;

        while ((line = reader.readLine()) != null) {
            String[] stats = line.split(",");
            for (String s : stats) {
                System.out.print(s + " | ");
            }
            System.out.println();
        }
    }
}