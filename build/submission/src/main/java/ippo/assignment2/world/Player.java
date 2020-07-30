package ippo.assignment2.world;

import ippo.assignment2.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * A Player class to represent the user.
 * It handles the data about which room it is in, which direction it faces at, the map of the rooms, and the items it has.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class Player {

    private Room currentRoom;
    private WallDirection currentWallDirection;
    private Boolean canForward;
    private Map<String, Item> items;
    private WorldMap worldMap;

    /**
     * Init the Player object.
     */
    public Player(WorldMap worldMap) {

        // create a WorldMap object by hard coding map
        this.worldMap = worldMap;

        // get the starting point of the application
        this.currentRoom = this.worldMap.getDefaultRoom();
        this.currentWallDirection = this.worldMap.getDefaultDirection();

        // create a map to store the items with order
        this.items = new LinkedHashMap<>();

        // create Item objects with setting string
//        this.initItems("bell: bell.png, balloon: balloon.png");

        // update the canForward field
        this.checkForward();
    }

    /**
     * Update the currentWallDirection field to the left one based on currentWallDirection field.
     */
    public void turnLeft() {

        this.currentWallDirection = this.currentRoom.lastWallDirection(this.currentWallDirection);
        this.checkForward();
    }

    /**
     * Update the currentWallDirection field to the right one based on currentWallDirection field.
     */
    public void turnRight() {

        this.currentWallDirection = this.currentRoom.nextWallDirection(this.currentWallDirection);
        this.checkForward();
    }

    /**
     * Return the room picture of current direction(wall) that the player can see.
     *
     * @return the image of the room to the current direction.
     */
    public String getCurrentImage() {

        return this.currentRoom.getWallImage(this.currentWallDirection);
    }

    /**
     * Return if the current direction has a door(an exit).
     *
     * @return if true, it means that there is a door(an exit) of current direction.
     */
    public boolean canForward() {

        return this.canForward;
    }

    /**
     * Update the canForward field.
     * If the current direction has a door(an exit), set it true, if not, set it false.
     */
    public void checkForward() {

        this.canForward = this.currentRoom.checkExit(this.currentWallDirection);
    }

    /**
     * Get the name string of next room.
     *
     * @return if current direction is an exit, return the name of next room, else return null.
     */
    public String getNextRoomName() {

        if (canForward) {
            return this.currentRoom.getNextRoomName(this.currentWallDirection);
        } else {
            return null;
        }
    }

    /**
     * Set the room that the Player is in.
     */
    private void setRoom(Room room) {

        this.currentRoom = room;
        this.checkForward();
    }

//    /**
//     * Create Item objects that the Player object has based on the string.
//     */
//    public void initItems(String itemList) {
//
//        for(String item : itemList.split(",")) {
//            String[] itemInfo = item.strip().split(":");
//            String itemName = itemInfo[0].strip();
//            String itemURL = itemInfo[1].strip();
//            this.items.put(itemName, new Item(itemName, itemURL));
//        }
//    }

    /**
     * Pick up an item from the room(and more precisely, from current direction, the Wall object).
     */
    public void pickItem(String itemName) {

        if(this.items.containsKey(itemName)) {

            System.out.println("Duplicate items found, the system doesn't support this operation yet.");
        } else {

            // Remove the item from current room
            Item item = this.currentRoom.removeItem(this.currentWallDirection, itemName);

            // add it to the Player object
            this.items.put(item.toString(), item);
        }
    }

    /**
     * Drop up an item to the room(and more precisely, from current direction, the Wall object).
     */
    public void dropItem(String itemName) {

        if(this.items.containsKey(itemName)) {

            if(this.currentRoom.addItem(this.currentWallDirection, this.items.get(itemName))) {
                this.items.remove(itemName);
            }
        }
    }

    /**
     * Get the item name strings that the Player has in a set.
     *
     * @return a set contains the names of the items
     */
    public Set<String> getPlayerItemList() {

        return this.items.keySet();
    }

    /**
     * Get the item name strings in the room with current direction in a set.
     *
     * @return a set contains the names of the items
     */
    public Set<String> getWallItemNameList() {

        return this.currentRoom.getWallItemNames(this.currentWallDirection);
    }

//    /**
//     * Get the image item urls that are inside the room, from current direction, in a set.
//     *
//     * @return a set of String objects represent the item url
//     */
//    public Set<String> getWallImageItemURLs() {
//
//        return this.currentRoom.getWallImageItemURLs(this.currentWallDirection);
//    }

    /**
     * Move to the next room if there is a door(an exit) to the current direction.
     */
    public void forward() {

        if (this.canForward()) {
            this.setRoom(this.worldMap.getRoom(this.getNextRoomName()));
        }
    }
}
