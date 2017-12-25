import java.awt.*;
import java.util.Vector;

public class GroupObject extends Shape {
    Vector<Shape> group;

    public GroupObject() {
        super(0, 0, 0, "group");
        group = new Vector();
    }


    @Override
    Graphics2D draw(Graphics2D g2) {
        if (group != null) {
            for (int i = 0; i < group.size(); i++) {
                g2 = group.get(i).draw(g2);
            }
        }
        return g2;
    }

    @Override
    void move(int x, int y) {
        int offsetX = x - getLastX();
        int offsetY = y - getLastY();
        if (group != null) {
            for (int i = 0; i < group.size(); i++) {
                group.get(i).move(group.get(i).getX() + offsetX, group.get(i).getY() + offsetY);
            }
        }

    }


    @Override
    boolean hit(Shape shape, Graphics2D g2) {
        return false;
    }

    @Override
    boolean clicked(int x, int y, Graphics2D g2) {
        if (group != null) {
            for (int i = 0; i < group.size(); i++) {
                if (group.get(i).clicked(x, y, g2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    boolean isCovered(int x, int y, int x2, int y2) {
        if (group != null) {
            for (int i = 0; i < group.size(); i++) {
                if (!group.get(i).isCovered(x, y, x2, y2))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    Port getPort(int x, int y, Graphics2D g2) {
        for(int i = 0;i < group.size();i++){
            Port port = group.get(i).getPort(x, y, g2);
            if(port != null){
                setSelectedPortNumber(group.get(i).getSelectedPortNumber());
                return port;
            }
        }
        return null;
    }

    void setSelected(boolean selected) {
        super.setSelected(selected);
        if (group != null) {
            for (int i = 0; i < group.size(); i++) {
                group.get(i).setSelected(selected);
            }
        }
    }

    void addGroup(Shape shape) {
        shape.setLastX(0);
        shape.setLastY(0);
        group.add(shape);
    }

    boolean unGroup(Vector<Shape> paintedObject) {
        for (int i = 0; i < group.size(); i++) {
            group.get(i).setSelected(false);
            paintedObject.add(group.get(i));
        }
        return true;
    }

}
