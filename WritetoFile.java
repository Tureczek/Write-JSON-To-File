import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;


public class WritetoFile {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        String path = System.getProperty("user.dir") + "/";
        try (FileReader reader = new FileReader(path + "unece.json")) {
            Object object = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) object;

            JSONArray world = new JSONArray();
            JSONArray worldInfo = new JSONArray();


            for (Object o : jsonArray) {
                JSONObject worldObject = new JSONObject();
                JSONObject jsonObject = (JSONObject) o;
                worldObject.put("Country ", jsonObject.get("Country"));
                worldObject.put("Total population ", jsonObject.get("Total population"));
                worldObject.put("Year ", jsonObject.get("Year"));
                worldInfo.add(worldObject);
            }

            for (Object ja: worldInfo){
                System.out.println(ja);

            }
            FileWriter file = new FileWriter("newJSONCountryFile.json");
            file.write(String.valueOf(worldInfo));



            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                world.add(((JSONObject) o).get("Country"));
                world.add(((JSONObject) o).get("Year"));
                world.add(((JSONObject) o).get("Total population"));
            }

            System.out.println(world.get(1) + " : " + world.get(2) + " : " + world.get(3) + "\n");



        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
