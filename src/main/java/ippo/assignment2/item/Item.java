package ippo.assignment2.item;


/**
 * An Item class to represent the item that can be put in the room or take with the Player object.
 * It contains the image and the name of the item.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.2;
 */
public abstract class Item {
    private String itemName;

    /**
     * Init the Item object.
     *
     * @param name     the name of the item
     */
    public Item(String name) {

        this.itemName = name;
    }

    /**
     * Represent the Item object with a String.
     *
     * @return the itemName field of the object
     */
    @Override
    public String toString() {

        return this.itemName;
    }
}
