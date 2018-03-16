/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Lukas Souza
 */
public class parabens extends Scene {
    private final Image gameover = new Image("Img/d.png");
    /**
     * 
     * @param root palco da imagens
     * @param width largura da tela
     * @param height altura da tela
     */
    public parabens(Pane root, double width, double height) {
        super(root, width, height);
       
        ImageView vitoria = new ImageView(gameover);
        vitoria.setScaleX(1);
        vitoria.setScaleY(1);
        
        root.getChildren().addAll(vitoria);
    }
    
}
