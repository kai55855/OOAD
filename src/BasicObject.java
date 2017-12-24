import java.awt.*;

public class BasicObject extends Shape {


    public BasicObject(int x, int y, int depth, String objectName) {
        super(x, y, depth, objectName);
    }


    @Override
    Graphics2D draw(Graphics2D g2) {
        return null;
    }

    @Override
    void move(int x, int y) {
    }

    @Override
    boolean hit(Shape shape, Graphics2D g2) {
        return false;
    }

    @Override
    boolean clicked(int x, int y, Graphics2D g2) {
        return false;
    }

    boolean isCovered(int x, int y, int x2, int y2) {
        if ((getX() >= x && getX() <= x2) || (getX() <= x && getX() >= x2)) {
            if ((getY() >= y && getY() <= y2) || (getY() <= y && getY() >= y2)) {
                if ((getX() + getWidth() >= x && getX() + getWidth() <= x2) || (getX() + getWidth() <= x && getX() + getWidth() >= x2)) {
                    if ((getY() + getHeight() >= y && getY() + getHeight() <= y2) || (getY() + getHeight() <= y && getY() + getHeight() >= y2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}