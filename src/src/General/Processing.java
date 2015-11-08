package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main class
 */
public class Processing {
    public static String FILENAME = "src\\Crimes\\crimedata.csv";
    public static String CITY_FILENAME = "C:\\Users\\admin\\Desktop\\citycrimes.csv";

    public static void main(String[] args) {
        Crimes.crimes = new ArrayList();
        Cities.cities = new ArrayList();
        try {
            readCrimes();
            readCities();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cities.fillMaps();
        System.out.print(Cities.cities.get(15));
        System.out.println();
        float percentile = Cities.getPercentile(Cities.populationm, 4000000);
        System.out.println("Percentile: " + percentile);

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

    public static void readCities() throws IOException {
        FileReader file_reader = new FileReader(CITY_FILENAME);
        BufferedReader reader = new BufferedReader(file_reader);

        String line;

        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] stats = line.split(",");
            String name;
            int population, violent, murder, rape, robbery, assault, property, burglary, larceny, motor;
            name = stats[0];
            population = Integer.parseInt(stats[1]);
            violent = Integer.parseInt(stats[2]);
            murder = Integer.parseInt(stats[3]);
            rape = Integer.parseInt(stats[4]);
            robbery = Integer.parseInt(stats[5]);
            assault = Integer.parseInt(stats[6]);
            property = Integer.parseInt(stats[7]);
            burglary = Integer.parseInt(stats[8]);
            larceny = Integer.parseInt(stats[9]);
            motor = Integer.parseInt(stats[10]);

           Cities.cities.add(new City(name, population, violent, murder, rape, robbery, assault, property, burglary, larceny, motor));
        }
    }

    /**
     * Generates a HashMap between a unique string identifier and the frequency
     * @return HashMap between primary_descriptions and their frequency
     */
    public static HashMap<String, Integer> generatePrimaryDescriptionMap() {
        HashMap<String, Integer> unique = new HashMap();


        for(Crime c : Crimes.crimes) {
            if(!unique.containsKey(c.primary_description)) {
                unique.put(c.primary_description, 1);
            }
            else {
                unique.put(c.primary_description, unique.get(c.primary_description) + 1);
            }
        }
        return unique;
    }


    /**
     * Generates a HashMap between a unique string identifier and the frequency
     * @return HashMap between location and their frequency
     */
    public static HashMap<String, Integer> generateLocationMap() {
        HashMap<String, Integer> unique = new HashMap();


        for(Crime c : Crimes.crimes) {
            if(!unique.containsKey(c.location)) {
                unique.put(c.location, 1);
            }
            else {
                unique.put(c.location, unique.get(c.location) + 1);
            }
        }
        return unique;
    }
}