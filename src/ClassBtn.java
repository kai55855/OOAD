import javax.swing.*;

public class ClassBtn extends JButton implements MouseClick {
    @Override
    public void mouseClick() {
        System.out.println("this is btn class\n");
    }
}
