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
    private Vector paintedObject;
    UmlObject prevUMLObject;


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
        paintedObject = new Vector();
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
        this.mouseMode.mouseReaeased(x, y);
    }

    void changeMouseMode(int id) {
        if (id == 1) {
            setMouse(selectBtnMode);
        } else if (id == 5) {
            setMouse(classBtnMode);
        } else if (id == 6) {
            setMouse(useCaseBtnMode);
        } else {
            setMouse(selectBtnMode);
        }
    }

    public class SelectBtnMode implements MouseMode {
        int enable = 0;

        @Override
        public void mouseClicked(int x, int y) {
            System.out.println("this is select btn clicked");
            paintedObject.sort(new SortUmlObject());
            for(int i = 0;i < paintedObject.size();i++){
                System.out.printf("%d ", ((UmlObject)paintedObject.get(i)).getDepth());
                System.out.printf("\n");
            }
        }

        @Override
        public void mousePressed(int x, int y) {
//            System.out.println("this is select btn pressed");
            enable = 0;
            Vector pressedObject = new Vector();
            for (int i = 0; i < paintedObject.size(); i++) {
                if (((UmlObject) paintedObject.get(i)).clicked(x, y, g2)) {
                    pressedObject.add(paintedObject.get(i));
                }
            }
            if (pressedObject.size() > 0) {
//                System.out.printf("pressedObject size = %d\n", pressedObject.size());
                int min = 0, minDepth = 99;
                for (int i = 0; i < pressedObject.size(); i++) {
                    int tmpDepth;
                    tmpDepth = ((UmlObject) pressedObject.get(i)).getDepth();
                    if (tmpDepth <= minDepth) {
                        min = i;
                        minDepth = tmpDepth;
                    }
                }
                prevUMLObject = ((UmlObject) pressedObject.get(min));
                paintedObject.remove(prevUMLObject);
                enable = 1;
                return;
            }
            return;
        }

        @Override
        public void mouseDragged(int x, int y) {
            if (enable > 0) {
                paintedObject.remove(prevUMLObject);
                clear();
                prevUMLObject.move(x, y);
                paintedObject.add(prevUMLObject);
                drawPaintedObject();
            }
        }

        @Override
        public void mouseReaeased(int x, int y) {
            if (enable > 0) {
                paintedObject.remove(prevUMLObject);
                clear();
                prevUMLObject.move(x, y);
                for(int i = 0;i < paintedObject.size();i++){
                    if(prevUMLObject.hit((UmlObject)paintedObject.get(i), g2)){
                        ((UmlObject)paintedObject.get(i)).setDepth(((UmlObject)paintedObject.get(i)).getDepth() + 1);
                    }
                }
                paintedObject.add(prevUMLObject);
                drawPaintedObject();
            }
        }
    }

    public class ClassBtnMode implements MouseMode {
        @Override
        public void mouseClicked(int x, int y) {
//            System.out.println("this is class btn clicked");
            ClassObject classObject = new ClassObject(x, y, 0);
            for(int i = 0;i < paintedObject.size();i++){
                if(classObject.hit((UmlObject)paintedObject.get(i), g2)){
                    ((UmlObject)paintedObject.get(i)).setDepth(((UmlObject)paintedObject.get(i)).getDepth() + 1);
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
        public void mouseReaeased(int x, int y) {

        }
    }

    public class UseCaseBtnMode implements MouseMode {

        @Override
        public void mouseClicked(int x, int y) {
//            System.out.println("this is use case btn clicked");
            UseCaseObject useCaseObject = new UseCaseObject(x, y, 0);
            for(int i = 0;i < paintedObject.size();i++){
                if(useCaseObject.hit((UmlObject)paintedObject.get(i), g2)){
                    ((UmlObject)paintedObject.get(i)).setDepth(((UmlObject)paintedObject.get(i)).getDepth() + 1);
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
        public void mouseReaeased(int x, int y) {

        }
    }

    void drawPaintedObject() {
        paintedObject.sort(new SortUmlObject());
        g2.setPaint(Color.black);
        for (int i = 0; i < paintedObject.size(); i++) {
            g2 = ((UmlObject) paintedObject.get(i)).draw(g2);
//            if(paintedObject.get(i) instanceof ClassObject){
//                g2 = ((ClassObject) paintedObject.get(i)).draw(g2);
//            }
//            else{
//                g2 = ((UseCaseObject)paintedObject.get(i)).draw(g2);
//            }
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
