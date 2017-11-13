import java.awt.*;
import java.awt.geom.Ellipse2D;

public class UseCaseObject extends  UmlObject{

    public UseCaseObject(int x, int y, int depth){
        super(x, y, depth, "default");
        setWidth(80);
        setHeight(40);
        ellipse2D = new Ellipse2D.Double(x, y, 80, 40);

    }

    @Override
    Graphics2D draw(Graphics2D g2){
        g2.setPaint(Color.black);
        g2.fill(ellipse2D);
        g2.setColor(Color.white);
        g2.drawString(objectName, this.getX() + 15, this.getY() + 25);
        return g2;
    }

    @Override
    boolean clicked(int x, int y, Graphics2D g2){
        Rectangle rectangle = new Rectangle(x, y, 1, 1);
        if(g2.hit(rectangle, this.ellipse2D, false))
            return true;
        else
            return false;
    }

    @Override
    void move(int x, int y) {
        setX(x);
        setY(y);
        ellipse2D = new Ellipse2D.Double(x, y, 80, 40);
    }

    @Override
    boolean hit(UmlObject umlObject, Graphics2D g2) {
        Rectangle rectangle = new Rectangle(umlObject.getX(), umlObject.getY(), umlObject.getWidth(), umlObject.getHeight());
        if(g2.hit(rectangle, this.ellipse2D, false))
            return true;
        else
            return false;
    }
}
