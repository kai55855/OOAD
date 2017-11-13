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
    ClassObject eraseClassObject;
    ClassObject newClassObject;
    UseCaseObject eraseUseCaseObject;
    UseCaseObject newUseCaseObject;


    public MainCanvas(){
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

    void setMouse(MouseMode mouseMode){
        this.mouseMode = mouseMode;
    }

    void clicked(int x, int y){
        this.mouseMode.mouseClicked(x, y);
    }

    void pressed(int x, int y){
        this.mouseMode.mousePressed(x, y);
    }

    void dragged(int x, int y){
        this.mouseMode.mouseDragged(x, y);
    }

    void reaeased(int x, int y){
        this.mouseMode.mouseReaeased(x, y);
    }

    void changeMouseMode(int id) {
        if (id == 1) {
            setMouse(selectBtnMode);
        }
        else if (id == 5){
            setMouse(classBtnMode);
        }
        else if (id == 6) {
            setMouse(useCaseBtnMode);
        }
        else {
            setMouse(selectBtnMode);
        }
    }

    public class SelectBtnMode implements MouseMode {
        int enable = 0;
        @Override
        public void mouseClicked(int x, int y) {
            System.out.println("this is select btn clicked");
        }

        @Override
        public void mousePressed(int x, int y) {
            System.out.println("this is select btn pressed");
            enable = 0;
            int tmpX, tmpY;
            Vector pressedObject = new Vector();
            for(int i = 0;i < paintedObject.size();i++){
                if(paintedObject.get(i) instanceof ClassObject){
                    tmpX = ((ClassObject)paintedObject.get(i)).getX();
                    tmpY = ((ClassObject)paintedObject.get(i)).getY();
                    if(x <= tmpX + 40 && x >= tmpX && y <= tmpY + 60 && y >= tmpY){
                        pressedObject.add(((ClassObject)paintedObject.get(i)));
                    }
                }
                else{
                    //Point2D point2D = new Point2D.Double(x, y);
                    Rectangle rectangle = new Rectangle(x, y, 1, 1);
                    if(g2.hit(rectangle, ((UseCaseObject)paintedObject.get(i)).ellipse2D, false)){
                        //System.out.println("hit success");
                        pressedObject.add(((UseCaseObject)paintedObject.get(i)));
                    }
//                    tmpX = ((UseCaseObject)paintedObject.get(i)).getX();
//                    tmpY = ((UseCaseObject)paintedObject.get(i)).getY();
//                    if(x <= tmpX + 80 && x >= tmpX && y <= tmpY + 40 && y >= tmpY){
//                        eraseUseCaseObject = (UseCaseObject)paintedObject.get(i);
//                        paintedObject.remove(i);
//                        enable = 2;
//                        return;
//                    }
                }
            }
            int min  = 0, minDepth = 99;
            for(int i = 0;i < pressedObject.size();i++){
                int tmpDepth;
                if(pressedObject.get(i) instanceof ClassObject){
                    tmpDepth = ((ClassObject)pressedObject.get(i)).getDepth();
                    if(tmpDepth <= minDepth){
                        min = i;
                        minDepth = tmpDepth;
                    }
                }
                else{
                    tmpDepth = ((UseCaseObject)pressedObject.get(i)).getDepth();
                    if(tmpDepth <= minDepth){
                        min = i;
                        minDepth = tmpDepth;
                    }
                }
            }
            if(pressedObject.get(min) instanceof ClassObject){
                eraseClassObject = ((ClassObject)paintedObject.get(min));
                paintedObject.remove(eraseClassObject);
                enable = 1;
                return;
            }
            else{
                eraseUseCaseObject = ((UseCaseObject)paintedObject.get(min));
                paintedObject.remove(eraseUseCaseObject);
                enable = 2;
                return;
            }
        }

        @Override
        public void mouseDragged(int x, int y) {
            if(enable > 0){
                if(enable == 1){
                    System.out.println("this is select btn ClassObject dragged");
                    paintedObject.remove(eraseClassObject);
                    clear();
                    newClassObject = new ClassObject(x, y, eraseClassObject.getDepth());
                    paintedObject.add(newClassObject);
                    drawPaintedObject();
                    eraseClassObject = newClassObject;
                }
                else if(enable == 2){
                    System.out.println("this is select btn UseCaseObject dragged");
                    paintedObject.remove(eraseUseCaseObject);
                    clear();
                    newUseCaseObject = new UseCaseObject(x, y, eraseUseCaseObject.getDepth());
                    paintedObject.add(newUseCaseObject);
                    drawPaintedObject();
                    eraseUseCaseObject = newUseCaseObject;
                }
            }
        }
        @Override
        public void mouseReaeased(int x, int y) {
            if(enable > 0){
                if(enable == 1){
                    paintedObject.add(eraseClassObject);
                }
                else if(enable == 2){
                    paintedObject.add(eraseUseCaseObject);
                }
            }
        }
    }

    public class ClassBtnMode implements MouseMode {
        @Override
        public void mouseClicked(int x, int y) {
            System.out.println("this is class btn clicked");
            ClassObject classObject = new ClassObject(x, y, 0);
            paintedObject.add(classObject);
            g2 = classObject.draw(g2);
            repaint();
        }

        @Override
        public void mousePressed(int x, int y) {
            System.out.println("this is class btn pressed");

        }

        @Override
        public void mouseDragged(int x, int y) {
            System.out.println("this is class btn dragged");

        }

        @Override
        public void mouseReaeased(int x, int y) {

        }
    }

    public class UseCaseBtnMode implements MouseMode{

        @Override
        public void mouseClicked(int x, int y) {
            System.out.println("this is use case btn clicked");
            UseCaseObject useCaseObject = new UseCaseObject(x, y, 0);
            paintedObject.add(useCaseObject);
            g2 = useCaseObject.draw(g2);
            repaint();
        }

        @Override
        public void mousePressed(int x, int y) {
            System.out.println("this is use case btn pressed");

        }

        @Override
        public void mouseDragged(int x, int y) {
            System.out.println("this is use case btn dragged");

        }

        @Override
        public void mouseReaeased(int x, int y) {

        }
    }



    void drawPaintedObject(){
        g2.setPaint(Color.black);
        for(int i = 0;i < paintedObject.size();i++){
            if(paintedObject.get(i) instanceof ClassObject){
                g2 = ((ClassObject) paintedObject.get(i)).draw(g2);
            }
            else{
                g2 = ((UseCaseObject)paintedObject.get(i)).draw(g2);
            }
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
        System.out.printf("width = %d, heigh = %d\n", getSize().width, getSize().height);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    class MouseMotion extends MouseAdapter{

        public void mouseClicked(MouseEvent e) {
            clicked(e.getX(), e.getY());
        }
        public void mouseReleased(MouseEvent e){
            reaeased(e.getX(), e.getY());
        }
        public void mousePressed(MouseEvent e){
            pressed(e.getX(), e.getY());
        }

        public void mouseDragged(MouseEvent e){
            dragged(e.getX(), e.getY());
        }

        public void mouseMoved(MouseEvent e){
            //stateText.setText("mouseMoved x = " + e.getX() + " y = " + e.getY());
            //xStart = e.getX();
            //yStart = e.getY();
        }



    }


}
