package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * All of the crimes
 */
public class Cities {
    public static ArrayList<City> cities;
    public static HashMap<City, String> namem = new HashMap<City, String>();
	public static HashMap<City, Integer> populationm = new HashMap<City, Integer>();
	public static HashMap<City, Integer> violentm = new HashMap<City, Integer>();
	public static HashMap<City, Integer> murderm = new HashMap<City, Integer>();
	public static HashMap<City, Integer> rapem = new HashMap<City, Integer>();
	public static HashMap<City, Integer> robberym = new HashMap<City, Integer>();
	public static HashMap<City, Integer> assaultm = new HashMap<City, Integer>();
	public static HashMap<City, Integer> propertym = new HashMap<City, Integer>();
	public static HashMap<City, Integer> burglarym = new HashMap<City, Integer>();
	public static HashMap<City, Integer> larcenym = new HashMap<City, Integer>();
	public static HashMap<City, Integer> motorm = new HashMap<City, Integer>();



	public static void fillMaps() {
    	for(City c : cities) {
			namem.put(c, c.name);
			populationm.put(c, c.population);
			violentm.put(c, c.violent_crime);
			murderm.put(c, c.murder);
			rapem.put(c, c.rape);
			robberym.put(c, c.robbery);
			assaultm.put(c, c.assault);
			propertym.put(c, c.property);
			burglarym.put(c, c.burglary);
			larcenym.put(c, c.larceny);
			motorm.put(c, c.motor);
		}
    }

    public static float getPercentile(HashMap<City, Integer> mapping, int stats) {
        int size = mapping.size();
        Object[] mapping_obj = mapping.values().toArray();
        Integer[] values = Arrays.copyOf(mapping_obj, mapping_obj.length, Integer[].class);
        Arrays.sort(values);

        int counter = 0;
        boolean found = false;
        while (!found) {
            if(stats > values[counter]) {
                counter++;
            }
            else {
                found = true;
            }
        }
        return (float) counter / size;
    }
}