package ippo.assignment2.view;

import ippo.assignment2.App;
import ippo.assignment2.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An abstract class to initialise JavaFX views.
 * This class ensure all views comply with the MVC design pattern.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public abstract class JavaFxView implements View {

    // the controller of the application
    protected Controller controller;

    /**
     * set the controller object
     */
    public void setController(Controller controller) {

        this.controller = controller;
    }

    /**
     * Load the interface from FXML file.
     *
     * @param viewName   the name of the JavaFX view file.
     * @param controller controller of the application
     * @return the view object constructed by JavaFX library
     */
    public static View factory(String viewName, Controller controller) {

        try {
            String viewerFxml = "view/" + viewName + ".fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource(viewerFxml));
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(page);
            View view = (View) fxmlLoader.getController();
            view.setController(controller);
            App.mainStage.setScene(scene);
            return view;
        } catch (IOException ex) {
            Logger.getLogger(JavaFxView.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        return null;
    }

    /**
     * Add command word string to a given Button object's OnAction event and delegate the event to fire the controller's select method.
     *
     * @param button      the Button object that we want to add command word to.
     * @param commandWord the command word string attached to the button.
     */
    protected void addButtonEvent(Button button, String commandWord) {

        button.setOnAction(event -> {

            if (JavaFxView.this.controller != null) {
                JavaFxView.this.controller.select(commandWord);
            }
        });
    }

    /**
     * Add command word string to a given MenuItem object's OnAction event and delegate the event to fire the controller's select method.
     *
     * @param menuItem    the MenuItem object that we want to add command word to.
     * @param commandWord the command word string attached to the button.
     */
    protected void addMenuItemEvent(MenuItem menuItem, String commandWord) {

        menuItem.setOnAction(event -> {
            if (JavaFxView.this.controller != null) {
                JavaFxView.this.controller.select(commandWord);
            }
        });
    }

    /**
     * Start the view.
     */
    public void start() {

        App.mainStage.show();
    }

}
