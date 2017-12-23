import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CompositionLineBtn extends Button {

    public CompositionLineBtn(MainCanvas canvas, Vector umlBtn) {
        super(canvas, umlBtn, "Composition Line");
        setMouseMode();
    }

    public void setMouseMode() {
        this.canvas.setMouseMode(new CompositionLineMode(this.canvas));
    }
}
