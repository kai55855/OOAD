import java.awt.*;
import java.util.Vector;

public class LineObject extends Shape{
    private Port beginPort, endPort;
    public LineObject(Port beginPort, Port endPort){
        super(0, 0, 0, "default");
        this.beginPort = beginPort;
        this.endPort = endPort;
    }

    Port getBeginPort(){
        return this.beginPort;
    }

    Port getEndPort(){
        return this.endPort;
    }

    @Override
    Graphics2D draw(Graphics2D g2) {
        return null;
    }

    @Override
    void move(int x, int y) {

    }

    @Override
    boolean hit(Shape shape, Graphics2D g2) {
        return false;
    }

    @Override
    boolean clicked(int x, int y, Graphics2D g2) {
        return false;
    }

    @Override
    boolean isCovered(int x, int y, int x2, int y2) {
        return false;
    }



    @Override
    Port getPort(int x, int y, Graphics2D g2) {
        return null;
    }

    @Override
    void addGroup(Shape shape) {

    }

    @Override
    boolean unGroup(Vector<Shape> paintedObject) {
        return false;
    }
}
