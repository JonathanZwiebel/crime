package general;

import java.io.Serializable;

public class City implements Serializable {
    public String name;
    int population, violent_crime, murder, rape, robbery, assault, property, burglary, larceny, motor, arson;

    public City(String name, int population, int violent_crime, int murder, int rape, int robbery, int assault, int property, int burglary, int larceny, int motor, int arson) {
        this.name = name;
        this.population = population;
        this.violent_crime = violent_crime;
        this.murder = murder;
        this.rape = rape;
        this.robbery = robbery;
        this.assault = assault;
        this.property = property;
        this.burglary = burglary;
        this.larceny = larceny;
        this.motor = motor;
        this.arson = arson;
    }

    public String toString() {
        String ret = "";
        ret += "Name: " + name;
        ret += " | Population: " + population;
        ret += " | Violent Crime: " + violent_crime;
        ret += " | Murder: " + murder;
        ret += " | Rape: " + rape;
        ret += " | Robbery: "  + robbery;
        ret += " | Assault: " + assault;
        ret += " | Property: " + property;
        ret += " | Burglary: " + burglary;
        ret += " | Rape: " + rape;
        ret += " | Larceny: "  + larceny;
        ret += " | Motor: " + motor;
        ret += " | Arson: " + arson;
        return ret;
    }
}
