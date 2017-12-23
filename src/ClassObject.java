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
            Rectangle r2 = new Rectangle(this.getX() - 5, this.getY() + 27, 8, 8);
            Rectangle r3 = new Rectangle(this.getX() + 16, this.getY() + 58, 8, 8);
            Rectangle r4 = new Rectangle(this.getX() + 38, this.getY() + 27, 8, 8);
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
        for(int i = 0;i < group.size();i++){
            g2 = ((UmlObject)group.get(i)).draw(g2);
        }
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

    @Override
    Point[] linePoint(int x, int y, Graphics2D g2) {
        Point [] point = new Point[2];
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
        if(g2.hit(rectangle, p, false)){
            point[0].x = this.getX() + 16;
            point[0].y = this.getY() - 5;
            point[1].x = point[0].x;
            point[1].y = point[0].y - 10;
//            System.out.printf("in x = %d, y = %d\n", point[1].x, point[1].y);
            return point;
        }
        else if(g2.hit(rectangle, p2, false)){
            point[0].x = this.getX() - 5;
            point[0].y = this.getY() + 27;
            point[1].x = point[0].x - 10;
            point[1].y = point[0].y ;
//            System.out.printf("in x = %d, y = %d\n", point[1].x, point[1].y);

            return point;
        }
        else if(g2.hit(rectangle, p3, false)){
            point[0].x = this.getX() + 16;
            point[0].y = this.getY() + 63;
            point[1].x = point[0].x;
            point[1].y = point[0].y + 10;
//            System.out.printf("in x = %d, y = %d\n", point[1].x, point[1].y);

            return point;
        }
        else if(g2.hit(rectangle, p4, false)){
            point[0].x = this.getX() + 43;
            point[0].y = this.getY() + 27;
            point[1].x = point[0].x + 10;
            point[1].y = point[0].y ;
//            System.out.printf("in x = %d, y = %d\n", point[1].x, point[1].y);

            return point;
        }
        return null;
    }
}
