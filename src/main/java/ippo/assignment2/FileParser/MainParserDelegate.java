package ippo.assignment2.FileParser;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ippo.assignment2.world.WorldMap;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

/**
 * An RoomParserDelegate class to parse WorldMap object based on file.
 * GsonBuilder is used to define deserialize rules, the parse rule for WorldMap is unchanged.
 * To support other format, change GsonBuilder to corresponding deserialize class.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public class MainParserDelegate extends AbstractParserDelegate {

    private JsonObject jsonObject;

    /**
     * Load the file and register next object to initialise.
     */
    public MainParserDelegate() {

        this.jsonObject = JsonParser.parseReader(new InputStreamReader(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("model" + ".json")))).getAsJsonObject();
        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeAdapter(WorldMap.class, new WorldMapParserDelegate());
        this.gsonBuilder.registerTypeAdapter(HashMap.class, new ItemURLParserDelegate());
        this.gson = this.gsonBuilder.create();
    }

    /**
     * Start to parse the WorldMap object.
     * @return a parsed WorldMap object.
     */
    public WorldMap parseWordMap() {

        return this.gson.fromJson(this.jsonObject.get("rooms"), WorldMap.class);
    }

    /**
     * Start to parse the item name to url map.
     * @return a parsed HashMap Object
     */
    public HashMap parseItemURL() {

        return this.gson.fromJson(this.jsonObject.get("items"), HashMap.class);
    }
}
