import java.awt.*;

public class AssociationLine extends UmlLine {
    public AssociationLine(){
        super();
    }

    @Override
    Graphics2D draw(Graphics2D g2) {
        Point[] point;
        point = this.startObject.linePoint(startX, startY, g2);
        System.out.printf("after find first top\n");
        Point[] point2;
        point2 = this.endObject.linePoint(endX, endY, g2);
        System.out.printf("after find sec top\n");
        if (point != null && point2 != null) {
            g2.drawLine(point[0].x, point[0].y, point2[0].x, point2[0].y);
        }
        else{
            if(point == null)
                System.out.printf("point is null\n");
            if(point2 == null){
                System.out.printf("point2 is null\n");
            }
        }
        return g2;
    }
}
