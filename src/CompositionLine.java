import java.awt.*;

public class CompositionLine extends UmlLine {
    public CompositionLine() {
        super();
    }

//    @Override
    Graphics2D draw(Graphics2D g2) {
//        int start_offset_x = 0, start_offset_y = 0, end_offset_x = 0, end_offset_y = 0;
//        if (this.startObject.getX() != getStartObjX()) {
//            start_offset_x = this.startObject.getX() - getStartObjX();
//        }
//        if (this.startObject.getY() != getStartObjY()) {
//            start_offset_y = this.startObject.getY() - getStartObjY();
//        }
//        if (this.endObject.getX() != getEndObjX()) {
//            end_offset_x = this.endObject.getX() - getEndObjX();
//        }
//        if (this.endObject.getY() != getEndObjY()) {
//            end_offset_y = this.endObject.getY() - getEndObjY();
//        }
////        System.out.printf("start_offset_x = %d, start_offset_y = %d, end_offset_x = %d, end_offset_y = %d\n", start_offset_x, start_offset_y, end_offset_x, end_offset_y);
//        Point[] point;
//        point = this.startObject.linePoint(getStartX() + start_offset_x, getStartY() + start_offset_y, g2);
//        Point[] point2;
//        point2 = this.endObject.linePoint(getEndX() + end_offset_x, getEndY() + end_offset_y, g2);
//        if (point != null && point2 != null) {
//            g2.setColor(Color.black);
//            g2.drawLine(point[0].x, point[0].y, point2[1].x, point2[1].y);
//            //need to rewrite
//            if (point2[0].x == point2[1].x && point2[0].y != point2[1].y) {
//                System.out.printf("first case\n");
//                g2.drawLine(point2[1].x, point2[1].y, point2[1].x - 4, (point2[0].y + point2[1].y) / 2);
//                g2.drawLine(point2[1].x, point2[1].y, point2[1].x + 4, (point2[0].y + point2[1].y) / 2);
//                g2.drawLine(point2[0].x, point2[0].y, point2[1].x - 4, (point2[0].y + point2[1].y) / 2);
//                g2.drawLine(point2[0].x, point2[0].y, point2[1].x + 4, (point2[0].y + point2[1].y) / 2);
//            } else if (point2[0].x != point2[1].x && point2[0].y == point2[1].y) {
//                g2.drawLine(point2[1].x, point2[1].y, (point2[0].x + point2[1].x) / 2, point2[1].y + 4);
//                g2.drawLine(point2[1].x, point2[1].y, (point2[0].x + point2[1].x) / 2, point2[1].y - 4);
//                g2.drawLine(point2[0].x, point2[0].y, (point2[0].x + point2[1].x) / 2, point2[1].y + 4);
//                g2.drawLine(point2[0].x, point2[0].y, (point2[0].x + point2[1].x) / 2, point2[1].y - 4);
//            }
//            this.startObject.setLined(true);
//            this.endObject.setLined(true);
//        } else {
//            if (point == null)
//                System.out.printf("point is null\n");
//            if (point2 == null) {
//                System.out.printf("point2 is null\n");
//            }
//        }
        return g2;
    }
}
