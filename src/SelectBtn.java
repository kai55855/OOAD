import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectBtn extends JButton{
    MainCanvas canvas;
    public SelectBtn(MainCanvas canvas) {
        super("Select");
        this.canvas = canvas;
        this.addActionListener(new SelectBtn.SelectBtnAction());
    }

    class SelectBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            mainCanvas.changeMouseMode(1);
//            setBtnsToWhite();
            setMouseMode();
            setBackground(Color.gray);
        }
    }

    public void setMouseMode() {
        this.canvas.setMouseMode(new SelectMode(this.canvas));
    }

}
