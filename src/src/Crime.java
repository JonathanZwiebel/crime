/**
 * One crime
 */
public class Crime {
    public String primary_description, secondary_description, location;
    public int district, sector, beat, day, case_number;
    public boolean arrest, domestic;

    public Crime(int case_number, int day, String primary_description, String secondary_description, String location,
                 boolean arrest, boolean domestic, int district, int sector, int beat) {
        this.case_number = case_number;
        this.day = day;
        this.primary_description = primary_description;
        this.secondary_description = secondary_description;
        this.location = location;
        this.arrest = arrest;
        this.domestic = domestic;
        this.district = district;
        this.sector = sector;
        this.beat = beat;
    }
}