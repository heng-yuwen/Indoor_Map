package ippo.assignment2.world;

import ippo.assignment2.item.Item;

import java.util.Map;
import java.util.Set;

/**
 * A Room class to represent the real world room.
 * It handles the directions(walls) that a room has and the exits of the room.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class Room {
    private Map<WallDirection, Wall> wallDirectionsToWalls;
    private Map<WallDirection, String> exits;

//    /**
//     * Init the Room object.
//     */
//    public Room() {
//
//        this.wallDirectionsToWalls = new HashMap<>();
//        this.exits = new HashMap<>();
//
//        this.parseRoomsConfig(roomsConfig);
//        this.parseExitsConfig(exitsConfig);
//        this.parseItemsConfig(itemsConfig);
//    }

    public Room(Map<WallDirection, Wall> wallDirectionsToWalls, Map<WallDirection, String> exits) {
        this.wallDirectionsToWalls = wallDirectionsToWalls;
        this.exits = exits;
    }

    /**
     * Get the image of a particular direction
     *
     * @param wallDirection a WallDirection object describe the direction of the room
     * @return an Image object of the desired wallDirection
     */
    public String getWallImage(WallDirection wallDirection) {

        return this.wallDirectionsToWalls.get(wallDirection).getWallImage();
    }

    /**
     * Get the first right hand side WallDirection object based on the direction given.
     * Please notice that if only one direction is available of the room, it will return the same WallDirection as the given one.
     *
     * @param currentWall a WallDirection object represents current direction
     * @return a WallDirection object to the right of the given direction
     */
    public WallDirection nextWallDirection(WallDirection currentWall) {

        while (this.wallDirectionsToWalls.get(currentWall.next()) == null) {
            currentWall = currentWall.next();
        }
        return currentWall.next();
    }

    /**
     * Get the first left hand side WallDirection object based on the direction given.
     * Please notice that if only one direction is available of the room, it will return the same WallDirection as the given one.
     *
     * @param currentWallDirection a WallDirection object represents current direction
     * @return a WallDirection object to the left of the given direction
     */
    public WallDirection lastWallDirection(WallDirection currentWallDirection) {

        while (this.wallDirectionsToWalls.get(currentWallDirection.last()) == null) {
            currentWallDirection = currentWallDirection.last();
        }
        return currentWallDirection.last();
    }

    /**
     * Check if the given WallDirection has a door(an exit).
     *
     * @param currentWallDirection
     * @return if the given direction has a door, return true, if not, return false
     */
    public boolean checkExit(WallDirection currentWallDirection) {

        return this.exits.keySet().contains(currentWallDirection);
    }

    /**
     * Get the next room name of the given direction.
     *
     * @param currentWallDirection the WallDirection object represents current direction
     * @return a string represents the name of the next room
     */
    public String getNextRoomName(WallDirection currentWallDirection) {

        return this.exits.get(currentWallDirection);
    }

    /**
     * Add an item to the given direction.
     *
     * @param direction a WallDirection object
     * @param item      an Item object
     * @return true if the item is not duplicated
     */
    public boolean addItem(WallDirection direction, Item item) {

        return this.wallDirectionsToWalls.get(direction).addItem(item);
    }

    /**
     * Remove an item from the given direction.
     *
     * @param direction a WallDirection object
     * @param itemName  a String represents the name of the item
     * @return the removed Item object
     */
    public Item removeItem(WallDirection direction, String itemName) {

        return this.wallDirectionsToWalls.get(direction).removeItem(itemName);
    }

    /**
     * Get the names of the items for the given direction
     *
     * @param currentWallDirection a WallDirection object
     * @return a Set object of item name strings
     */
    public Set<String> getWallItemNames(WallDirection currentWallDirection) {

        return this.wallDirectionsToWalls.get(currentWallDirection).getItemNames();
    }

//    /**
//     * Get the image urls of the items for the given direction
//     *
//     * @param currentWallDirection a WallDirection object
//     * @return a Set String of item url
//     */
//    public Set<String> getWallImageItemURLs(WallDirection currentWallDirection) {
//
//        return this.wallDirectionsToWalls.get(currentWallDirection).getImageItemURLs();
//    }

//    private void parseItemsConfig(String config) {
//
//        for(String direction : config.split(";")) {
//            String[] itemList = direction.strip().split(":");
//            String directionName = itemList[0];
//            String items = itemList[1].strip();
//            items = items.substring(items.indexOf("[") + 1, items.indexOf("]"));
//            String[] itemsList = items.split(",");
//
//            for(String item: itemsList) {
//
//                this.wallDirectionsToWalls.get(WallDirection.getDirection(directionName)).addItem(new ImageItem(item.strip(), item.strip()+".png"));
//            }
//        }
//    }
//
//    /**
//     * Parse the room config string.
//     * @param config the string that defines the walls it has
//     */
//    private void parseRoomsConfig(String config) {
//
//        for(String wall : config.split(",")) {
//            String[] wallList = wall.strip().split(":");
//            String direction = wallList[0].strip();
//            String imageURL = wallList[1].strip();
//            this.wallDirectionsToWalls.put(WallDirection.getDirection(direction), new Wall(imageURL));
//        }
//    }
//
//    /**
//     * Parse the exits config string.
//     * @param config the string that defines the exit directions and the name of next room
//     */
//    private void parseExitsConfig(String config) {
//
//        for(String exit : config.split(",")) {
//            String[] exitList = exit.strip().split(":");
//            String direction = exitList[0].strip();
//            String roomName = exitList[1].strip();
//            this.exits.put(WallDirection.getDirection(direction), roomName);
//        }
//    }
}
