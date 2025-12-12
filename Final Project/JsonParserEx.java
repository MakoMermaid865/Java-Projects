import com.google.gson.JsonObject;

public class JsonParserEx {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\" }";

        // Parse JSON string to JsonObject
        JsonObject jsonObject = com.google.gson.JsonParser.parseString(jsonString).getAsJsonObject();

        // Access data from JsonObject
        String name = jsonObject.get("name").getAsString();
        int age = jsonObject.get("age").getAsInt();
        String city = jsonObject.get("city").getAsString();

        // Print the extracted data
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
    }
    
}
