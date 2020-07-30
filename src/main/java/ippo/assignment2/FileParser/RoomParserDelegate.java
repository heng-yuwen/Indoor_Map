package ippo.assignment2.FileParser;

import com.google.gson.*;
import ippo.assignment2.item.ImageItem;
import ippo.assignment2.world.Room;
import ippo.assignment2.world.Wall;
import ippo.assignment2.world.WallDirection;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * An RoomParserDelegate class to parse Room object based on file.
 * GsonBuilder is used to define deserialize rules.
 * To support other format, change GsonBuilder to corresponding deserialize class.
 * See https://futurestud.io/tutorials/gson-advanced-custom-deserialization-basics for explanation.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public class RoomParserDelegate extends AbstractParserDelegate implements JsonDeserializer {

    /**
     * Init a RoomParserDelegate object, point to next level parser.
     */
    public RoomParserDelegate() {

        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeAdapter(Wall.class, new WallParserDelegate());
        this.gson = this.gsonBuilder.create();
    }

    @Override
    public Room deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();


        Map<WallDirection, Wall> wallDirectionsToWalls = new HashMap<>();
        Map<WallDirection, String> exits = new HashMap<>();

        JsonObject viewObject = null;
        JsonObject exitObject = null;

        if(jsonObject.has("views") && jsonObject.has("exits")) {

            viewObject = jsonObject.getAsJsonObject("views");
            exitObject = jsonObject.getAsJsonObject("exits");
        } else {

            throw new IllegalArgumentException("Invalid JSON file format: no views node or exits node found in room node");
        }


        for (String direction : viewObject.keySet()) {
            Wall w = this.gson.fromJson(viewObject.get(direction), Wall.class);
            wallDirectionsToWalls.put(WallDirection.getDirection(direction), w);
        }
        for (String direction : exitObject.keySet()) {
            exits.put(WallDirection.getDirection(direction), exitObject.get(direction).getAsString());
        }

        return new Room(wallDirectionsToWalls, exits);

    }
}
