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
        if(getSelected()){
//            System.out.printf("usecase selected\n");
            Rectangle r1 = new Rectangle(this.getX() + 34, this.getY() - 5, 8, 8);
            Rectangle r2 = new Rectangle(this.getX() - 4, this.getY() + 16, 8, 8);
            Rectangle r3 = new Rectangle(this.getX() + 34, this.getY() + 38, 8, 8);
            Rectangle r4 = new Rectangle(this.getX() + 76, this.getY() + 16, 8, 8);
            g2.setPaint(Color.gray);
            g2.fill(r1);
            g2.fill(r2);
            g2.fill(r3);
            g2.fill(r4);
        }
        g2.setPaint(Color.black);
        g2.fill(ellipse2D);
        g2.setColor(Color.white);
        g2.drawString(objectName, this.getX() + 15, this.getY() + 25);
        System.out.printf("group = %d\n", group.size());
        for(int i = 0;i < group.size();i++){
            g2 = ((UmlObject)group.get(i)).draw(g2);
        }
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

    @Override
    Point[] linePoint(int x, int y, Graphics2D g2) {
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
        if(g2.hit(rectangle, p, false)){
            point[0].x = this.getX() + 34;
            point[0].y = this.getY() - 5;
            point[1].x = point[0].x;
            point[1].y = point[0].y - 5;
            return point;
        }
        else if(g2.hit(rectangle, p2, false)){
            point[0].x = this.getX() - 4;
            point[0].y = this.getY() + 16;
            point[1].x = point[0].x - 5;
            point[1].y = point[0].y ;
            return point;
        }
        else if(g2.hit(rectangle, p3, false)){
            point[0].x = this.getX() + 34;
            point[0].y = this.getY() + 43;
            point[1].x = point[0].x;
            point[1].y = point[0].y + 6;
            return point;
        }
        else if(g2.hit(rectangle, p4, false)){
            point[0].x = this.getX() + 81;
            point[0].y = this.getY() + 16;
            point[1].x = point[0].x + 5;
            point[1].y = point[0].y ;
            return point;
        }
        return null;
    }
}
