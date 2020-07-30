package ippo.assignment2.FileParser;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * An ItemURLParserDelegate class to parse HashSet object based on file.
 * GsonBuilder is used to define deserialize rules.
 * To support other format, change GsonBuilder to corresponding deserialize class.
 * See https://futurestud.io/tutorials/gson-advanced-custom-deserialization-basics for explanation.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public class ItemURLParserDelegate  extends AbstractParserDelegate implements JsonDeserializer {

    @Override
    public HashMap<String, String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        HashMap<String, String> itemURLs = new HashMap<>();
        for(String itemName : jsonObject.keySet()) {

            try{

                itemURLs.put(itemName, jsonObject.getAsJsonObject(itemName).get("image").getAsString());
            } catch (NullPointerException e) {

                throw new IllegalArgumentException("Invalid JSON file format: no image node found in item node");
            }
        }

        return itemURLs;
    }
}
