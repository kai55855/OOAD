import java.awt.*;
import java.util.Vector;

public abstract class Shape {
    private int x, y;
    private boolean selected;
    private int depth, width, height;
    private String objectName;
    private int lastX, lastY;
    private int selectedPortNumber;
    public Shape(int x, int y, int depth, String objectName) {
        setX(x);
        setY(y);
        setDepth(depth);
        setObjectName(objectName);
        setSelected(false);
        setLastX(0);
        setLastY(0);
        setSelectedPortNumber(0);
    }

    void setX(int x) {
        this.x = x;
    }

    int getX() {
        return this.x;
    }

    void setY(int y) {
        this.y = y;
    }

    int getY() {
        return this.y;
    }

    void setSelected(boolean selected) {
        this.selected = selected;
    }

    boolean getSelected() {
        return selected;
    }
    void setWidth(int width) {
        this.width = width;
    }

    int getWidth() {
        return this.width;
    }

    void setHeight(int height) {
        this.height = height;
    }

    int getHeight() {
        return this.height;
    }

    void setDepth(int depth) {
        if (depth > 99)
            depth = 99;
        this.depth = depth;
    }

    int getDepth() {
        return this.depth;
    }

    void setLastX(int x) {
        this.lastX = x;
    }

    int getLastX(){
        return this.lastX;
    }

    void setLastY(int y) {
        this.lastY = y;
    }

    int getLastY(){
        return this.lastY;
    }

    void setSelectedPortNumber(int number){
        this.selectedPortNumber = number;
    }

    int getSelectedPortNumber(){
        return this.selectedPortNumber;
    }

    void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    String getObjectName() {
        return this.objectName;
    }

    abstract Graphics2D draw(Graphics2D g2);

    abstract  void move(int x, int y);

    abstract boolean hit(Shape shape, Graphics2D g2);

    abstract boolean clicked(int x, int y, Graphics2D g2);

    abstract boolean isCovered(int x, int y, int x2, int y2);


    abstract Port getPort(int x, int y, Graphics2D g2);

    abstract void addGroup(Shape shape);

    abstract boolean unGroup(Vector<Shape> paintedObject);
}
