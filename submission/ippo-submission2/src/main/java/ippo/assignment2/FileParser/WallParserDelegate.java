package ippo.assignment2.FileParser;

import com.google.gson.*;
import ippo.assignment2.item.ImageItem;
import ippo.assignment2.item.Item;
import ippo.assignment2.world.Wall;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An RoomParserDelegate class to parse Wall object based on file.
 * GsonBuilder is used to define deserialize rules.
 * To support other format, change GsonBuilder to corresponding deserialize class.
 * See https://futurestud.io/tutorials/gson-advanced-custom-deserialization-basics for explanation.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public class WallParserDelegate extends AbstractParserDelegate implements JsonDeserializer {

    /**
     * Init a WallParserDelegate object, point to next level parser.
     */
    public WallParserDelegate() {

        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeAdapter(ImageItem.class, new ItemParserDelegate());
        this.gson = this.gsonBuilder.create();
    }

    @Override
    public Wall deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject wallObject = json.getAsJsonObject();

        Map<String, Item> items = new LinkedHashMap<>();
        String imageURL = null;
        JsonArray itemNameList = null;
        if(wallObject.has("image") && wallObject.has("contents")) {

            imageURL = wallObject.get("image").getAsString();
            itemNameList = wallObject.getAsJsonArray("contents");
        } else {
            throw new IllegalArgumentException("Invalid JSON file format: no image node or contents node found in wall node");
        }

        for (JsonElement itemName : itemNameList) {

            String itemNameStr = itemName.getAsString();
            items.put(itemNameStr, this.gson.fromJson(itemName, ImageItem.class));
        }
        return new Wall(imageURL, items);
    }
}
