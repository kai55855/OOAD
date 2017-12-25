import java.awt.*;


public class AssociationLine extends LineObject {
    public AssociationLine(Port beginPort, Port endPort) {
        super(beginPort, endPort);
    }

    @Override
    Graphics2D draw(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.drawLine(getBeginPort().x, getBeginPort().y, getEndPort().x, getEndPort().y);
        return g2;
    }


}
