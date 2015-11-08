import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class
 */
public class Processing {
    public static final String FILENAME = "C:\\Users\\admin\\Desktop\\crimedata.csv";

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
            int case_number = Integer.parseInt(stats[0].substring(2));
            int day = Integer.parseInt(stats[1].substring(stats[1].indexOf('/'), stats[1].indexOf('/', 2)));
            boolean arrest = stats[5].indexOf(0) == 'Y';
            boolean domestic = stats[6].indexOf(0) == 'Y';
            int beat = Integer.parseInt(stats[7]);

            Crimes.crimes.add(new Crime(case_number, day, stats[2], stats[3], stats[4], arrest, domestic, beat));
        }
    }
}