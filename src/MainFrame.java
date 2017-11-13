

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

public class MainFrame extends JFrame {
    static JLabel stateText = new JLabel("游標位置 :");
    JMenu demo = new JMenu("demo");
    JMenu demo2 = new JMenu("demo2");
    JMenuItem item1 = new JMenuItem("one");
    JMenuItem item2 = new JMenuItem("two");
    JMenuBar menubar = new JMenuBar();

    JPanel controlPanel = new JPanel(new GridLayout(6, 1));

    MainCanvas mainCanvas = new MainCanvas();
    Vector umlBtn = new Vector();
    SelectBtn selectBtn = new SelectBtn();
    UseCaseBtn useCaseBtn = new UseCaseBtn();
    ClassBtn classBtn = new ClassBtn();


    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();


    }

    public MainFrame() {
        //comit test
        //intelliji commit push test
        //branch test
        super("UML editor");
        this.setBounds(0, 0, 800, 800);
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
        umlBtn.add(selectBtn);
        umlBtn.add(useCaseBtn);
        umlBtn.add(classBtn);
        for (int i = 0; i < umlBtn.size(); i++) {
            controlPanel.add((JButton) umlBtn.get(i));
        }
        controlPanel.setVisible(true);
        controlPanel.setBackground(new Color(120, 166, 255));
        this.add(controlPanel, BorderLayout.WEST);
        this.add(mainCanvas, BorderLayout.CENTER);
        this.add(stateText, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    void setBtnsToWhite() {
        for (int i = 0; i < umlBtn.size(); i++) {
            ((JButton)umlBtn.get(i)).setBackground(Color.white);
        }
    }

    class SelectBtn extends JButton {
        public SelectBtn() {
            super("Select");
            this.addActionListener(new SelectBtn.SelectBtnAction());
        }

        class SelectBtnAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainCanvas.changeMouseMode(1);
                setBtnsToWhite();
                setBackground(Color.gray);
            }
        }
    }

    class ClassBtn extends JButton {
        public ClassBtn() {
            super("Class");
            this.addActionListener(new ClassBtnAction());
        }

        class ClassBtnAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainCanvas.changeMouseMode(5);
                setBtnsToWhite();
                setBackground(Color.gray);
            }
        }
    }

    class UseCaseBtn extends JButton {
        public UseCaseBtn() {
            super("Use Case");
            this.addActionListener(new UseCaseBtnAction());
        }

        class UseCaseBtnAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainCanvas.changeMouseMode(6);
                setBtnsToWhite();
                setBackground(Color.gray);
            }
        }
    }


}

