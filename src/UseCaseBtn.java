import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UseCaseBtn extends Button {
    public UseCaseBtn(MainCanvas canvas, Vector umlBtn) {
        super(canvas, umlBtn, "Use Case");
        setMouseMode();
    }

    public void setMouseMode() {
        this.canvas.setMouseMode(new UseCaseMode(this.canvas));
    }
}
