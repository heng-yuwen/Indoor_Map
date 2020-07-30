package ippo.assignment2.view;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.Set;

/**
 * A MenuView class to update corresponding JavaFX view's states named "MenuView.fxml".
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.3;
 */
public class MenuView extends JavaFxView {

    @FXML
    private ImageView wallImage;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    @FXML
    private Button forwardButton;

    @FXML
    private GridPane imageBox;

    @FXML
    private Menu putDownMenu;

    @FXML
    private Menu pickUpMenu;

    @FXML
    private Menu playerMenu;

    @FXML
    public void initialize() {

        // init navigator button set
        this.initNavigator();
    }

    /**
     * Initialise the navigator buttons' events with command words.
     */
    private void initNavigator() {

        this.addButtonEvent(leftButton, "Turn Left");
        this.addButtonEvent(rightButton, "Turn Right");
        this.addButtonEvent(forwardButton, "Forward");
    }

    /**
     * Update everything the Player object is facing at.
     */
    public void update(Image wallImage, boolean canForward, Set<Image> itemImageSet, Set<String> playerItems, Set<String> wallItems, Set<String> playerSet) {

        this.showCurrentWallImage(wallImage);
        this.setForwardState(canForward);
        this.showItemImage(itemImageSet);
        this.updateItemsWithPlayer(playerItems);
        this.updateItemsInWall(wallItems);
        this.updatePlayerList(playerSet);
    }

    /**
     * Show the image of current wall.
     *
     * @param image current wall image
     */
    private void showCurrentWallImage(Image image) {
        this.wallImage.setImage(image);
    }

    /**
     * Update the forward button states.
     *
     * @param canForward if the wall contains exit or not
     */
    private void setForwardState(boolean canForward) {
        this.forwardButton.setDisable(!canForward);
    }

    /**
     * Show the item images with proper margin.
     *
     * @param imageSet a set of Image objects
     */
    private void showItemImage(Set<Image> imageSet) {

        // clear all the item images first
        this.imageBox.getChildren().clear();
        int num = 0;
        for (Image image : imageSet) {
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            GridPane.setRowIndex(imageView, num % 5);
            GridPane.setColumnIndex(imageView, num/ 5);
            num = num + 1;
            GridPane.setMargin(imageView, new Insets(5.0D, 0.0D, 5.0D, 5.0D));
            this.imageBox.getChildren().add(imageView);
        }
    }

    /**
     * Update the item list that is with the player and can be put in the room with desired direction.
     *
     * @param playerItems a set of item names that the player has
     */
    private void updateItemsWithPlayer(Set<String> playerItems) {

        this.putDownMenu.getItems().clear();
        for (String itemName : playerItems) {
            MenuItem item = new MenuItem(itemName);
            this.addMenuItemEvent(item, "Put " + itemName);
            this.putDownMenu.getItems().add(item);
        }
    }

    /**
     * Update the item list that is in the room which can be seen from current direction and can be picked up by the user.
     *
     * @param wallItems a set of item names that are in the room from current direction
     */
    private void updateItemsInWall(Set<String> wallItems) {

        this.pickUpMenu.getItems().clear();
        for (String itemName : wallItems) {
            MenuItem item = new MenuItem(itemName);
            this.addMenuItemEvent(item, "Pickup " + itemName);
            this.pickUpMenu.getItems().add(item);
        }
    }

    /**
     * Update the player names to the menu list.
     *
     * @param playerSet a Set of String that represents the name of the players
     */
    private void updatePlayerList(Set<String> playerSet) {

        this.playerMenu.getItems().clear();
        for (String playerName : playerSet) {
            MenuItem item = new MenuItem(playerName);
            this.addMenuItemEvent(item, "Switch " + playerName);
            this.playerMenu.getItems().add(item);
        }
    }
}
