package proj;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Lukas Souza
 */
public class Fase02 extends Scene{
    
    private final ImageView fase002 = new ImageView("Img/ElecLevel.jpg");
    double bosX02 = 430;
    double posX = 30;   
     
    Mega mega = new Mega(new Image("Img/Peson/mega01.png"),posX,238,0.7,0.7);   
    Mega boss02 = new Mega(new Image("Img/boss/boss2.gif"),bosX02,228,1.2,1.4); 
    ImageView tiro = new ImageView("Img/Peson/Buster/oie_X8MJM2HS3qEu.gif");    
    double lafVida = 250;
    Barradevida vida = new Barradevida();
    int direita = 1;  
    int esquerda = 1;    
    TranslateTransition pulo = new TranslateTransition(Duration.millis(500),mega); 
    TranslateTransition movimentoTiro = new TranslateTransition(Duration.millis(500), tiro);
    
    double vidaMega = 150;
    Rectangle retanguloMega = new Rectangle(10, vidaMega);
    // Barra Da Vida Do Boss01
    Rectangle retanguloBoss02 = new Rectangle(10, 150);
    
    int cont  = 100;   //Mega 
    int cont3  = 100; //Boss01
        private Pane root02;
        public Fase02(Pane root,  double height, double width) {
            super(root,height,width);
            this.root02 = root;
            
            
            //Barra de Vida Boss02 Localização na fase02
            retanguloBoss02.setLayoutX(468);
            retanguloBoss02.setLayoutY(20);
            retanguloBoss02.setX(30);
            retanguloBoss02.setY(20);
            retanguloBoss02.setFill(Color.LIMEGREEN);
            
            //Pulo do Mega
            pulo.setByY(-70);
            pulo.setCycleCount((int) 2f);
            pulo.setAutoReverse(true);
            
            // Tiro do mega
            movimentoTiro.setByX(bosX02);//
            movimentoTiro.setCycleCount((int)2f);//Movimento do tiro
            movimentoTiro.setAutoReverse(true);
            tiro.setX(posX);
            tiro.setY(250);
            //Fase02
            fase002.setX(130);
            fase002.setY(48);
        
            //Fase02
            fase002.setScaleX(2);
            fase002.setScaleY(3);
    
            root02.getChildren().addAll(fase002 , boss02, mega, retanguloBoss02, vida);
   }
      /**
     * 
     * @param mega ver dano na barra em Mega
     * @param boss02 ver dano na barra  bOSS02
     */
    private void verDano(ImageView mega, ImageView boss02){
       boolean ver = mega.getBoundsInLocal().intersects(boss02.getBoundsInLocal());
       if( ver == true){
           vidaMega = vidaMega - 30;
           if(vidaMega < 0) vidaMega = 0;
           retanguloMega.setScaleY(vidaMega);
       }
    }//movimentaçao para esquerda com sprats
    /**
     * Animação da esquerda
     */
    public void mover_para_esquerda() {
        //verDano(mega, boss01);
        posX = posX - 10;
        if (posX < 30) {
            posX = 30;
        }
        bosX02  = bosX02 + 10;
        if(bosX02 > 450){
            bosX02 = 450; 
        }
        switch(esquerda){
        case 1: mega.muda_imag(new Image("Img/Peson/mega06.png"));
            break;
        case 2: mega.muda_imag(new Image("Img/Peson/mega05.png"));
            break;
        case 3: mega.muda_imag(new Image("Img/Peson/mega04.png"));
            esquerda = 0;
            break;
    }
        esquerda++;
        //Tiro do Mega 
        movimentoTiro.setByX(bosX02);
        tiro.setX(posX+10);
        mega.setX(posX);
        boss02.setX(bosX02);
    }//movimentaçao para direita com sprats
    
    /**
     * Animação da direita
     */
    public void mover_para_direita(){
        //verDano(mega, boss01);
        posX = posX + 10;
        if (posX > 450) {
            posX = 450;
        }
        bosX02  = bosX02 - 10;
        if(bosX02 < 250){
            bosX02 =250;
        }
        //Controle de sequência para direita
        switch(direita){
        case 1: mega.muda_imag(new Image("Img/Peson/mega02.png"));
            break;
        case 2: mega.muda_imag(new Image("Img/Peson/mega03.png"));
            break;
        case 3: mega.muda_imag(new Image("Img/Peson/mega01.png"));
        
            direita = 0;
            break;
    }
        direita++;
        
        movimentoTiro.setByX(bosX02);
        tiro.setX(posX+10);
        mega.setX(posX);
        boss02.setX(bosX02);
    }
     /**
     * Animação do pulo do Mega
     */
    public void pular(){  
        pulo.play();
    }
     /**
     * Animação para atirar animação 
     */
    public void atirar(){
        root02.getChildren().add(tiro);
        movimentoTiro.play();
        Timeline tempoDeEspera = new Timeline(new KeyFrame(Duration.millis(190), ae -> root02.getChildren().removeAll(tiro))); 
        tempoDeEspera.play();
       
    }
    //Verbarra
    /**
     * Dano em Mega é Boos1 
     */
    public void Dano(){
        boolean status = mega.getBoundsInLocal().intersects(boss02.getBoundsInLocal());
        if(status == true){
            //Movimento da Barra Mega
            lafVida = lafVida - 5;
            vida.setHeight(vida.getHeight()-16);
            //Movimento da Barra  Boss01
            lafVida = lafVida - 5;
            retanguloBoss02.setHeight(vida.getHeight()-16);
        }    
    }
    /**
     * Contar dano em Barra de vida
     */
    public void contVida(){
        boolean status = mega.getBoundsInLocal().intersects(boss02.getBoundsInLocal());
        if(status == true){
            //Posentagem de vidade em Mega
            cont = cont - 1;
            //Posentagem de vidade em Boss01
            cont3 = cont3 - 10; 
        
        }
    } 
}
