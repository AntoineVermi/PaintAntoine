import java.awt.*;

/**On construit le carré comme un rectangle dont la largeur et la longueur sont égales**/

public class Square extends Rectangle {

    //Sans point d'origine

    public Square(int px, Color c){
        super(px,px,c);
    }

    //Avec point d'origine

    public Square(int px, Color c, Point point){ // Constructeur du carré avec un point en argument pour son origine
        super(px,px,c,point);
    }

    public void setBoundingBox (int widthBB, int heightBB){
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
