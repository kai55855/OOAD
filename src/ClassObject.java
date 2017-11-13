import java.awt.*;

public class ClassObject {
    private int depth, x, y;
    private String objectName;
    Rectangle name;
    Rectangle attribute;
    Rectangle method;

    public ClassObject(int x, int y, int depth){
        name = new Rectangle(x, y, 40, 20);
        attribute = new Rectangle(x, y + 20, 40, 20);
        method = new Rectangle(x, y + 40, 40, 20);
        setDepth(depth);
        setObjectName("default");
        setX(x);
        setY(y);
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
        //return (int)name.getX();
    }

    void setY(int y){
        this.y = y;
    }

    int getY(){
        return this.y;
        //return (int)name.getY();
    }

    void setObjectName(String objectName){
        this.objectName = objectName;
    }

    String getObjectName(){
        return this.objectName;
    }

    Graphics2D draw(Graphics2D g2){
        g2.setPaint(Color.black);
        g2.fill(name);
        g2.draw(attribute);
        g2.draw(method);
        g2.setColor(Color.white);
        g2.drawString(objectName, this.getX(), this.getY() + 20);
        return g2;
    }
}
