package General;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * All of the crimes
 */
public class Crimes {
    public static ArrayList<Crime> crimes;
    public static HashMap<Crime, String> primary_description_map;
    public static String[] primary_descriptions;
    public static HashMap<Integer, District> district_crimes;


    public static void mapPrimaryDescriptions() {
        primary_description_map = new HashMap<Crime, String>();
        for(Crime c : crimes) {
            primary_description_map.put(c, c.primary_description);
        }
    }
    
    public static void generateDistributions() {
    	district_crimes = new HashMap<Integer, District>();
    	for(Crime crime : crimes) {
    		int district = crime.beat/100;
    		int beat = crime.beat%100;
    		if(district_crimes.containsKey(district)) {
    			district_crimes.put(district, new District());
        		district_crimes.get(district).set(beat, 0);
    		}
    		district_crimes.get(district).set(beat, district_crimes.get(district).get(beat) + 1);
    	}
    }
}