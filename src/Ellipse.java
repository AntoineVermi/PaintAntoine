import java.awt.*;

public class Ellipse extends Figure {

    public int width;
    public int height;
    public int heightBB=0;
    public int widthBB=0;

    public Ellipse(int px, int py, Color c) {
        super(c, new Point(1, 1));
        setSemiAxisX(px);
        setSemiAxisY(py);
        this.setBoundingBox(px, py);
    }

    public Ellipse(int px, int py, Color c, Point p){
        super(c, p);
        setSemiAxisX(px);
        setSemiAxisY(py);
        this.origin = p;
        this.setBoundingBox(px, py);
        this.color = c;
    }

    public void setBoundingBox (int widthBB, int heightBB){
        this.height = heightBB;
        this.width = widthBB;
    }

    public void setSemiAxisX(int width) {
        this.width = width;
    }

    public void setSemiAxisY(int height) {
        this.height = height;
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(origin.getX(),origin.getY(),Math.abs(width),Math.abs(height));
    }
}