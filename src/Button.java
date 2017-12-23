import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Button extends JButton {
    MainCanvas canvas;
    Vector umlBtn;
    public Button(MainCanvas canvas, Vector umlBtn, String name) {
        super(name);
        this.canvas = canvas;
        this.umlBtn = umlBtn;
        this.addActionListener(new Button.BtnAction());
        setMouseMode();
    }

    class BtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setMouseMode();
            for(int i = 0;i < umlBtn.size();i++){
                ((Button)umlBtn.get(i)).setWhite();
            }
            setBackground(Color.gray);
        }
    }

    public void setMouseMode() {
    }

    public void setWhite(){
        setBackground(Color.white);
    }
}
