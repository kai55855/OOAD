import java.awt.*;

public class GeneralizationLine extends LineObject {
    int endPortNumber;
    public GeneralizationLine(Port beginPort, Port endPort, int endPortNumber) {
        super(beginPort, endPort);
        this.endPortNumber = endPortNumber;
    }

    //    @Override
    Graphics2D draw(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.drawLine(getBeginPort().x, getBeginPort().y, getEndPort().x, getEndPort().y);

        if(endPortNumber == 1){
            int polygonX[] = {getEndPort().x, getEndPort().x - 5, getEndPort().x + 5};
            int polygonY[] = {getEndPort().y, getEndPort().y - 5, getEndPort().y - 5};
            g2.drawPolygon(polygonX, polygonY, 3);

        }
        else if(endPortNumber == 2){
            int polygonX[] = {getEndPort().x, getEndPort().x - 5, getEndPort().x - 5};
            int polygonY[] = {getEndPort().y, getEndPort().y - 5, getEndPort().y + 5};
            g2.drawPolygon(polygonX, polygonY, 3);

        }
        else if(endPortNumber == 3){
            int polygonX[] = {getEndPort().x, getEndPort().x - 5, getEndPort().x + 5};
            int polygonY[] = {getEndPort().y + 5, getEndPort().y + 10, getEndPort().y + 10};
            g2.drawPolygon(polygonX, polygonY, 3);
        }
        else if(endPortNumber == 4){
            int polygonX[] = {getEndPort().x + 5, getEndPort().x + 10, getEndPort().x + 10};
            int polygonY[] = {getEndPort().y, getEndPort().y - 5, getEndPort().y + 5};
            g2.drawPolygon(polygonX, polygonY, 3);
        }
        return g2;
    }
}
