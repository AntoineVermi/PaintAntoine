import java.awt.*;

public class Rectangle extends Figure {
    protected int width;
    protected int height;
    public int heightBB;
    public int widthBB;

    //Sans point d'origine

    public Rectangle(int px, int py, Color c){
        super(c, new Point(1,1));
        setWidth(px);
        setHeight(py);
        this.setBoundingBox(px, py);
        this.color = c;
    }

    //Avec point d'origine

    public Rectangle(int px, int py, Color c, Point p){
        super(c, new Point(1,1));
        setWidth(px);
        setHeight(py);
        this.origin = p;
        this.setBoundingBox(px, py);
        this.color = c;
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB){
        this.heightBB = heightBB;
        this.widthBB = widthBB;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public void draw(Graphics g){
        g.setColor(this.getColor());
        g.fillRect(super.getOrigin().getX(),super.getOrigin().getY(),this.width,this.height);
    }
}
