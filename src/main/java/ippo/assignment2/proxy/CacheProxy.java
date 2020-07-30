package ippo.assignment2.proxy;

import ippo.assignment2.services.LocalService;
import ippo.assignment2.services.Service;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A fulfilled cache proxy service for the PictureViewer application.
 * This class is edited from original author Paul Anderson &lt;dcspaul@ed.ac.uk&gt;, for IPPO assignment 1, task 5.1.
 *
 * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
 * @version 1.3
 */
public class CacheProxy implements Service {

    /**
     * A composite key inner class that support multi-variable HashMap key for the PictureViewer application.
     * Acknowledgement: Tudor's answer at https://stackoverflow.com/questions/11700659/java-composite-key-in-hashmaps/18023900
     *
     * @author s1572869 Yuwen Heng &lt;s1572869@sms.ed.ac.uk&gt;
     * @version 1.0;
     */
    private static class CompositeKey {

        private final String type;
        private final String imageURL;

        /**
         * Create a composite key object based on the type and url of the image.
         *
         * @param type     the type of the image
         * @param imageURL the url of the image
         */
        public CompositeKey(String type, String imageURL) {

            this.type = type;
            this.imageURL = imageURL;

        }

        /**
         * Overrided method to check whether two composite key objects have the same key value or not.
         *
         * @param obj the second composite key object to check key value with.
         */
        @Override
        public boolean equals(Object obj) {

            // two keys is equal when their names and indexes of the picture are the same
            if (this == obj) {
                return true;
            }
            if (obj instanceof CompositeKey) {
                CompositeKey s = (CompositeKey) obj;
                return this.type.equals(s.type) && (this.imageURL == s.imageURL);
            } else {
                return false;
            }
        }

        /**
         * Overrided method to generate unique hashcode.
         *
         * @return the hash value of the key.
         */
        @Override
        public int hashCode() {

            // Add the index value to the name string hashcode
            // this can ensure unique hashcode
            return this.type.hashCode() + this.imageURL.hashCode();

            // encoder the length of the string.
        }
    }

    private Service baseService;

    // a HashMap to store the <composite key, picture> pair
    private HashMap<CompositeKey, Image> keyToPicture;

    /**
     * Create a proxy service based on the service specified in the
     * <code>proxy.cache.service</code> resource.
     */
    public CacheProxy() {

        this.baseService = new LocalService();
        this.keyToPicture = new HashMap<>();
    }

    /**
     * Return a textual name for the service.
     *
     * @return the name of the base service
     */
    public String serviceName() {

        return this.baseService.serviceName();
    }

    /**
     * Return an item image from the base service.
     * Cache the image to reduce remote access time.
     *
     * @param imageURL the name of the item image
     * @return the requested image
     */
    @Override
    public Image getImage(String type, String imageURL) {
        CompositeKey key = new CompositeKey(type, imageURL);
        if (!this.keyToPicture.containsKey(key)) {
            this.keyToPicture.put(key, this.baseService.getImage(type, imageURL));
        }

        return this.keyToPicture.get(key);
    }
}
