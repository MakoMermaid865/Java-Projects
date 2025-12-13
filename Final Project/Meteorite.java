import java.io.Serializable;
import java.util.Arrays;

//use serializable to convert object into byte stream
class Geolocation implements Serializable {
    private String type;
    private double[] coordinates; 

    // Getters
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the coordinates
     */
    public double[] getCoordinates() {
        return coordinates;
    }

    /**
     * @return the string representation of Geolocation
"geolocation": { 
"type": "Point", 
"coordinates": [ 
6.08333, 
50.775 
] 
     */
    @Override
    public String toString() {  
        return "Geolocation { type = " + type + " , coordinates = [ " + Arrays.toString(coordinates) + "]";
    }

    
}

public class Meteorite {
    
/**
 * This is the outline to follow
 * [
"name": "Aachen", 
"id": "1", 
"nametype": "Valid", 
"recclass": "L5", 
"mass": "21", 
"fall": "Fell", 
"year": "1880-01-01T00:00:00.000", 
"reclat": "50.775000", 
"reclong": "6.083330", 
"geolocation": { 
"type": "Point", 
"coordinates": [ 
6.08333, 
50.775 
]
 */

private String name;
private String id;
private String nametype;
private String recclass;
private String mass; 
private String fall;
private String year;
private String reclat;
private String reclong;
private Geolocation geolocation; 

// Getters

/**
 * @return the name
 */
public String getName() {
    return name;
}

/**
 * @return the id
 */
public String getID() {
    return id;
}

/**
 * @return the nametype
 */
public String getNametype() {
    return nametype;
}

/**
 * @return the recclass
 */
public String getRecclass() {
    return recclass;
}

/**
 * @return the mass
 */
public String getMass() {
    return mass;
}

/**
 * @return the fall
 */
public String getFall() {
    return fall;
}

/**
 * @return the year
 */
public String getYear() {
    return year;
}

/**
 * @return the reclat
 */
public String getReclat() {
    return reclat;
}

/**
 * @return the reclong
 */
public String getReclong() {
    return reclong;
}

/**
 * @return the geolocation
 */
public Geolocation getGeolocation() {
    return geolocation;
}

// mass as a double
/**
 * @return mass as double
 */
public double getMassDouble() {
try {
        return Double.parseDouble(mass);
    } catch (Exception e) {
        return 0.0;
     } 
    }

//year as an integer
/**
 * @return year as integer
 */
public int getYearInt() {
    try {
        //"year": "1880-01-01T00:00:00.000", 
        return Integer.parseInt(year.substring(0, 4));
    } catch (NumberFormatException e) {
        return 0; 
    }
}

/**
 * @return reclat as double
 */
public double getReclatDouble() {
    try {
        return Double.parseDouble(reclat);
    } catch (NumberFormatException e) {
        return 0.0;
    }
}

/**
 * @return reclong as double
 */
public double getReclongDouble() {
    try {
        return Double.parseDouble(reclong);
    } catch (NumberFormatException e) {
        return 0.0; 
    }
}


//display meteor info
/**
Prompt the user for the name of a meteorite.  Retrieve the meteorite object and output the 
String returned by the display method.  Output a message if no meteorite by that 
name exists.
 * @return
 */
public String display(){
    return String.format(
            "name = %s, id = %s, recclass = %s, mass = %s, year = %s",
            name,
            id,
            recclass,
            mass,
            (year != null && year.length() >= 4) ? year.substring(0, 4) : "N/A");
            
}


//Option 2
/**
Display the data in the array using the Meteorite toString method so we can verify 
that the data import operation succeeded.  

 */
@Override
public String toString() {
    return "Meteor { " +
            "name = '" + name + '\'' +
            ", id = " + id +
            ", nametype = '" + nametype + '\'' +
            ", recclass = '" + recclass + '\'' +
            ", mass = " + mass +
            ", fall = '" + fall + '\'' +
            ", year = '" + year + '\'' +
            ", reclat = " + reclat +
            ", reclong = " + reclong +
            ", geolocation = " + geolocation +
            " }";
}
}
