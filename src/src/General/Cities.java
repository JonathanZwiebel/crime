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
	public static HashMap<City, Float> populationm = new HashMap<City, Float>();

    // PER CAPITA
	public static HashMap<City, Float> violentm = new HashMap<City, Float>();
	public static HashMap<City, Float> murderm = new HashMap<City, Float>();
	public static HashMap<City, Float> rapem = new HashMap<City, Float>();
	public static HashMap<City, Float> robberym = new HashMap<City, Float>();
	public static HashMap<City, Float> assaultm = new HashMap<City, Float>();
	public static HashMap<City, Float> propertym = new HashMap<City, Float>();
	public static HashMap<City, Float> burglarym = new HashMap<City, Float>();
	public static HashMap<City, Float> larcenym = new HashMap<City, Float>();
	public static HashMap<City, Float> motorm = new HashMap<City, Float>();



	public static void fillMaps() {
    	for(City c : cities) {
			namem.put(c, c.name);
            float pop = c.population;
			populationm.put(c, pop);
			violentm.put(c, c.violent_crime / pop);
			murderm.put(c, c.murder / pop);
			rapem.put(c, c.rape / pop);
			robberym.put(c, c.robbery / pop);
			assaultm.put(c, c.assault / pop);
			propertym.put(c, c.property / pop);
			burglarym.put(c, c.burglary / pop);
			larcenym.put(c, c.larceny / pop);
			motorm.put(c, c.motor / pop);
		}
    }

    public static float getPercentile(HashMap<City, Float> mapping, float stats) {
        int size = mapping.size();
        Object[] mapping_obj = mapping.values().toArray();
        Float[] values = Arrays.copyOf(mapping_obj, mapping_obj.length, Float[].class);
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