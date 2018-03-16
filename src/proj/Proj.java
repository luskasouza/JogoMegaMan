/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
//Construtor de projeto
public class Proj extends Application {
    //Chamando audio
    AudioClip audioMenu = new AudioClip(getClass().getResource("/sound/Mega Man 3 Rock.mp3").toString());
    AudioClip audio_nivel = new AudioClip(getClass().getResource("/sound/Megaman X3 - Toxic Seahorse Stage.mp3").toString());
    AudioClip audioGameOver = new AudioClip(getClass().getResource("/sound/GameOver.mp3").toString());
    AudioClip audioParabens = new AudioClip(getClass().getResource("/sound/Som.mp3").toString());
    AudioClip audio_nive2 = new AudioClip(getClass().getResource("/sound/som02.mp3").toString());
    @Override
    /**
     * Controlador de menu é fases 
     */
    public void start(Stage primaryStage){
        // Tamanho do Menu 
        Pane root = new Pane();
        Menu menu = new Menu(root, 510 , 339);
        primaryStage.setScene(menu);
        menu.tocar_musica(audioMenu);
        
        //Objet Fase 01
        Pane rootFase = new Pane();
        Fase fase = new Fase(rootFase, 510, 339);

        //GameOver
        Pane rootover = new Pane();
        GameOver gover = new GameOver(rootover, 510, 339);

        //Objeto Vencedor
        Pane rootG = new Pane();
        parabens Parabens = new parabens(rootG, 510, 339);
        
        //Objeto 2° Fase
        Pane rootFase02 = new Pane();
        Fase02 fase2 = new Fase02(rootFase02, 510, 339);
        
        //Pegar um evento do menu
        menu.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // Configurar o evento  da tecla enter 
                if(event.getCode().equals(KeyCode.ENTER)) primaryStage.setScene(fase);menu.para_musica(audioMenu);
                    audio_nivel.play();
                
            }
        });
        //Evento do teclado na Fase do Mega  
        fase.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            /**
             * Evento do teclado
             */
            public void handle(KeyEvent event) {
                fase.Dano();
                fase.contVida();
                if(fase.cont == 0){
                    primaryStage.setScene(gover); audio_nivel.stop(); 
                        audioGameOver.play();
                    }if(fase.cont02 <= 0 ){                      
                        primaryStage.setScene(Parabens); audio_nivel.stop(); 
                            audio_nive2.play();
                            primaryStage.setScene(fase2);
                            audioParabens.play();
                        }
                if(event.getCode().equals(KeyCode.LEFT))
                    fase.mover_para_esquerda();
                if(event.getCode().equals(KeyCode.RIGHT))
                    fase.mover_para_direita();
                if(event.getCode().equals(KeyCode.UP))
                    fase.pular();
                if(event.getCode().equals(KeyCode.X))
                    fase.atirar();               
            
            }
        });
        gover.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
               if(event.getCode().equals(KeyCode.ESCAPE))
                    primaryStage.setScene(menu);
            }
            
        });
         fase2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            /**
             * Evento do teclado
             */
            public void handle(KeyEvent event) {
                fase2.Dano();
                fase2.contVida();
                if(fase2.cont == 0){
                    primaryStage.setScene(gover); audio_nivel.stop(); 
                        audioGameOver.play();
                    }if(fase2.cont3 <= 0 ){                 
                            primaryStage.setScene(fase2);
                            audio_nive2.stop();
                            primaryStage.setScene(Parabens);audioParabens.play();
                            
                            audioParabens.play(); 
                            
                        }
                    //Evento do teclado
                if(event.getCode().equals(KeyCode.LEFT))
                    fase2.mover_para_esquerda();
                if(event.getCode().equals(KeyCode.RIGHT))
                    fase2.mover_para_direita();
                if(event.getCode().equals(KeyCode.UP))
                    fase2.pular();
                if(event.getCode().equals(KeyCode.X))
                    fase2.atirar();
            }
        });
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
