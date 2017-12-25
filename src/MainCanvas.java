import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Vector;

import static java.lang.Math.abs;

public class MainCanvas extends Canvas {
    private MouseMode mouseMode;
    private Image image;
    public int pressedX, pressedY;

    public Vector<Shape> paintedObject;
    public Vector paintedLine;
    public Graphics2D g2;

    public MainCanvas() {
        super();
        MouseMotion mouseMotion = new MouseMotion();
        this.addMouseListener(mouseMotion);
        this.addMouseMotionListener(mouseMotion);
        //default is selectBtnClick

        paintedObject = new Vector();
        paintedLine = new Vector();
        pressedX = 0;
        pressedY = 0;
    }

    void setMouseMode(MouseMode mouseMode) {
        this.mouseMode = mouseMode;
    }

    void clicked(int x, int y) {
        this.mouseMode.mouseClicked(x, y);
    }

    void pressed(int x, int y) {
        this.mouseMode.mousePressed(x, y);
    }

    void dragged(int x, int y) {
        this.mouseMode.mouseDragged(x, y);
    }

    void reaeased(int x, int y) {
        this.mouseMode.mouseReleased(x, y);
    }


    Shape findTopObject(int x, int y) {
        paintedObject.sort(new SortShapeObject());
        for (int i = paintedObject.size() - 1; i >= 0; i--) {
            if (paintedObject.get(i).clicked(x, y, g2)) {
                return paintedObject.get(i);
            }
        }
        return null;
    }

    void drawPaintedObject() {
        clear();
        paintedObject.sort(new SortShapeObject());
        g2.setPaint(Color.black);
        for (int i = 0; i < paintedObject.size(); i++) {
            g2 = paintedObject.get(i).draw(g2);
        }
        repaint();
    }

    public void paint(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.white);
        // draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    void setSelected(Shape shape, boolean flag){
        for(int i = 0;i < paintedObject.size();i++){
            if(paintedObject.get(i) != shape){
                paintedObject.get(i).setSelected(!flag);
            }
            else{
                paintedObject.get(i).setSelected(flag);
            }
        }
    }

    void changeObjectName(String name) {
        for (int i = 0; i < paintedObject.size(); i++) {
            if (paintedObject.get(i).getSelected()) {
                paintedObject.get(i).setObjectName(name);
            }
        }
        drawPaintedObject();
    }

    void groupObject() {
        mouseMode.group();
    }

    void unGroup(){
        mouseMode.unGroup();
    }

    class MouseMotion extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            clicked(e.getX(), e.getY());
        }

        public void mouseReleased(MouseEvent e) {
            reaeased(e.getX(), e.getY());
        }

        public void mousePressed(MouseEvent e) {
            pressed(e.getX(), e.getY());
        }

        public void mouseDragged(MouseEvent e) {
            dragged(e.getX(), e.getY());
        }

        public void mouseMoved(MouseEvent e) {
        }


    }

}
