import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Vector;

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
    private Vector paintedObject;
    private Vector paintedLine;
    UmlObject prevUMLObject;
    AssociationLine associationLine;

    int lineStartX, lineStartY;


    public MainCanvas() {
        super();
        MouseMotion mouseMotion = new MouseMotion();
        this.addMouseListener(mouseMotion);
        this.addMouseMotionListener(mouseMotion);
        //default is selectBtnClick
        changeMouseMode(1);
        selectBtnMode = new SelectBtnMode();
        classBtnMode = new ClassBtnMode();
        useCaseBtnMode = new UseCaseBtnMode();
        associationLineBtnMode = new AssociationLineBtnMode();
        generalizationLineBtnMode = new GeneralizationLineBtnMode();
        compositionLineBtnMode = new CompositionLineBtnMode();
        paintedObject = new Vector();
        paintedLine = new Vector();
        lineStartX = 0;
        lineStartY = 0;
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
            System.out.println("this is select btn clicked");
            paintedObject.sort(new SortUmlObject());
            for (int i = paintedObject.size() - 1; i >= 0; i--) {
                if (((UmlObject) paintedObject.get(i)).clicked(x, y, g2)) {
                    ((UmlObject) paintedObject.get(i)).setSelected(true);
                } else {
                    ((UmlObject) paintedObject.get(i)).setSelected(false);
                }
            }
            drawPaintedObject();
        }

        @Override
        public void mousePressed(int x, int y) {
            System.out.println("this is select btn pressed");
            pressed = 0;
            dragged = 0;
            prevUMLObject = findTopObject(x, y);
//            paintedObject.remove(prevUMLObject);
            if (prevUMLObject != null)
                pressed = 1;
        }

        @Override
        public void mouseDragged(int x, int y) {
            if (pressed > 0) {
//                paintedObject.remove(prevUMLObject);
                clear();
                prevUMLObject.move(x, y);
                //paintedObject.add(prevUMLObject);
                drawPaintedObject();
                dragged = 1;
            }
        }

        @Override
        public void mouseReleased(int x, int y) {
            System.out.println("this is select btn released");
            if (dragged > 0) {
//                paintedObject.remove(prevUMLObject);
                clear();
                prevUMLObject.move(x, y);
//                for (int i = 0; i < paintedObject.size(); i++) {
//                    if (prevUMLObject.hit((UmlObject) paintedObject.get(i), g2)) {
//                        ((UmlObject) paintedObject.get(i)).setDepth(((UmlObject) paintedObject.get(i)).getDepth() + 1);
//                    }
//                }
//                paintedObject.add(prevUMLObject);
                drawPaintedObject();
            } else if (dragged == 0 && pressed > 0) {
//                paintedObject.add(prevUMLObject);
            }
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
        @Override
        public void mouseClicked(int x, int y) {

        }

        @Override
        public void mousePressed(int x, int y) {
            System.out.printf("line pressed\n");
            UmlObject top = findTopObject(x, y);
            if (top == null)
                System.out.printf("top == null\n");
            if (top != null) {
                top.setSelected(true);
                g2 = top.draw(g2);
                repaint();
                System.out.printf("top painted\n");
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
            System.out.printf("line release\n");
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                top.setSelected(true);
                g2 = top.draw(g2);
                repaint();
                g2.setColor(Color.black);
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
        @Override
        public void mouseClicked(int x, int y) {

        }

        @Override
        public void mousePressed(int x, int y) {
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                top.setSelected(true);
                Point[] point;
                point = top.linePoint(x, y, g2);
                if (point != null) {
                    g2 = top.draw(g2);
                    repaint();
                    lineStartX = point[0].x;
                    lineStartY = point[0].y;
                }
            }
        }

        @Override
        public void mouseDragged(int x, int y) {

        }

        @Override
        public void mouseReleased(int x, int y) {
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                top.setSelected(true);
                Point[] point;
                point = top.linePoint(x, y, g2);
                if (point != null) {
                    g2 = top.draw(g2);
                    g2.setColor(Color.black);
                    g2.drawLine(lineStartX, lineStartY, point[1].x, point[1].y);
                    //need to rewrite
                    if (point[0].x == point[1].x && point[0].y != point[1].y) {
                        System.out.printf("first case\n");
                        g2.drawLine(point[1].x + 4, point[1].y, point[1].x - 4, point[1].y);
                        g2.drawLine(point[1].x - 4, point[1].y, point[0].x, point[0].y);
                        g2.drawLine(point[1].x + 4, point[1].y, point[0].x, point[0].y);
                    } else if (point[0].x != point[1].x && point[0].y == point[1].y) {
                        g2.drawLine(point[1].x, point[1].y - 4, point[1].x, point[1].y + 4);
                        g2.drawLine(point[1].x, point[1].y - 4, point[0].x, point[0].y);
                        g2.drawLine(point[1].x, point[1].y + 4, point[0].x, point[0].y);
                    }
                    repaint();
                }
            }
        }
    }

    public class CompositionLineBtnMode implements MouseMode {
        @Override
        public void mouseClicked(int x, int y) {

        }

        @Override
        public void mousePressed(int x, int y) {
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                top.setSelected(true);
                Point[] point;
                point = top.linePoint(x, y, g2);
                if (point != null) {
                    g2 = top.draw(g2);
                    repaint();
                    lineStartX = point[0].x;
                    lineStartY = point[0].y;
                }
            }
        }

        @Override
        public void mouseDragged(int x, int y) {

        }

        @Override
        public void mouseReleased(int x, int y) {
            UmlObject top = findTopObject(x, y);
            if (top != null) {
                top.setSelected(true);
                Point[] point;
                point = top.linePoint(x, y, g2);
                if (point != null) {
                    g2 = top.draw(g2);
                    g2.setColor(Color.black);
                    g2.drawLine(lineStartX, lineStartY, point[1].x, point[1].y);
                    //need to rewrite
                    if (point[0].x == point[1].x && point[0].y != point[1].y) {
                        System.out.printf("first case\n");
                        g2.drawLine(point[1].x, point[1].y, point[1].x - 4, (point[0].y + point[1].y) / 2);
                        g2.drawLine(point[1].x, point[1].y, point[1].x + 4, (point[0].y + point[1].y) / 2);
                        g2.drawLine(point[0].x, point[0].y, point[1].x - 4, (point[0].y + point[1].y) / 2);
                        g2.drawLine(point[0].x, point[0].y, point[1].x + 4, (point[0].y + point[1].y) / 2);
                    } else if (point[0].x != point[1].x && point[0].y == point[1].y) {
                        g2.drawLine(point[1].x, point[1].y, (point[0].x + point[1].x) / 2, point[1].y + 4);
                        g2.drawLine(point[1].x, point[1].y, (point[0].x + point[1].x) / 2, point[1].y - 4);
                        g2.drawLine(point[0].x, point[0].y, (point[0].x + point[1].x) / 2, point[1].y + 4);
                        g2.drawLine(point[0].x, point[0].y, (point[0].x + point[1].x) / 2, point[1].y - 4);
                    }
                    repaint();
                }
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
