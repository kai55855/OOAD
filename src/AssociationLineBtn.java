import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AssociationLineBtn extends Button {
    public AssociationLineBtn(MainCanvas canvas, Vector umlBtn) {
        super(canvas, umlBtn, "Association Line");
        setMouseMode();
    }

    public void setMouseMode() {
        this.canvas.setMouseMode(new AssociationLineMode(this.canvas));
    }
}
