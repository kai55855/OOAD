import java.awt.*;

public class Class extends BasicObject {
    private Rectangle name;
    private Rectangle attribute;
    private Rectangle method;
    private Port p1, p2, p3, p4;

    public Class(int x, int y, int depth, String objectName) {
        super(x, y, depth, objectName);
        setWidth(40);
        setHeight(60);
        name = new Rectangle(x, y, 40, 20);
        attribute = new Rectangle(x, y + 20, 40, 20);
        method = new Rectangle(x, y + 40, 40, 20);
        p1 = new Port(getX() + 16, getY() - 5);
        p2 = new Port(getX() - 5, getY() + 27);
        p3 = new Port(getX() + 16, getY() + 58);
        p4 = new Port(getX() + 38, getY() + 27);
    }

    Graphics2D draw(Graphics2D g2) {
        if (getSelected()) {
            g2.setPaint(Color.gray);
            g2 = p1.draw(g2);
            g2 = p2.draw(g2);
            g2 = p3.draw(g2);
            g2 = p4.draw(g2);
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
        name = new Rectangle(x, y, 40, 20);
        attribute = new Rectangle(x, y + 20, 40, 20);
        method = new Rectangle(x, y + 40, 40, 20);
        p1.move(getX() + 16, getY() - 5);
        p2.move(getX() - 5, getY() + 27);
        p3.move(getX() + 16, getY() + 58);
        p4.move(getX() + 38, getY() + 27);
    }
}
