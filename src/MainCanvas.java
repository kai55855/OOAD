import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCanvas extends Canvas {
    private MouseClick mouseClick;
    public MainCanvas(){
        super();
        MouseMotion tmp = new MouseMotion();
        this.addMouseListener(tmp);
        this.addMouseMotionListener(tmp);
        //default is selectBtnClick
        setMouse(new SelectBtnClick());

    }

    void setMouse(MouseClick mouseClick){
        this.mouseClick = mouseClick;
    }

    void click(){
        this.mouseClick.mouseClick();
    }




    public void paint(Graphics g) {
//        g.drawOval(xPress, yPress, 50, 50);
//        //g.drawLine(0, 0, 100, 100);

    }

    class MouseMotion extends MouseAdapter{

        public void mouseClicked(MouseEvent e) {
//            stateText.setText("mouseClicked x = " + e.getX() + " y = " + e.getY());
//            System.out.println("mouseClicked");
//            xPress = e.getX();
//            yPress = e.getY();
//            repaint();
            mouseClick.mouseClick();

        }
        public void mouseReleased(MouseEvent e){
//            stateText.setText("mouseReleased x = " + e.getX() + " y = " + e.getY());
//            System.out.println("mouseReleased");

        }
        public void mousePressed(MouseEvent e){
//            stateText.setText("mousePressed x = " + e.getX() + " y = " + e.getY());
//            System.out.println("mousePressed");
        }

        public void mouseDragged(MouseEvent e){
            //xEnd = e.getX();
            //yEnd = e.getY();
            //stateText.setText("mouseDragged x = " + e.getX() + " y = " + e.getY());
            //System.out.println("mouseDragged");
        }

        public void mouseMoved(MouseEvent e){
            //stateText.setText("mouseMoved x = " + e.getX() + " y = " + e.getY());
            //xStart = e.getX();
            //yStart = e.getY();
        }



    }
}
