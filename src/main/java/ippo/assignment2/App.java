// IPPO Assignment 2, §PUBDATE
package ippo.assignment2;

import ippo.assignment2.controller.AppController;
import ippo.assignment2.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A starting point of the application with JavaFX GUI.
 *
 * @author Yuwen Heng &lt;s1572869@ed.ac.uk&gt;
 * @version 1.0, §PUBDATE
 */

public class App extends Application {

    // JavaFX Stage object
    public static Stage mainStage;

    /**
     * Start the GUI application.
     */
    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }

    /**
     * Start the desired controller.
     */
    public void start(Stage stage) {

        mainStage = stage;

        // controller for the MVC design pattern
        Controller controller = new AppController();
        controller.start();

    }
}
