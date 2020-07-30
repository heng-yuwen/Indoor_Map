package ippo.assignment2.world;

import ippo.assignment2.FileParser.MainParserDelegate;
import ippo.assignment2.item.ImageItem;

import java.util.*;

/**
 * A Model class to handle data of the application.
 * This class delegates the actions that the Player object can perform and store the WorldMap object which represents the Rooms and their exits.
 * This class complies with the MVC design pattern.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class Model {
    private WorldMap worldMap;
    private Map<String, Player> stringPlayerMap;
    private String currentPlayer;
    private Map<String, String> itemURL;

    public Model() {

        // create a WorldMap object from file
        MainParserDelegate mainParserDelegate = new MainParserDelegate();
        this.worldMap = mainParserDelegate.parseWordMap();
        this.itemURL = mainParserDelegate.parseItemURL();

        // use HashMap to store Player objects to support multiple players
        this.stringPlayerMap = new HashMap<>();
        this.stringPlayerMap.put("player" + (this.stringPlayerMap.size() + 1), new Player(this.worldMap));
        this.stringPlayerMap.put("player" + (this.stringPlayerMap.size() + 1), new Player(this.worldMap));
        this.currentPlayer = "player1";
    }

    /**
     * Get all the registered player names to initialize interface.
     *
     * @return a Set contains player name strings
     */
    public Set<String> getPlayerSet() {

        HashSet<String> players = new HashSet<>();
        for (String player : this.stringPlayerMap.keySet()) {
            players.add(player);
        }
        return players;
    }

    /**
     * Ask the player object to return the wall image that the player is facing at.
     */
    public String getCurrentWallImage() {

        return this.stringPlayerMap.get(this.currentPlayer).getCurrentImage();
    }

    /**
     * Ask the player object to turn left.
     */
    public void turnLeft() {

        this.stringPlayerMap.get(this.currentPlayer).turnLeft();
    }

    /**
     * Ask the player object to turn right.
     */
    public void turnRight() {

        this.stringPlayerMap.get(this.currentPlayer).turnRight();
    }

    /**
     * Ask the player object to move forward.
     */
    public void forward() {

        this.stringPlayerMap.get(this.currentPlayer).forward();
    }

    /**
     * Ask the player object to check if the front wall has a door(exit) or not.
     */
    public boolean checkForwardCommand() {

        return this.stringPlayerMap.get(this.currentPlayer).canForward();
    }

    /**
     * Ask the player object to return all the items that it has.
     */
    public Set<String> getPlayerItems() {

        return this.stringPlayerMap.get(this.currentPlayer).getPlayerItemList();
    }

    /**
     * Ask the player object to return all the items that it can see in string format.
     */
    public Set<String> getWallItems() {

        return this.stringPlayerMap.get(this.currentPlayer).getWallItemNameList();
    }

    /**
     * Ask the player object to put the selected item.
     *
     * @param itemName the name of the selected item
     */
    public void playerPutItem(String itemName) {

        this.stringPlayerMap.get(this.currentPlayer).dropItem(itemName);
    }

    /**
     * Ask the player object to pick the selected item.
     *
     * @param itemName the name of the selected item
     */
    public void playerPickItem(String itemName) {

        this.stringPlayerMap.get(this.currentPlayer).pickItem(itemName);

    }

    /**
     * Ask the player object to return all the image item url strings that it can see.
     */
    public Set<String> getWallImageItemURLs() {

        LinkedHashSet<String> itemImageURLs = new LinkedHashSet<>();
        for(String itemName : this.stringPlayerMap.get(this.currentPlayer).getWallItemNameList()) {
            itemImageURLs.add(ImageItem.getType() + "/" + itemURL.get(itemName));
        }
        return itemImageURLs;
    }

    /**
     * Switch the current player that we are playing with.
     *
     * @param playerName a String represents the player that we want to play with
     */
    public void switchPlayer(String playerName) {

        if (!this.currentPlayer.equals(playerName)) {

            this.currentPlayer = playerName;
        }
    }
}
