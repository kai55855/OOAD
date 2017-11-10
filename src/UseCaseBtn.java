import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseCaseBtn extends JButton {

    public UseCaseBtn(){
        super("Use Case");
        this.addActionListener(new UseCaseBtnAction());

    }
    class UseCaseBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

}
