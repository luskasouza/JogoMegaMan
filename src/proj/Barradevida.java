package proj;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Lukas Souza
 */
public class Barradevida extends Rectangle{
    /**
     * configuração da barra de vida
     */
    public Barradevida(){
    this.setX(30);
    this.setY(30);
    this.setWidth(10);
    this.setHeight(150);
    this.setFill(Color.LIMEGREEN);
    
    }
   
}
