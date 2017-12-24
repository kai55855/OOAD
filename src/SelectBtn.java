import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SelectBtn extends Button{
    public SelectBtn(MainCanvas canvas, Vector umlBtn) {
        super(canvas, umlBtn, "Select");
        setMouseMode();
    }



    public void setMouseMode() {
        this.canvas.setMouseMode(new SelectMode(this.canvas));
    }

}