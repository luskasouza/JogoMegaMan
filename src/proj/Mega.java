package proj;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Constrodor para Imagens do mega; 
public class Mega extends ImageView{
    //Armazena a imagens, posições e tamanho; 
    /**
     * 
     * @param image colocando imagem
     * @param x variavel de metodata
     * @param y variavel de metodata
     * @param sx variavel de metodata
     * @param sy variavel de metodata
     */
    public Mega(Image image,double x, double y, double sx, double sy){
           this.setImage(image);
           this.setX(x);
           this.setY(y);
           this.setScaleX(sx); 
           this.setScaleY(sy);       
                   
    }
    //Metodo de Modança Imagens
    public void muda_imag(Image im){
        this.setImage(im);
    }
    


}

