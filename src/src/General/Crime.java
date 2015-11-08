package general;

import java.io.Serializable;

/**
 * One crime
 */
public class Crime implements Serializable {
    public String primary_description, secondary_description, location;
    public int beat, day, case_number;
    public boolean arrest, domestic;

    // TODO(Jonathan): Add district and sector
    public Crime(int case_number, int day, String primary_description, String secondary_description, String location,
                 boolean arrest, boolean domestic, int beat) {
        this.case_number = case_number;
        this.day = day;
        this.primary_description = primary_description;
        this.secondary_description = secondary_description;
        this.location = location;
        this.arrest = arrest;
        this.domestic = domestic;
        this.beat = beat;
    }

    public String toString() {
        String ret = "";
        ret += "Case Number: " + case_number;
        ret += " | Day: " + day;
        ret += " | Primary Description: " + primary_description;
        ret += " | Secondary Description: " + secondary_description;
        ret += " | Location: " + location;
        ret += " | Arrest: "  + arrest;
        ret += " | Domestic: " + domestic;
        ret += " | Beat: " + beat;
        return ret;
    }
}