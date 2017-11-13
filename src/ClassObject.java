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
        if(getSelected()){
            Rectangle r1 = new Rectangle(this.getX() + 16, this.getY() - 5, 8, 8);
            Rectangle r2 = new Rectangle(this.getX() + 16, this.getY() + 58, 8, 8);
            Rectangle r3 = new Rectangle(this.getX() + 38, this.getY() + 27, 8, 8);
            Rectangle r4 = new Rectangle(this.getX() - 5, this.getY() + 27, 8, 8);
            g2.setPaint(Color.gray);
            g2.fill(r1);
            g2.fill(r2);
            g2.fill(r3);
            g2.fill(r4);
        }
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
