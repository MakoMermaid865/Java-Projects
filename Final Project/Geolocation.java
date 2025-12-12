import java.io.Serializable;
import java.util.Arrays;

//use serializable to convert object into byte stream
public class Geolocation implements Serializable {
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
