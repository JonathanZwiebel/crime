package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * All of the crimes
 */
public class Crimes {
    public static ArrayList<Crime> crimes;
    public static HashMap<Integer, District> district_crimes;
    
    public static void generateDistributions() {
    	district_crimes = new HashMap<Integer, District>();
    	for(Crime crime : crimes) {
    		int district = crime.beat/100;
    		int beat = crime.beat%100;
    		if(!district_crimes.containsKey(district)) {
    			district_crimes.put(district, new District(district));
        		district_crimes.get(district).set(beat, 1);
    		}
    		else {
    			if(district_crimes.get(district).get(beat) == 0) {
    				district_crimes.get(district).set(beat, 1);
    			}
    			else {
    				district_crimes.get(district).set(beat, district_crimes.get(district).get(beat) + 1);
    			}
    		}
    	}
    	
    	ArrayList<District> sorted_districts = new ArrayList<District>();

    	for(District district : district_crimes.values()) {
    		boolean added = false;
	    	for(int i = 0; i < sorted_districts.size(); i ++) {
	    		if(district.getTotal() < sorted_districts.get(i).getTotal()) {
	    			sorted_districts.add(i, district);
	    			added = true;
	    			break;
	    		}
	    	}
	    	if(!added) {
	    		sorted_districts.add(district);
	    	}
    	}
    	
    	System.out.println("\nDistricts Sorted by Crime Number:");
    	for(int i = 0; i < sorted_districts.size(); i ++) {
    		System.out.println("District " + sorted_districts.get(i).num + ": " + sorted_districts.get(i).getTotal());
    	}
    	System.out.println();
    }
}