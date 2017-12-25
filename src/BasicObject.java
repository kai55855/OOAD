import java.awt.*;
import java.util.Vector;

public class BasicObject extends Shape {
    private Port[] ports;

    public BasicObject(int x, int y, int depth, String objectName, Port p1, Port p2, Port p3, Port p4) {
        super(x, y, depth, objectName);
        ports = new Port[4];
        ports[0] = p1;
        ports[1] = p2;
        ports[2] = p3;
        ports[3] = p4;
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

    Port getPort(int x, int y, Graphics2D g2){return null;}
    //      1
    //2            4
    //      3
    Port getPortOne(){
        return this.ports[0];
    }

    Port getPortTwo(){
        return this.ports[1];
    }

    Port getPortThird(){
        return this.ports[2];
    }

    Port getPortFourth(){
        return this.ports[3];
    }
    boolean isCovered(int x, int y, int x2, int y2) {
        if ((getX() >= x && getX() <= x2) || (getX() <= x && getX() >= x2)) {
            if ((getY() >= y && getY() <= y2) || (getY() <= y && getY() >= y2)) {
                if ((getX() + getWidth() >= x && getX() + getWidth() <= x2) || (getX() + getWidth() <= x && getX() + getWidth() >= x2)) {
                    if ((getY() + getHeight() >= y && getY() + getHeight() <= y2) || (getY() + getHeight() <= y && getY() + getHeight() >= y2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    void addGroup(Shape shape) {

    }

    @Override
    boolean unGroup(Vector<Shape> paintedObject) {
        return false;
    }
}