package ippo.assignment2.FileParser;

import com.google.gson.*;
import ippo.assignment2.world.Room;
import ippo.assignment2.world.WorldMap;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * An WorldMapParserDelegate class to parse WorldMap object based on file.
 * GsonBuilder is used to define deserialize rules.
 * To support other format, change GsonBuilder to corresponding deserialize class.
 * See https://futurestud.io/tutorials/gson-advanced-custom-deserialization-basics for explanation.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public class WorldMapParserDelegate extends AbstractParserDelegate implements JsonDeserializer {

    /**
     * Init a WorldMapParserDelegate object, point to next level parser.
     */
    public WorldMapParserDelegate() {

        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeAdapter(Room.class, new RoomParserDelegate());
        this.gson = this.gsonBuilder.create();
    }

    @Override
    public WorldMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        HashMap<String, Room> rooms = new HashMap<>();
        JsonObject jsonObject = json.getAsJsonObject();
        for(String roomName : jsonObject.keySet()) {

            rooms.put(roomName, this.gson.fromJson(jsonObject.get(roomName), Room.class));
        }
        return new WorldMap(rooms);
    }
}
