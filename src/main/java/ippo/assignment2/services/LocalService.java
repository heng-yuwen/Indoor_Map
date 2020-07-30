package ippo.assignment2.services;

import javafx.scene.image.Image;

import java.util.Objects;

/**
 * A LocalService class to get the corresponding Image object based on image url.
 */
public class LocalService implements Service {

    private static String serviceName = "LocalService";

    /**
     * Get the service name.
     * @return a String represents the service name
     */
    @Override
    public String serviceName() {

        return serviceName;
    }

    /**
     * Get the Image object based on type and url given.
     * @param type the type describes whether it is a wall image or an item image
     * @param imageURL the url of the image
     * @return an Image object
     */
    @Override
    public Image getImage(String type, String imageURL) {

        return new Image(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(type + "/" + imageURL)));
    }

}
