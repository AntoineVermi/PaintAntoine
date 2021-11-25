import java.io.Serializable;

public class Point implements Serializable {

    private int X;
    private int Y;


    public int getX() {
        return X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public Point() {
        this.X = 0;
        this.Y = 0;
    }

    public Point (int a, int b){
        this.X=a;
        this.Y=b;
    }

    @Override
    public String toString() {
        return "("+X+","+Y+")";
    }
}
