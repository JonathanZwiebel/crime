import java.util.ArrayList;
import java.util.HashMap;

/**
 * All of the crimes
 */
public class Crimes {
    public static ArrayList<Crime> crimes;
    public static HashMap<Crime, String> primary_description_map;


    public static void mapPrimaryDescriptions() {
        for(Crime c : crimes) {
            primary_description_map.put(c, c.primary_description);
        }
    }


}