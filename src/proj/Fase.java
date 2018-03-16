package proj;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Lukas Souza
 */
//

public class Fase extends Scene {
    ImageView tela01 = new ImageView("Img/ElecLevel.jpg");  
    double posX = 30;   
    double bosX = 430;  
    Mega mega = new Mega(new Image("Img/Peson/mega01.png"),posX,238,0.7,0.7);   
    Mega boss01 = new Mega(new Image("Img/boss/boss01.png"),bosX,250,1.2,1.4); 
    ImageView tiro = new ImageView("Img/Peson/Buster/oie_X8MJM2HS3qEu.gif");    
     
    double lafVida = 250;
    Barradevida vida = new Barradevida();
    int direita = 1;  
    int esquerda = 1;    
    TranslateTransition pulo = new TranslateTransition(Duration.millis(500),mega); 
    TranslateTransition movimentoTiro = new TranslateTransition(Duration.millis(500), tiro);
    // Barra de Vida Do Mega
    double vidaMega = 150;
    Rectangle retanguloMega = new Rectangle(10, vidaMega);
    // Barra Da Vida Do Boss01
    Rectangle retanguloBoss01 = new Rectangle(10, 150);
    
    int cont = 100;   //Mega 
    int cont02 = 100; //Boss01
    
    private Pane root;
    /**
     * 
     * @param root palco da fase
     * @param width largura da tela da fase
     * @param height  altura da tela da fase
     */
    public Fase(Pane root, double width, double height) {
        super(root, width, height);
        this.root = root;
       
        //Barra de Vida Boss01 Localização na fase
        retanguloBoss01.setLayoutX(468);
        retanguloBoss01.setLayoutY(20);
        retanguloBoss01.setX(30);
        retanguloBoss01.setY(20);
        retanguloBoss01.setFill(Color.LIMEGREEN);//Cor da Barra de Vida
        
        //Pulo do Mega
        pulo.setByY(-70);
        pulo.setCycleCount((int) 2f);
        pulo.setAutoReverse(true);
     
        // Tiro do mega
        movimentoTiro.setByX(bosX);//
        movimentoTiro.setCycleCount((int)2f);//Movimento do tiro
        movimentoTiro.setAutoReverse(true);
        tiro.setX(posX);
        tiro.setY(250);
        
        //Tela01
        tela01.setX(130);
        tela01.setY(51);
        
        //Escala da imag
        tela01.setScaleX(2);
        tela01.setScaleY(3);
        root.getChildren().addAll(tela01, boss01, mega,retanguloBoss01,vida);

    }
    /**
     * 
     * @param mega ver dano na barra em Mega
     * @param boss01 ver dano na barra  bOSS01
     */
    private void verDano(ImageView mega, ImageView boss01){
       boolean ver = mega.getBoundsInLocal().intersects(boss01.getBoundsInLocal());
       if( ver == true){
           vidaMega = vidaMega - 30;
           if(vidaMega < 0) vidaMega = 0;
           retanguloMega.setScaleY(vidaMega);
       }
    }
    //movimentaçao para esquerda com sprats
    /**
     * Animação da esquerda
     */
    public void mover_para_esquerda() {
        //verDano(mega, boss01);
        posX = posX - 10;
        if (posX < 30) {
            posX = 30;
        }
        bosX  = bosX + 10;
        if(bosX > 450){
            bosX = 450; 
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
        movimentoTiro.setByX(bosX);
        tiro.setX(posX+10);
        mega.setX(posX);
        boss01.setX(bosX);
    }
    //movimentaçao para direita com sprats
    /**
     * Animação da direita
     */
    public void mover_para_direita(){
        //verDano(mega, boss01);
        posX = posX + 10;
        if (posX > 450) {
            posX = 450;
        }
        bosX  = bosX - 10;
        if(bosX < 250){
            bosX =250;
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
        
        movimentoTiro.setByX(bosX);
        tiro.setX(posX+10);
        mega.setX(posX);
        boss01.setX(bosX);
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
        root.getChildren().add(tiro);
        movimentoTiro.play();
        Timeline tempoDeEspera = new Timeline(new KeyFrame(Duration.millis(190), ae -> root.getChildren().removeAll(tiro))); 
        tempoDeEspera.play();
       
    }
    //Verbarra
    /**
     * Dano em Mega é Boos1 
     */
    public void Dano(){
        boolean status = mega.getBoundsInLocal().intersects(boss01.getBoundsInLocal());
        if(status == true){
            //Movimento da Barra Mega
            lafVida = lafVida - 5;
            vida.setHeight(vida.getHeight()-16);
            //Movimento da Barra  Boss01
            lafVida = lafVida - 5;
            retanguloBoss01.setHeight(vida.getHeight()-16);
        }    
    }/**
     * Contar dano em Barra de vida
     */
    public void contVida(){
        boolean status = mega.getBoundsInLocal().intersects(boss01.getBoundsInLocal());
        if(status == true){
            //Posentagem de vidade em Mega
            cont = cont - 1;
            //Posentagem de vidade em Boss01
            cont02 = cont02 - 10; 
        
        }
    } 
}
