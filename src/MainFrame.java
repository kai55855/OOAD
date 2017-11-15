

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

public class MainFrame extends JFrame {
    static JLabel stateText = new JLabel("游標位置 :");
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenuItem editItem = new JMenuItem("Change object name");
    JMenuItem editItem2 = new JMenuItem("Group");
    JMenuItem editItem3 = new JMenuItem("UnGroup");
    JMenuBar menubar = new JMenuBar();

    JPanel controlPanel = new JPanel(new GridLayout(6, 1));

    MainCanvas mainCanvas = new MainCanvas();
    Vector umlBtn = new Vector();
    SelectBtn selectBtn = new SelectBtn();
    UseCaseBtn useCaseBtn = new UseCaseBtn();
    ClassBtn classBtn = new ClassBtn();
    AssociationLineBtn associationBtn = new AssociationLineBtn();
    GeneralizationLineBtn generalizationBtn = new GeneralizationLineBtn();
    CompositionLineBtn compositionBtn = new CompositionLineBtn();


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
        edit.add(editItem);
        editItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = JOptionPane.showInputDialog(null, "請輸入:", "輸入對話框", JOptionPane.QUESTION_MESSAGE);
                        mainCanvas.changeObjectName(name);
                    }
                }
        );
        edit.addSeparator();
        edit.add(editItem2);
        editItem2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainCanvas.groupObject();
                    }
                }
        );
        edit.addSeparator();
        edit.add(editItem3);

        file.setPopupMenuVisible(true);
        edit.setPopupMenuVisible(true);
        menubar.add(file);
        menubar.add(edit);
        this.setJMenuBar(menubar);
        //control plane
        umlBtn.add(selectBtn);
        umlBtn.add(useCaseBtn);
        umlBtn.add(classBtn);
        umlBtn.add(associationBtn);
        umlBtn.add(generalizationBtn);
        umlBtn.add(compositionBtn);
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
            ((JButton) umlBtn.get(i)).setBackground(Color.white);
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

    class AssociationLineBtn extends JButton {
        public AssociationLineBtn() {
            super("Association Line");
            this.addActionListener(new AssociationLineBtn.AssociationLineBtnAction());
        }

        class AssociationLineBtnAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainCanvas.changeMouseMode(2);
                setBtnsToWhite();
                setBackground(Color.gray);
            }
        }
    }

    class GeneralizationLineBtn extends JButton {
        public GeneralizationLineBtn() {
            super("Generalization Line");
            this.addActionListener(new GeneralizationLineBtn.GeneralizationLineBtnAction());
        }

        class GeneralizationLineBtnAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainCanvas.changeMouseMode(3);
                setBtnsToWhite();
                setBackground(Color.gray);
            }
        }
    }

    class CompositionLineBtn extends JButton {
        public CompositionLineBtn() {
            super("Composition Line");
            this.addActionListener(new CompositionLineBtn.CompositionLIneBtnAction());
        }

        class CompositionLIneBtnAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainCanvas.changeMouseMode(4);
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

