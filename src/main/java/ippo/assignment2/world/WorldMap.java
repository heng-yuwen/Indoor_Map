package ippo.assignment2.world;

import java.util.HashMap;

/**
 * A WorldMap class stores the available rooms.
 */
public class WorldMap {

    HashMap<String, Room> rooms;

    /**
     * init the WorldMap object.
     */
    public WorldMap() {

        this.rooms = new HashMap<>();

        // init the Room objects
//        this.loadMap();
    }

    /**
     * init the WorldMap object.
     */
    public WorldMap(HashMap rooms) {

        this.rooms = rooms;
    }

//    /**
//     * Init the Room objects with config strings.
//     */
//    public void loadMap() {
//
//        this.rooms.put("bedroom", new Room("north: IMG_7746.jpeg, south: IMG_7744.jpeg, west: IMG_7747.jpeg, east: IMG_7745.jpeg", "north: lobby_corner", "north: [bell, flags]; south: [firecracker]"));
//        this.rooms.put("lobby_corner", new Room("north: IMG_7748.jpeg, south: IMG_7750.jpeg, west: IMG_7749.jpeg, east: IMG_7751.jpeg", "south: bedroom, west: lobby", "south: [balloon]"));
//        this.rooms.put("lobby", new Room("north: IMG_7755.jpeg, south: IMG_7753.jpeg, west: IMG_7752.jpeg, east: IMG_7754.jpeg", "east: lobby_corner, north: kitchen", "west: [beer]"));
//        this.rooms.put("kitchen", new Room("north: IMG_7756.jpeg, south: IMG_7759.jpeg, east: IMG_7758.jpeg" , "south: lobby", "east: [cake, record]; north: [gift, clock]"));
//    }

    /**
     * Get the starting Room object.
     *
     * @return a Room object
     */
    public Room getDefaultRoom() {

        return this.rooms.get("bedroom");
    }

    /**
     * Get the starting direction.
     *
     * @return a WallDirection object
     */
    public WallDirection getDefaultDirection() {

        return WallDirection.getDirection("south");
    }

    /**
     * Get the room object for a given string.
     *
     * @param roomName a String represents the
     * @return
     */
    public Room getRoom(String roomName) {

        return this.rooms.get(roomName);
    }
}
