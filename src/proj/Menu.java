package proj;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

/**
 *
 * @author Lukas Souza
 */
//Constrodor do menu
public class Menu extends Scene{ 
    private Button btnJogar = new Button("Jogar");
    ImageView imgMenu = new ImageView("Img/1_mega_man_x.jpg");  
    Font fonts = Font.loadFont(Menu.class.getResource("/fonts/28 Days Later.ttf").toString(),17); 
    public Menu(Pane root, double width, double height) {
        super(root, width, height);

        btnJogar.setLayoutX(230);
        btnJogar.setLayoutY(220);
        btnJogar.setPrefSize(100,30);
        btnJogar.setFont(fonts); 
       
        root.getChildren().addAll(imgMenu,btnJogar);
        
    }
    //Constrodor de tocar audio na inicialização da menu
    /**
     * 
     * @param play iniciar pulo
     */
    public  void tocar_musica(AudioClip play){
        play.play();
   }
    //Constrodor de parar audio no menu
    /**
     * 
     * @param stop para pulo 
     */
    public void para_musica(AudioClip stop){
        stop.stop();
    }
    
}
