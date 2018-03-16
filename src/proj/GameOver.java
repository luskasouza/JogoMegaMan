package proj;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Lukas Souza
 */
 public class GameOver extends Scene{
    private final Image gameOver = new Image("Img/TelaGameOver/over.png");
    /**
     * 
     * @param root  palco da imagens
     * @param height largura da tela 
     * @param width altura da tela
     */
    public GameOver(Pane root,  double height, double width) {
        super(root,height,width);
        ImageView fun = new ImageView(gameOver);
        
        fun.setScaleX(1);
        fun.setScaleY(1);
    
        root.getChildren().addAll(fun);
    }
    
}
