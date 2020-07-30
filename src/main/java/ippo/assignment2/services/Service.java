package ippo.assignment2.services;


import javafx.scene.image.Image;

public interface Service {
    String serviceName();
    Image getImage(String type, String imageURL);
}
