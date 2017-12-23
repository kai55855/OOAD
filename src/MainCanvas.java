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
    private Graphics2D g2;
    private SelectBtnMode selectBtnMode;
    private ClassBtnMode classBtnMode;
    private UseCaseBtnMode useCaseBtnMode;
    private AssociationLineBtnMode associationLineBtnMode;
    private GeneralizationLineBtnMode generalizationLineBtnMode;
    private CompositionLineBtnMode compositionLineBtnMode;
    public Vector paintedObject;
    public Vector paintedLine;
    UmlObject prevUMLObject;
    AssociationLine associationLine;
    GeneralizationLine generalizationLine;
    CompositionLine compositionLine;

    int pressedX, pressedY;


    public MainCanvas() {
        super();
        MouseMotion mouseMotion = new MouseMotion();
        this.addMouseListener(mouseMotion);
        this.addMouseMotionListener(mouseMotion);
        //default is selectBtnClick
        selectBtnMode = new SelectBtnMode();
        classBtnMode = new ClassBtnMode();
        useCaseBtnMode = new UseCaseBtnMode();
        associationLineBtnMode = new AssociationLineBtnMode();
        generalizationLineBtnMode = new GeneralizationLineBtnMode();
        compositionLineBtnMode = new CompositionLineBtnMode();
        paintedObject = new Vector();
        paintedLine = new Vector();
        pressedX = 0;
        pressedY = 0;
        changeMouseMode(1);
    }

    void setMouse(MouseMode mouseMode) {
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

    void changeMouseMode(int id) {
        if (id == 1) {
            setMouse(selectBtnMode);
        } else if (id == 2) {
            setMouse(associationLineBtnMode);
        } else if (id == 3) {
            setMouse(generalizationLineBtnMode);
        } else if (id == 4) {
            setMouse(compositionLineBtnMode);
        } else if (id == 5) {
            setMouse(classBtnMode);
        } else if (id == 6) {
            setMouse(useCaseBtnMode);
        } else {
            setMouse(selectBtnMode);
        }
    }

    public class SelectBtnMode implements MouseMode {
        int clicked = 0;
        int pressed = 0;
        int dragged = 0;

        @Override
        public void mouseClicked(int x, int y) {
////            System.out.println("this is select btn clicked");
//            paintedObject.sort(new SortUmlObject());
//            for (int i = paintedObject.size() - 1; i >= 0; i--) {
//                System.out.printf("%d, ", ((UmlObject) paintedObject.get(i)).getDepth());
//            }
//            System.out.printf("\n");
//            for (int i = paintedObject.size() - 1; i >= 0; i--) {
////                if (((UmlObject) paintedObject.get(i)).getLined() || ((UmlObject) paintedObject.get(i)).clicked(x, y, g2)) {
//                if (((UmlObject) paintedObject.get(i)).clicked(x, y, g2))
//                    ((UmlObject) paintedObject.get(i)).setSelected(true);
//                else {
//                    ((UmlObject) paintedObject.get(i)).setSelected(false);
//                }
//            }
//
//            drawPaintedObject();
        }

        @Override
        public void mousePressed(int x, int y) {
////            System.out.println("this is select btn pressed");
//            pressed = 0;
//            dragged = 0;
//            prevUMLObject = findTopObject(x, y);
////            paintedObject.remove(prevUMLObject);
//            if (prevUMLObject != null)
//                pressed = 1;
//            else {
//                pressedX = x;
//                pressedY = y;
//            }
        }

        @Override
        public void mouseDragged(int x, int y) {
//            if (pressed > 0) {
////                paintedObject.remove(prevUMLObject);
//                clear();
//                prevUMLObject.move(x, y);
//                //paintedObject.add(prevUMLObject);
//                drawPaintedObject();
//                dragged = 1;
//            }
        }

        @Override
        public void mouseReleased(int x, int y) {
////            System.out.println("this is select btn released");
//            if (dragged > 0 && pressed > 0) {
////                paintedObject.remove(prevUMLObject);
//                clear();
//                prevUMLObject.move(x, y);
//                for (int i = 0; i < paintedObject.size(); i++) {
//                    if (prevUMLObject != (UmlObject) paintedObject.get(i) && prevUMLObject.getDepth() >= ((UmlObject) paintedObject.get(i)).getDepth() && prevUMLObject.hit((UmlObject) paintedObject.get(i), g2)) {
//                        ((UmlObject) paintedObject.get(i)).setDepth(((UmlObject) paintedObject.get(i)).getDepth() + 1);
//                    }
//                }
////                paintedObject.add(prevUMLObject);
//                drawPaintedObject();
//            } else {
//                int releasedX = x, releasedY = y;
//                for (int i = 0; i < paintedObject.size(); i++) {
////                    if(!((UmlObject)paintedObject.get(i)).getLined()){
//                    ((UmlObject) paintedObject.get(i)).setSelected(false);
////                    }
//                }
//                drawPaintedObject();
//                for (int i = 0; i < paintedObject.size(); i++) {
//                    int objX, objY, objW, objH;
//                    objX = ((UmlObject) paintedObject.get(i)).getX();
//                    objY = ((UmlObject) paintedObject.get(i)).getY();
//                    objW = ((UmlObject) paintedObject.get(i)).getWidth();
//                    objH = ((UmlObject) paintedObject.get(i)).getHeight();
//                    if ((objX >= pressedX && objX <= releasedX) || (objX <= pressedX && objX >= releasedX)) {
//                        if ((objY >= pressedY && objY <= releasedY) || (objY <= pressedY && objY >= releasedY)) {
//                            if ((objX + objW >= pressedX && objX + objW <= releasedX) || (objX + objW <= pressedX && objX + objW >= releasedX)) {
//                                if ((objY + objH >= pressedY && objY + objH <= releasedY) || (objY + objH <= pressedY && objY + objH >= releasedY)) {
//                                    ((UmlObject) paintedObject.get(i)).setSelected(true);
//                                    System.out.printf("pressedX = %d, pressedY = %d\n", pressedX, pressedY);
//                                }
//                            }
//                        }
//                    }
//                }
//                drawPaintedObject();
//            }
        }
    }

    public class ClassBtnMode implements MouseMode {
        @Override
        public void mouseClicked(int x, int y) {
//            System.out.println("this is class btn clicked");
            ClassObject classObject = new ClassObject(x, y, 0);
            for (int i = 0; i < paintedObject.size(); i++) {
                if (classObject.hit((UmlObject) paintedObject.get(i), g2)) {
                    ((UmlObject) paintedObject.get(i)).setDepth(((UmlObject) paintedObject.get(i)).getDepth() + 1);
                }
            }
            paintedObject.add((UmlObject) classObject);
            g2 = classObject.draw(g2);
            repaint();
        }

        @Override
        public void mousePressed(int x, int y) {
//            System.out.println("this is class btn pressed");

        }

        @Override
        public void mouseDragged(int x, int y) {
//            System.out.println("this is class btn dragged");

        }

        @Override
        public void mouseReleased(int x, int y) {

        }
    }

    public class UseCaseBtnMode implements MouseMode {

        @Override
        public void mouseClicked(int x, int y) {
//            System.out.println("this is use case btn clicked");
            UseCaseObject useCaseObject = new UseCaseObject(x, y, 0);
            for (int i = 0; i < paintedObject.size(); i++) {
                if (useCaseObject.hit((UmlObject) paintedObject.get(i), g2)) {
                    ((UmlObject) paintedObject.get(i)).setDepth(((UmlObject) paintedObject.get(i)).getDepth() + 1);
                }
            }
            paintedObject.add(useCaseObject);
            g2 = useCaseObject.draw(g2);
            repaint();
        }

        @Override
        public void mousePressed(int x, int y) {
//            System.out.println("this is use case btn pressed");

        }

        @Override
        public void mouseDragged(int x, int y) {
//            System.out.println("this is use case btn dragged");

        }

        @Override
        public void mouseReleased(int x, int y) {

        }
    }

    public class AssociationLineBtnMode implements MouseMode {
        boolean pressed = false;

        @Override
        public void mouseClicked(int x, int y) {

        }

        @Override
        public void mousePressed(int x, int y) {
            pressed = false;
//            System.out.printf("line pressed\n");
            UmlObject top = findTopObject(x, y);
            if (top == null)
                System.out.printf("line mouse pressed top == null\n");
            if (top != null) {
                pressed = true;
                top.setSelected(true);
                g2 = top.draw(g2);
                repaint();
//                System.out.printf("top painted\n");
                associationLine = new AssociationLine();
                associationLine.setStartObject(top);
                associationLine.setStartX(x);
                associationLine.setStartY(y);
            }
        }

        @Override
        public void mouseDragged(int x, int y) {

        }

        @Override
        public void mouseReleased(int x, int y) {
            if (!pressed) {
                return;
            }
//            System.out.printf("line release\n");
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                top.setSelected(true);
                g2 = top.draw(g2);
                repaint();
                System.out.printf("top painted\n");
                associationLine.setEndObject(top);
                associationLine.setEndX(x);
                associationLine.setEndY(y);
                g2 = associationLine.draw(g2);
                repaint();
                paintedLine.add(associationLine);
            }
        }

    }

    public class GeneralizationLineBtnMode implements MouseMode {
        boolean pressed = false;

        @Override
        public void mouseClicked(int x, int y) {

        }

        @Override
        public void mousePressed(int x, int y) {
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                pressed = true;
                top.setSelected(true);
                g2 = top.draw(g2);
                repaint();
                System.out.printf("top painted\n");
                generalizationLine = new GeneralizationLine();
                generalizationLine.setStartObject(top);
                generalizationLine.setStartX(x);
                generalizationLine.setStartY(y);
            }
        }

        @Override
        public void mouseDragged(int x, int y) {

        }

        @Override
        public void mouseReleased(int x, int y) {
            if (!pressed)
                return;
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                top.setSelected(true);
                g2 = top.draw(g2);
                repaint();
                generalizationLine.setEndObject(top);
                generalizationLine.setEndX(x);
                generalizationLine.setEndY(y);
                g2 = generalizationLine.draw(g2);
                repaint();
                paintedLine.add(generalizationLine);
            }
        }
    }

    public class CompositionLineBtnMode implements MouseMode {
        boolean pressed = false;

        @Override
        public void mouseClicked(int x, int y) {

        }

        @Override
        public void mousePressed(int x, int y) {
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                pressed = true;
                top.setSelected(true);
                g2 = top.draw(g2);
                repaint();
                compositionLine = new CompositionLine();
                compositionLine.setStartObject(top);
                compositionLine.setStartX(x);
                compositionLine.setStartY(y);
            }
        }

        @Override
        public void mouseDragged(int x, int y) {

        }

        @Override
        public void mouseReleased(int x, int y) {
            if (!pressed)
                return;
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                top.setSelected(true);
                g2 = top.draw(g2);
                repaint();
                compositionLine.setEndObject(top);
                compositionLine.setEndX(x);
                compositionLine.setEndY(y);
                g2 = compositionLine.draw(g2);
                repaint();
                paintedLine.add(compositionLine);
            }
        }
    }


    UmlObject findTopObject(int x, int y) {
        Vector pressedObject = new Vector();
        for (int i = 0; i < paintedObject.size(); i++) {
            if (((UmlObject) paintedObject.get(i)).clicked(x, y, g2)) {
                pressedObject.add(paintedObject.get(i));
            }
        }
        if (!pressedObject.isEmpty()) {
            int min = 0, minDepth = 99;
            for (int i = 0; i < pressedObject.size(); i++) {
                int tmpDepth;
                tmpDepth = ((UmlObject) pressedObject.get(i)).getDepth();
                if (tmpDepth <= minDepth) {
                    min = i;
                    minDepth = tmpDepth;
                }
            }
            return (UmlObject) pressedObject.get(min);
        }
        return null;
    }

    void drawPaintedObject() {
        clear();
        paintedObject.sort(new SortUmlObject());
        g2.setPaint(Color.black);
        System.out.printf("paintedObject size = %d\n", paintedObject.size());
        for (int i = 0; i < paintedObject.size(); i++) {
            g2 = ((UmlObject) paintedObject.get(i)).draw(g2);
        }
        repaint();
//        System.out.printf("paintedLine size = %d\n", paintedLine.size());
        for (int i = 0; i < paintedLine.size(); i++) {
            g2 = ((UmlLine) paintedLine.get(i)).draw(g2);
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
        //System.out.printf("width = %d, heigh = %d\n", getSize().width, getSize().height);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    void changeObjectName(String name) {
        for (int i = 0; i < paintedObject.size(); i++) {
            if (((UmlObject) paintedObject.get(i)).getSelected()) {
                ((UmlObject) paintedObject.get(i)).setObjectName(name);
                System.out.printf("change name\n");
            }
        }
        drawPaintedObject();
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

    void setMouseMode(MouseMode mouseMode) { this.mouseMode = mouseMode;}
}
