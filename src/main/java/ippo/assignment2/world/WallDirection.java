package ippo.assignment2.world;

import java.util.HashMap;

/**
 * A enum type represents the available directions of the room.
 */
public enum WallDirection {
    // four directions and their string names
    North("north"), East("east"), South("south"), West("west");

    private String direction;

    // a HashSet object to map the string name to the WallDirection object
    private static final HashMap<String, WallDirection> stringToWallDirections;

    static {
        stringToWallDirections = new HashMap<>();
        for (WallDirection wallDirection : WallDirection.values()) {
            stringToWallDirections.put(wallDirection.toString(), wallDirection);
        }
    }

    /**
     * init the WallDirection object
     *
     * @param direction name of the direction
     */
    WallDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Return the name of the direction.
     *
     * @return a String represents the name of the object
     */
    @Override
    public String toString() {
        return this.direction;
    }

    /**
     * Return right hand side direction.
     *
     * @return a right hand side WallDirection object
     */
    public WallDirection next() {
        switch (this) {
            case North:
                return East;
            case East:
                return South;
            case South:
                return West;
            case West:
                return North;

        }
        return null;
    }

    /**
     * Return left hand side direction.
     *
     * @return a left hand side WallDirection object
     */
    public WallDirection last() {
        switch (this) {
            case North:
                return West;
            case East:
                return North;
            case South:
                return East;
            case West:
                return South;
        }
        return null;
    }

    /**
     * Get the WallDirection object with the direction string.
     *
     * @param direction a String represents the name of the direction
     * @return a WallDirection object corresponding to the string
     */
    public static WallDirection getDirection(String direction) {
        return WallDirection.stringToWallDirections.get(direction);
    }
}
