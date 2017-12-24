public class AssociationLineMode implements MouseMode {
    MainCanvas canvas;
    boolean pressed = false;

    public AssociationLineMode(MainCanvas canvas){
        this.canvas = canvas;
    }
    @Override
    public void mouseClicked(int x, int y) {

    }

    @Override
    public void mousePressed(int x, int y) {
//        pressed = false;
////            System.out.printf("line pressed\n");
//        UmlObject top = canvas.findTopObject(x, y);
//        if (top == null)
//            System.out.printf("line mouse pressed top == null\n");
//        if (top != null) {
//            pressed = true;
//            top.setSelected(true);
//            canvas.g2 = top.draw(canvas.g2);
//            canvas.repaint();
////                System.out.printf("top painted\n");
//            canvas.associationLine = new AssociationLine();
//            canvas.associationLine.setStartObject(top);
//            canvas.associationLine.setStartX(x);
//            canvas.associationLine.setStartY(y);
//        }
    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {
//        if (!pressed) {
//            return;
//        }
////            System.out.printf("line release\n");
//        UmlObject top = canvas.findTopObject(x, y);
//        if (top != null) {
//            top.setSelected(true);
//            canvas.g2 = top.draw(canvas.g2);
//            canvas.repaint();
//            System.out.printf("top painted\n");
//            canvas.associationLine.setEndObject(top);
//            canvas.associationLine.setEndX(x);
//            canvas.associationLine.setEndY(y);
//            canvas.g2 = canvas.associationLine.draw(canvas.g2);
//            canvas.repaint();
//            canvas.paintedLine.add(canvas.associationLine);
//        }
    }
}
