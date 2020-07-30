package ippo.assignment2.item;


/**
 * An ImageItem class to represent the item that can be put in the room or take with the Player object.
 * It contains the image and the name of the item.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public class ImageItem extends Item {

    private static final String type = "images";

    /**
     * Init the Item object.
     *
     * @param name    the name of the item
     */
    public ImageItem(String name) {

        super(name);
    }

    /**
     * Get the type of the Item, for example, image.
     * @return the type of the Item
     */
    public static String getType() {

        return type;
    }

}
