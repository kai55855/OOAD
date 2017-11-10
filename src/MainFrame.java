import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MainFrame extends JFrame{
    static JLabel  stateText = new JLabel("游標位置 :");
    JMenu demo = new JMenu("demo");
    JMenu demo2 = new JMenu("demo2");
    JMenuItem  item1 = new JMenuItem("one");
    JMenuItem  item2 = new JMenuItem("two");
    JMenuBar menubar = new JMenuBar();

    JPanel controlPanel = new JPanel(new GridLayout(6, 1));
    MainCanvas mainCanvas = new MainCanvas(stateText);

    JButton button = new JButton("JButton");
    UseCaseBtn useCaseBtn = new UseCaseBtn();



    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
    }

    public MainFrame(){
        //comit test
        super("UML editor");
        this.setBounds(0,0,800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        //menu
        demo.add(item1);
        demo.addSeparator();
        demo2.add(item2);
        demo.setPopupMenuVisible(true);
        demo2.setPopupMenuVisible(true);
        menubar.add(demo);
        menubar.add(demo2);
        this.setJMenuBar(menubar);
        //control plane
        controlPanel.add(button);
        controlPanel.add(useCaseBtn);
        controlPanel.setVisible(true);
        controlPanel.setBackground(new Color(255, 255, 255));
        this.add(controlPanel, BorderLayout.WEST);
        this.add(mainCanvas, BorderLayout.CENTER);
        this.add(stateText, BorderLayout.SOUTH);
        this.setVisible(true);
    }

}

