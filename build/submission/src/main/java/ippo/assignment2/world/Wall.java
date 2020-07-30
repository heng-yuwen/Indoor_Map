package ippo.assignment2.world;

import ippo.assignment2.item.ImageItem;
import ippo.assignment2.item.Item;

import java.util.*;

/**
 * A Wall class to represent the four directions in a room.
 * It contains the image of the room and the items to a particular direction.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class Wall {
    private String imageURL;

    private Map<String, Item> items;

//    /**
//     * Init the Wall object with corresponding picture.
//     * @param imageURL the name string of the image file
//     */
//    public Wall(String imageURL) {
//
//        this.imageURL = imageURL;
//        // the order is kept as the putting order
//        this.items = new LinkedHashMap<>();
//    }

    /**
     * Init the Wall object with prepared items.
     *
     * @param imageURL the name string of the image file
     * @param items    the items saved at this direction
     */
    public Wall(String imageURL, Map<String, Item> items) {

        this.imageURL = imageURL;
        this.items = items;
    }

    /**
     * Get the image of the wall.
     *
     * @return an Image object represents the image of the wall
     */
    public String getWallImage() {

        return this.imageURL;
    }

    /**
     * Add an item to the wall.
     *
     * @param item An Object object
     * @return true if item is not duplicated
     */
    public boolean addItem(Item item) {

        if(this.items.containsKey(item.toString())) {

            System.out.println("Duplicate items found, the system doesn't support this operation yet.");
            return false;
        } else {

            this.items.put(item.toString(), item);
            return true;
        }
    }

    /**
     * Remove the item from the direction
     *
     * @param itemName the name string of the Item object to be removed
     * @return the Item object removed
     */
    public Item removeItem(String itemName) {

        Item item = null;
        if(this.items.containsKey(itemName)) {

            item = this.items.get(itemName);
            this.items.remove(itemName);
        }
        return item;
    }

    /**
     * Get the name strings of all items in the direction.
     *
     * @return a Set object contains the name strings
     */
    public Set<String> getItemNames() {

        // HashSet object is used since order is not important
        LinkedHashSet<String> imageNames = new LinkedHashSet<>();
        for (String itemName : this.items.keySet()) {
            imageNames.add(itemName);
        }
        return imageNames;
    }

//    /**
//     * Get the image urls of the items in the direction.
//     *
//     * @return a Set object contains all the Image url strings of the Item objects in the direction
//     */
//    public Set<String> getImageItemURLs() {
//
//        // LinkedHashSet object is used to keep the order fixed
//        LinkedHashSet<String> urls = new LinkedHashSet<>();
//        for (Item item : this.items.values()) {
//            if (item instanceof ImageItem) {
//                urls.add(item.getItemURL());
//            }
//        }
//        return urls;
//    }
}
