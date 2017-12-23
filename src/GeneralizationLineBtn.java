import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GeneralizationLineBtn extends Button {

    public GeneralizationLineBtn(MainCanvas canvas, Vector umlBtn) {
        super(canvas, umlBtn, "Generalization Line");
        setMouseMode();
    }

    public void setMouseMode() {
        this.canvas.setMouseMode(new GeneralizationLineMode(this.canvas));
    }
}
