package ippo.assignment2.FileParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * An abstract class to provide Gson object and GsonBuilder object for all class parsers.
 * GsonBuilder is used to define deserialize rules.
 * To support other format, change GsonBuilder to corresponding deserialize class.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public abstract class AbstractParserDelegate {

    // to support other format, change these objects with similar functions
    protected Gson gson;
    protected GsonBuilder gsonBuilder;
}
