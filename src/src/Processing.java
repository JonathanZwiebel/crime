import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class
 */
public class Processing {
    public static final String FILENAME = "C:\\Users\\admin\\Desktop\\crimedata.csv";

    public static void main(String[] args) {
        Crimes.crimes = new ArrayList();

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
            int case_number = Integer.parseInt(stats[0].substring(2));
            int day = Integer.parseInt(stats[1].substring(stats[1].indexOf('/') + 1, stats[1].indexOf('/', 2)));
            boolean arrest = (stats[5].indexOf('Y') != -1);
            boolean domestic = (stats[6].indexOf('Y') != -1);
            int beat = Integer.parseInt(stats[7]);

            Crimes.crimes.add(new Crime(case_number, day, stats[2], stats[3], stats[4], arrest, domestic, beat));
        }
    }
}