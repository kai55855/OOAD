import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCanvas extends Canvas {
    JLabel stateText;
    int xStart, yStart, xEnd, yEnd, xPress = 0, yPress = 0;
    private MouseClick mouse;
    public MainCanvas(JLabel label){
        super();
        MouseMotion tmp = new MouseMotion();
        this.addMouseListener(tmp);
        this.addMouseMotionListener(tmp);
        stateText = label;

        setMouse(new ClassBtn());

    }

    void setMouse(MouseClick mouseClick){
        this.mouse = mouseClick;
    }

    void click(){
        this.mouse.mouseClick();
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
