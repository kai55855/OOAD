import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

public abstract class UmlObject {
    protected int depth, x, y, width, height;
    protected  boolean selected, lined;
    protected String objectName;
    protected Ellipse2D ellipse2D;
    protected Rectangle name;
    protected Rectangle attribute;
    protected Rectangle method;
    protected Rectangle r1, r2, r3, r4;
    public UmlObject(int x, int y, int depth, String objectName){
        setLined(false);
        setSelected(false);
        setHeight(0);
        setWidth(0);
        setX(x);
        setY(y);
        setDepth(depth);
        setObjectName(objectName);
    }

    void setLined(boolean lined){
        this.lined = lined;
    }

    boolean getLined(){
        return this.lined;
    }

    void setSelected(boolean selected){
        this.selected = selected;
    }

    boolean getSelected(){
        return selected;
    }

    void setWidth(int width){
        this.width = width;
    }

    int getWidth(){
        return this.width;
    }

    void setHeight(int height){
        this.height = height;
    }

    int getHeight(){
        return this.height;
    }

    void setDepth(int depth){
        if(depth > 99)
            depth = 99;
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
    }

    void setY(int y){
        this.y = y;
    }

    int getY(){
        return this.y;
    }

    void setObjectName(String objectName){
        this.objectName = objectName;
    }

    abstract Graphics2D draw(Graphics2D g2);
    abstract boolean clicked(int x, int y, Graphics2D g2);
    abstract void move(int x, int y);
    abstract boolean hit(UmlObject umlObject, Graphics2D g2);
    abstract Point[] linePoint(int x, int y, Graphics2D g2);
}
