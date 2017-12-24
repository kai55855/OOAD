public class GeneralizationLineMode implements MouseMode {
    MainCanvas canvas;
    boolean pressed = false;

    public GeneralizationLineMode(MainCanvas canvas){
        this.canvas = canvas;
    }
    @Override
    public void mouseClicked(int x, int y) {

    }

    @Override
    public void mousePressed(int x, int y) {
//        UmlObject top = canvas.findTopObject(x, y);
//        if (top != null) {
//            pressed = true;
//            top.setSelected(true);
//            canvas.g2 = top.draw(canvas.g2);
//            canvas.repaint();
//            System.out.printf("top painted\n");
//            canvas.generalizationLine = new GeneralizationLine();
//            canvas.generalizationLine.setStartObject(top);
//            canvas.generalizationLine.setStartX(x);
//            canvas.generalizationLine.setStartY(y);
//        }
    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {
//        if (!pressed)
//            return;
//        UmlObject top = canvas.findTopObject(x, y);
//        if (top != null) {
//            top.setSelected(true);
//            canvas.g2 = top.draw(canvas.g2);
//            canvas.repaint();
//            canvas.generalizationLine.setEndObject(top);
//            canvas.generalizationLine.setEndX(x);
//            canvas.generalizationLine.setEndY(y);
//            canvas.g2 = canvas.generalizationLine.draw(canvas.g2);
//            canvas.repaint();
//            canvas.paintedLine.add(canvas.generalizationLine);
//        }
    }
}
