import java.awt.*;

public class Class extends BasicObject {
    private Rectangle name;
    private Rectangle attribute;
    private Rectangle method;


    public Class(int x, int y, int depth, String objectName) {
        super(x, y, depth, objectName, new Port(x + 16, y - 5), new Port(x - 5, y + 27), new Port(x + 16, y + 58), new Port(x + 38, y + 27));
        setWidth(40);
        setHeight(60);
        name = new Rectangle(x, y, 40, 20);
        attribute = new Rectangle(x, y + 20, 40, 20);
        method = new Rectangle(x, y + 40, 40, 20);
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
        g2.fill(name);
        g2.draw(attribute);
        g2.draw(method);
        g2.setColor(Color.white);
        g2.drawString(getObjectName(), this.getX(), this.getY() + 20);
        return g2;
    }

    boolean hit(Shape shape, Graphics2D g2) {
        Rectangle rectangle = new Rectangle(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        if (g2.hit(rectangle, this.name, false) || g2.hit(rectangle, this.attribute, false) || g2.hit(rectangle, this.method, false))
            return true;
        else
            return false;
    }

    boolean clicked(int x, int y, Graphics2D g2) {
        Rectangle rectangle = new Rectangle(x, y, 1, 1);
        if (g2.hit(rectangle, this.name, false) || g2.hit(rectangle, this.attribute, false) || g2.hit(rectangle, this.method, false))
            return true;
        else
            return false;
    }

    void move(int x, int y) {
        setX(x);
        setY(y);
        name = new Rectangle(getX(), getY(), 40, 20);
        attribute = new Rectangle(getX(), getY() + 20, 40, 20);
        method = new Rectangle(getX(), getY() + 40, 40, 20);
        getPortOne().move(getX() + 16, getY() - 5);
        getPortTwo().move(getX() - 5, getY() + 27);
        getPortThird().move(getX() + 16, getY() + 58);
        getPortFourth().move(getX() + 38, getY() + 27);
    }

    Port getPort(int x, int y, Graphics2D g2) {
        Point[] point = new Point[2];
        point[0] = new Point();
        point[1] = new Point();
        int[] pX = {getX(), getX() + 40, getX() + 20};
        int[] pY = {getY(), getY(), getY() + 30};
        int[] p2X = {getX(), getX(), getX() + 20};
        int[] p2Y = {getY(), getY() + 60, getY() + 30};
        int[] p3X = {getX(), getX() + 20, getX() + 40};
        int[] p3Y = {getY() + 60, getY() + 30, getY() + 60};
        int[] p4X = {getX() + 40, getX() + 20, getX() + 40};
        int[] p4Y = {getY() + 60, getY() + 30, getY()};
        Polygon p = new Polygon(pX, pY, 3);
        Polygon p2 = new Polygon(p2X, p2Y, 3);
        Polygon p3 = new Polygon(p3X, p3Y, 3);
        Polygon p4 = new Polygon(p4X, p4Y, 3);
        Rectangle rectangle = new Rectangle(x, y, 1, 1);
        if (g2.hit(rectangle, p, false)) {
            point[0].x = this.getX() + 16;
            point[0].y = this.getY() - 5;
            point[1].x = point[0].x;
            point[1].y = point[0].y - 10;
//            System.out.printf("in x = %d, y = %d\n", point[1].x, point[1].y);
            setSelectedPortNumber(1);
            return getPortOne();
        } else if (g2.hit(rectangle, p2, false)) {
            point[0].x = this.getX() - 5;
            point[0].y = this.getY() + 27;
            point[1].x = point[0].x - 10;
            point[1].y = point[0].y;
//            System.out.printf("in x = %d, y = %d\n", point[1].x, point[1].y);
            setSelectedPortNumber(2);
            return getPortTwo();
        } else if (g2.hit(rectangle, p3, false)) {
            point[0].x = this.getX() + 16;
            point[0].y = this.getY() + 63;
            point[1].x = point[0].x;
            point[1].y = point[0].y + 10;
//            System.out.printf("in x = %d, y = %d\n", point[1].x, point[1].y);
            setSelectedPortNumber(3);
            return getPortThird();
        } else if (g2.hit(rectangle, p4, false)) {
            point[0].x = this.getX() + 43;
            point[0].y = this.getY() + 27;
            point[1].x = point[0].x + 10;
            point[1].y = point[0].y;
//            System.out.printf("in x = %d, y = %d\n", point[1].x, point[1].y);
            setSelectedPortNumber(4);
            return getPortFourth();
        }
        return null;

    }
}
