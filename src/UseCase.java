import java.awt.*;
import java.awt.geom.Ellipse2D;

public class UseCase extends BasicObject {
    protected Ellipse2D ellipse2D;
    private Port p1, p2, p3, p4;

    public UseCase(int x, int y, int depth, String objectName){
        super(x, y, depth, objectName);
        setWidth(80);
        setHeight(40);
        ellipse2D = new Ellipse2D.Double(x, y, 80, 40);
        p1 = new Port(getX() + 34, getY() - 5);
        p2 = new Port(getX() - 4, getY() + 16);
        p3 = new Port(getX() + 34, getY() + 38);
        p4 = new Port(getX() + 76, getY() + 16);
    }

    Graphics2D draw(Graphics2D g2){
        if(getSelected()){
            g2.setPaint(Color.gray);
            g2 = p1.draw(g2);
            g2 = p2.draw(g2);
            g2 = p3.draw(g2);
            g2 = p4.draw(g2);
        }
        g2.setPaint(Color.black);
        g2.fill(ellipse2D);
        g2.setColor(Color.white);
        g2.drawString(getObjectName(), this.getX() + 15, this.getY() + 25);
        return g2;
    }

    boolean hit(Shape shape, Graphics2D g2) {
        Rectangle rectangle = new Rectangle(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        if(g2.hit(rectangle, this.ellipse2D, false))
            return true;
        else
            return false;
    }

    boolean clicked(int x, int y, Graphics2D g2){
        Rectangle rectangle = new Rectangle(x, y, 1, 1);
        if(g2.hit(rectangle, this.ellipse2D, false))
            return true;
        else
            return false;
    }

    void move(int x, int y) {
        setX(x);
        setY(y);
        ellipse2D = new Ellipse2D.Double(x, y, 80, 40);
        p1.move(getX() + 34, getY() - 5);
        p2.move(getX() - 4, getY() + 16);
        p3.move(getX() + 34, getY() + 38);
        p4.move(getX() + 76, getY() + 16);
    }

}
