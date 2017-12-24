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
    AssociationLine associationLine;
    GeneralizationLine generalizationLine;
    CompositionLine compositionLine;


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
        Vector pressedObject = new Vector();
        paintedObject.sort(new SortShapeObject());
        for (int i = paintedObject.size() - 1; i >= 0; i--) {
            if (paintedObject.get(i).clicked(x, y, g2)) {
                return paintedObject.get(i);
            }
        }
        return null;
//        for (int i = 0; i < paintedObject.size(); i++) {
//            if (paintedObject.get(i).clicked(x, y, g2)) {
//                pressedObject.add(paintedObject.get(i));
//            }
//        }
//        if (!pressedObject.isEmpty()) {
//            int min = 0, minDepth = 99;
//            for (int i = 0; i < pressedObject.size(); i++) {
//                int tmpDepth;
//                tmpDepth = ((UmlObject) pressedObject.get(i)).getDepth();
//                if (tmpDepth <= minDepth) {
//                    min = i;
//                    minDepth = tmpDepth;
//                }
//            }
//            return (UmlObject) pressedObject.get(min);
//        }
//        return null;
    }

    void drawPaintedObject() {
        clear();
//        paintedObject.sort(new SortBasicObject());
        g2.setPaint(Color.black);
//        System.out.printf("paintedObject size = %d\n", paintedObject.size());
        for (int i = 0; i < paintedObject.size(); i++) {
//            System.out.printf("depth = %d\n", paintedObject.get(i).getDepth());
            g2 = paintedObject.get(i).draw(g2);
        }
        repaint();
////        System.out.printf("paintedLine size = %d\n", paintedLine.size());
//        for (int i = 0; i < paintedLine.size(); i++) {
//            g2 = ((UmlLine) paintedLine.get(i)).draw(g2);
//        }
//        repaint();
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
        //System.out.printf("width = %d, heigh = %d\n", getSize().width, getSize().height);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    void changeObjectName(String name) {
//        for (int i = 0; i < paintedObject.size(); i++) {
//            if (((UmlObject) paintedObject.get(i)).getSelected()) {
//                ((UmlObject) paintedObject.get(i)).setObjectName(name);
//                System.out.printf("change name\n");
//            }
//        }
//        drawPaintedObject();
    }

    void groupObject() {
//        System.out.printf("group btn\n");
//        Vector groupVector = new Vector();
//        UmlObject group = null;
//        for (int i = 0; i < paintedObject.size(); i++) {
//            if (((UmlObject) paintedObject.get(i)).getSelected()) {
//                groupVector.add((UmlObject) paintedObject.get(i));
//            }
//        }
////        for(int i = 0; i < groupVector.size(); i++){
////            paintedObject.remove(((UmlObject) groupVector.get(i)));
////        }
//        group = (UmlObject)groupVector.get(0);
//        groupVector.remove(group);
//        for(int i = 0; i < groupVector.size(); i++){
//            group.group.add(((UmlObject) groupVector.get(i)));
//        }
//        paintedObject.add(group);
//        drawPaintedObject();
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
            //stateText.setText("mouseMoved x = " + e.getX() + " y = " + e.getY());
            //xStart = e.getX();
            //yStart = e.getY();
        }


    }

}
