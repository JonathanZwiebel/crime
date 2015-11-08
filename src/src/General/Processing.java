package General;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Main class
 */
public class Processing {
    public static String FILENAME = "Crimes/crimedata.csv";

    public static void main(String[] args) {
        Crimes.crimes = new ArrayList();
        try {
            readCrimes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        LinkedHashSet<String> unique_crimes = new LinkedHashSet();
        Crimes.mapPrimaryDescriptions();
        Object[] primary_descriptions_obj = Crimes.primary_description_map.values().toArray();
        Crimes.primary_descriptions = Arrays.copyOf(primary_descriptions_obj, primary_descriptions_obj.length, String[].class);

        for(String crime : Crimes.primary_descriptions) {
            unique_crimes.add(crime);
        }
        for(String crime : unique_crimes) {
            System.out.println(crime);
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