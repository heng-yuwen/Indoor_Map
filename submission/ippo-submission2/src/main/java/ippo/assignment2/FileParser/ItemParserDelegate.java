package ippo.assignment2.FileParser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import ippo.assignment2.item.ImageItem;
import ippo.assignment2.item.Item;
import java.lang.reflect.Type;

/**
 * An ItemParserDelegate class to parse Item object based on file.
 * GsonBuilder is used to define deserialize rules.
 * To support other format, change GsonBuilder to corresponding deserialize class.
 * See https://futurestud.io/tutorials/gson-advanced-custom-deserialization-basics for explanation.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public class ItemParserDelegate extends AbstractParserDelegate implements JsonDeserializer {

    @Override
    public Item deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        if(json != null) {
            String jsonObject = json.getAsString();
            return new ImageItem(jsonObject);
        } else {
            throw new IllegalArgumentException("Invalid Item string received when parsing the file");
        }
    }
}
