import java.awt.*;
import java.util.Vector;

public class ClassObject extends UmlObject{

    public ClassObject(int x, int y, int depth){
        super(x, y, depth, "default");
        setWidth(40);
        setHeight(60);
        name = new Rectangle(x, y, 40, 20);
        attribute = new Rectangle(x, y + 20, 40, 20);
        method = new Rectangle(x, y + 40, 40, 20);
    }

    @Override
    Graphics2D draw(Graphics2D g2){
        g2.setPaint(Color.black);
        g2.fill(name);
        g2.draw(attribute);
        g2.draw(method);
        g2.setColor(Color.white);
        g2.drawString(objectName, this.getX(), this.getY() + 20);
        return g2;
    }

    @Override
    boolean clicked(int x, int y, Graphics2D g2){
        Rectangle rectangle = new Rectangle(x, y, 1, 1);
        if(g2.hit(rectangle, this.name, false) || g2.hit(rectangle, this.attribute, false) || g2.hit(rectangle, this.method, false))
            return true;
        else
            return false;
    }

    @Override
    void move(int x, int y){
        setX(x);
        setY(y);
        name = new Rectangle(x, y, 40, 20);
        attribute = new Rectangle(x, y + 20, 40, 20);
        method = new Rectangle(x, y + 40, 40, 20);
    }

    @Override
    boolean hit(UmlObject umlObject, Graphics2D g2) {
        Rectangle rectangle = new Rectangle(umlObject.getX(), umlObject.getY(), umlObject.getWidth(), umlObject.getHeight());
        if(g2.hit(rectangle, this.name, false) || g2.hit(rectangle, this.attribute, false) || g2.hit(rectangle, this.method, false))
            return true;
        else
            return false;
    }
}
