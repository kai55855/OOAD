import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ClassBtn extends Button {
    public ClassBtn(MainCanvas canvas, Vector umlBtn) {
        super(canvas, umlBtn, "Class");
        setMouseMode();
    }

    public void setMouseMode() {
        this.canvas.setMouseMode(new ClassMode(this.canvas));
    }
}
