package ippo.assignment2.controller;

import ippo.assignment2.command.Command;
import ippo.assignment2.command.CommandParser;
import ippo.assignment2.proxy.CacheProxy;
import ippo.assignment2.view.JavaFxView;
import ippo.assignment2.view.View;
import ippo.assignment2.world.Model;
import javafx.scene.image.Image;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A app controller for assignment2.
 * This controller complies with the MVC design pattern.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 2.2;
 */
public class AppController implements Controller {

    private Model model;
    private CommandParser parser;
    private CacheProxy service;
    private Set<View> views;

    /**
     * Init the Controller object.
     */
    public AppController() {

        // create a Model object which stores all the data
        this.model = new Model();

        // create a CommandParser object which translates the command string to real command
        this.parser = new CommandParser();

        // create a service object to obtain images
        this.service = new CacheProxy();

        // obtain the ViewController constructed by the GUI library
        this.views = new HashSet<>();
        this.views.add(JavaFxView.factory("MenuView", this));

    }

    /**
     * Start the controller.
     */
    @Override
    public void start() {

        // update data from model object to view interface
        this.updateView();

        for(View view : this.views) {

            // start the view interface
            view.start();
        }
    }

    /**
     * Execute the corresponding command selected at view interface.
     * Update the user interface states.
     *
     * @param commandWord the pre-defined available command word
     */
    @Override
    public void select(String commandWord) {

        // get the corresponding command object
        Command command = this.parser.getCommand(commandWord);

        // execute the command on application data
        command.execute(this.model);

        this.updateView();
    }

    /**
     * Update the views that the user is facing at.
     */
    private void updateView() {

        Image wallImage = this.service.getImage("walls", this.model.getCurrentWallImage());
        boolean canForward = this.model.checkForwardCommand();
        Set itemImageSet = this.getItemContents("items", this.model.getWallImageItemURLs(), Image.class);
        Set<String> playerItems = this.model.getPlayerItems();
        Set<String> wallItems = this.model.getWallItems();
        Set<String> playerSet = this.model.getPlayerSet();

        for(View view : this.views) {

            view.update(wallImage, canForward, itemImageSet, playerItems, wallItems, playerSet);
        }
    }

    /**
     * Get a set of Item contents based on the given URLs.
     *
     * @param type      the type of the item
     * @param contentURLs a Set of imageURLs
     * @param classOfT the class desired
     * @return a set of contents with desired type
     */
    private <T> Set getItemContents(String type, Set<String> contentURLs, Class<T> classOfT) {

        LinkedHashSet<T> contentSet = new LinkedHashSet<>();
        for(String imageURL : contentURLs) {
            // for other content type, add more checks here
            if(classOfT == Image.class) {
                contentSet.add((T)this.service.getImage(type, imageURL));
            }
        }
        return contentSet;
    }
}
