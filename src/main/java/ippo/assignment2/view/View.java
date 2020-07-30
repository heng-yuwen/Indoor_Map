package ippo.assignment2.view;

import ippo.assignment2.controller.Controller;
import javafx.scene.image.Image;

import java.util.Set;

public interface View {

    void start();

    void setController(Controller controller);

    void update(Image wallImage, boolean canForward, Set<Image> itemImageSet, Set<String> playerItems, Set<String> wallItems, Set<String> playerSet);
}
