import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable{
    protected Color color;
    protected Point origin;
    public abstract void setBoundingBox (int heightBB, int widthBB);
    public abstract void draw (Graphics g);
    public Color getColor(){
        return color;
    }

    public Point getOrigin(){
        return origin;
    }
    public String toString(){
        return "("+color+origin.toString()+")";
    }
    public Figure(Color c, Point p){
        this.color=c;
        this.origin=p;
    }
}
