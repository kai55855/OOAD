import java.awt.*;
import java.awt.geom.Ellipse2D;

public class UseCaseObject {
    private int depth, x, y;
    private String objectName;
    Ellipse2D ellipse2D;

    public UseCaseObject(int x, int y, int depth){
        ellipse2D = new Ellipse2D.Double(x, y, 80, 40);
        setDepth(depth);
        setX(x);
        setY(y);
        setObjectName("default");
    }

    void setDepth(int depth){
        this.depth = depth;
    }

    int getDepth(){
        return this.depth;
    }

    void setX(int x){
        this.x = x;
    }

    int getX(){
        return this.x;
//        return (int)ellipse2D.getX();
    }

    void setY(int y){
        this.y = y;
    }

    int getY(){
        return this.y;
//        return (int)ellipse2D.getY();
    }

    void setObjectName(String objectName){
        this.objectName = objectName;
    }

    Graphics2D draw(Graphics2D g2){
        g2.setPaint(Color.black);
        g2.fill(ellipse2D);
        g2.setColor(Color.white);
        g2.drawString(objectName, this.getX() + 15, this.getY() + 25);
        return g2;
    }
}
