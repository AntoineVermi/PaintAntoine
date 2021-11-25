import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class Drawing extends JPanel implements MouseInputListener {

    public int widthMD,heightMD;
    public Color color;
    public String nextFigure;
    public Point origin, end, origin2;
    public ArrayList<Figure> listOfFigure = new ArrayList<Figure>();
    public ArrayList<Figure> listDragged = new ArrayList<Figure>();

    public Drawing(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public ArrayList<Figure> getListOfFigure() {
        return listOfFigure;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setNextFigure(String nextFigure) {
        this.nextFigure = nextFigure;
    }

    public String getNextFigure() {
        return nextFigure;
    }

    public Point getOrigin() {
        return origin;
    }

    public Point getEnd() {
        return end;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listOfFigure.size(); i++) {
            listOfFigure.get(i).draw(g);
        }
    }

    public void paintComponentDragged(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listDragged.size(); i++) {
            listDragged.get(listDragged.size()-1).draw(g);
            listOfFigure.get(i).draw(g);
        }
    }

    // Reset pour l'option Nouveau dans le menu
    public void resetDrawing(){
        this.listOfFigure.clear();
        paintComponent(this.getGraphics());
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    // Clic de la souris
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        origin = new Point(e.getX(),e.getY()); // Point d'origine
    }

    // Relachement de la souris
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

        end = new Point(e.getX(),e.getY()); // Point d'arrivée

        int width = end.getX()-origin.getX();
        int height = end.getY()-origin.getY();

        // Sens d'affichage selon l'abscisse et l'ordonnée du point d'arrivée
        if ((end.getX()<origin.getX()) && (end.getY()>origin.getY())){origin = new Point(end.getX(),origin.getY());}
        if ((end.getX()<origin.getX()) && (end.getY()<origin.getY())){origin = end;}
        if ((end.getX()>origin.getX()) && (end.getY()<origin.getY())){origin = new Point(origin.getX(),end.getY());}

        // Création de la prochaine figure avec une forme et une couleur
        if ((color != null) && (nextFigure != null) && (width != 0)){
            if (nextFigure == "Rectangle"){
                Rectangle rectangle = new Rectangle(Math.abs(width),Math.abs(height),color,origin);
                listOfFigure.add(rectangle);
            }

            if (nextFigure == "Carre"){
                Square carre = new Square(Math.abs(width),color,origin);
                listOfFigure.add(carre);
            }

            if (nextFigure == "Ellipse"){
                Ellipse ellipse = new Ellipse(Math.abs(width),Math.abs(height),color,origin);
                listOfFigure.add(ellipse);
            }

            if (nextFigure == "Cercle"){
                Circle cercle = new Circle(Math.abs(width),color,origin);
                listOfFigure.add(cercle);
            }
            paintComponent(this.getGraphics());
            System.out.println(listOfFigure);
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    // Déplacement de la souris
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

        this.widthMD = origin.getX()-e.getX(); // Largeur temporaire au suivi de la souris
        this.heightMD = origin.getY()-e.getY(); // Hauteur temporaire au suivi de la souris

        // Sens d'affichage
        if ((e.getX()<origin.getX()) && (e.getY()<origin.getY())){origin2 = new Point(e.getX(),e.getY());}
        if ((e.getX()>origin.getX()) && (e.getY()>origin.getY())){origin2 = new Point(origin.getX(),origin.getY());}
        if ((e.getX()<origin.getX()) && (e.getY()>origin.getY())){origin2 = new Point(e.getX(),origin.getY());}
        if ((e.getX()>origin.getX()) && (e.getY()<origin.getY())){origin2 = new Point(origin.getX(),e.getY());}

        if ((color != null) && (nextFigure != null)){
            if (nextFigure == "Rectangle"){
                Rectangle rectangle = new Rectangle(Math.abs(widthMD),Math.abs(heightMD),color,origin2);
                listDragged.add(rectangle);
            }

            if (nextFigure == "Carre"){
                Square carre = new Square(Math.abs(widthMD),color,origin2);
                listDragged.add(carre);
            }

            if (nextFigure == "Ellipse"){
                Ellipse ellipse = new Ellipse(Math.abs(widthMD),Math.abs(heightMD),color,origin2);
                listDragged.add(ellipse);
            }

            if (nextFigure == "Cercle"){
                Circle cercle = new Circle(Math.abs(widthMD),color,origin2);
                listDragged.add(cercle);
            }
        }
        paintComponentDragged(this.getGraphics());
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
