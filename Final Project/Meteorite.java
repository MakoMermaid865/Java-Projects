

public class Meteor {
    
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
private Integer id;
private String nametype;
private String recclass;
private double mass; //can be 21 integer or 21.5 double best to use double
private String fall;
private String year;
private double reclat;
private double reclong;
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
public Integer getID() {
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
public double getMass() {
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
public double getReclat() {
    return reclat;
}

/**
 * @return the reclong
 */
public double getReclong() {
    return reclong;
}

/**
 * @return the geolocation
 */
public Geolocation getGeolocation() {
    return geolocation;
}

// mass as a double
public double getMassDouble() {
    // mass is already stored as a double
    return mass;
}

//year as an integer
public int getYearInt() {
    if (year == null || year.isEmpty()) {
        return 0; // or throw an exception, or handle as needed
    }
    try {
        //"year": "1880-01-01T00:00:00.000", 
        return Integer.parseInt(year.substring(0, 4));
    } catch (NumberFormatException e) {
        return 0; // or handle the error as needed
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
            "Name: %s\nID: %s\nNametype: %s\nRecclass: %s\nMass: %.2f\nFall: %s\nYear: %s\nReclat: %.6f\nReclong: %.6f\nGeolocation: %s",
            name,
            id != null ? id.toString() : "null",
            nametype,
            recclass,
            mass,
            fall,
            year,
            reclat,
            reclong,
            geolocation != null ? geolocation.toString() : "null");
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
