import java.awt.*;
import java.awt.geom.Ellipse2D;

public class UseCase extends BasicObject {
    protected Ellipse2D ellipse2D;

    public UseCase(int x, int y, int depth, String objectName) {
        super(x, y, depth, objectName, new Port(x + 34, y - 5), new Port(x - 4, y + 16), new Port(x + 34, y + 38), new Port(x + 76, y + 16));
        setWidth(80);
        setHeight(40);
        ellipse2D = new Ellipse2D.Double(x, y, 80, 40);
    }

    Graphics2D draw(Graphics2D g2) {
        if (getSelected()) {
            g2.setPaint(Color.gray);
            g2 = getPortOne().draw(g2);
            g2 = getPortTwo().draw(g2);
            g2 = getPortThird().draw(g2);
            g2 = getPortFourth().draw(g2);
        }
        g2.setPaint(Color.black);
        g2.fill(ellipse2D);
        g2.setColor(Color.white);
        g2.drawString(getObjectName(), this.getX() + 15, this.getY() + 25);
        return g2;
    }

    boolean hit(Shape shape, Graphics2D g2) {
        Rectangle rectangle = new Rectangle(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        if (g2.hit(rectangle, this.ellipse2D, false))
            return true;
        else
            return false;
    }

    boolean clicked(int x, int y, Graphics2D g2) {
        Rectangle rectangle = new Rectangle(x, y, 1, 1);
        if (g2.hit(rectangle, this.ellipse2D, false))
            return true;
        else
            return false;
    }

    void move(int x, int y) {
        setX(x);
        setY(y);
        ellipse2D = new Ellipse2D.Double(x, y, 80, 40);
        getPortOne().move(getX() + 34, getY() - 5);
        getPortTwo().move(getX() - 4, getY() + 16);
        getPortThird().move(getX() + 34, getY() + 38);
        getPortFourth().move(getX() + 76, getY() + 16);
    }

    Port getPort(int x, int y, Graphics2D g2) {
        Point[] point = new Point[2];
        point[0] = new Point();
        point[1] = new Point();
        int[] pX = {getX(), getX() + 40, getX() + 80};
        int[] pY = {getY(), getY() + 20, getY()};
        int[] p2X = {getX(), getX() + 40, getX()};
        int[] p2Y = {getY(), getY() + 20, getY() + 40};
        int[] p3X = {getX(), getX() + 40, getX() + 80};
        int[] p3Y = {getY() + 40, getY() + 20, getY() + 40};
        int[] p4X = {getX() + 80, getX() + 40, getX() + 80};
        int[] p4Y = {getY() + 40, getY() + 20, getY()};
        Polygon p = new Polygon(pX, pY, 3);
        Polygon p2 = new Polygon(p2X, p2Y, 3);
        Polygon p3 = new Polygon(p3X, p3Y, 3);
        Polygon p4 = new Polygon(p4X, p4Y, 3);
        Rectangle rectangle = new Rectangle(x, y, 1, 1);
        if (g2.hit(rectangle, p, false)) {
            point[0].x = this.getX() + 34;
            point[0].y = this.getY() - 5;
            point[1].x = point[0].x;
            point[1].y = point[0].y - 5;
            setSelectedPortNumber(1);
            return getPortOne();
        } else if (g2.hit(rectangle, p2, false)) {
            point[0].x = this.getX() - 4;
            point[0].y = this.getY() + 16;
            point[1].x = point[0].x - 5;
            point[1].y = point[0].y;
            setSelectedPortNumber(2);
            return getPortTwo();
        } else if (g2.hit(rectangle, p3, false)) {
            point[0].x = this.getX() + 34;
            point[0].y = this.getY() + 43;
            point[1].x = point[0].x;
            point[1].y = point[0].y + 6;
            setSelectedPortNumber(3);
            return getPortThird();
        } else if (g2.hit(rectangle, p4, false)) {
            point[0].x = this.getX() + 81;
            point[0].y = this.getY() + 16;
            point[1].x = point[0].x + 5;
            point[1].y = point[0].y;
            setSelectedPortNumber(4);
            return getPortFourth();
        }
        return null;
    }

}
