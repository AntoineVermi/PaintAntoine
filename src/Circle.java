import java.awt.*;

/**On construit le cercle comme une ellipse avec px = py**/

public class Circle extends Ellipse{

    public int px;

    //Sans point d'origine

    public Circle(int px, Color c){ // Constructeur du carré
        super(px,px,c);
        this.px = px;
    }

    //Avec point d'origine

    public Circle(int px, Color c, Point point){ // Constructeur du carré avec un point d'origine
        super(px,px,c,point);
        this.px = px;
    }

    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }


    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

}
