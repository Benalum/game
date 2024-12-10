package Areas.ImageFinder;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageFinder {
    static final Image grass = new Image("Texture/Ground/Grass/grass.jpg");
    static final Image rock = new Image("Texture/Ground/Rock/rock.png");


    public static ImageView findImage(String phrase){
        // Check size of phrase first start with size 1
        if (phrase.length() == 1) {
            if(phrase.charAt(0) == 'g'){
                return new ImageView(grass);
            } else if (phrase.charAt(0) == 'r') {
                return new ImageView(rock);
            }
        }
        return null;
    }
}
