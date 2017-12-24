public class CompositionLineMode implements MouseMode {
    MainCanvas canvas;
    boolean pressed = false;
    public CompositionLineMode(MainCanvas canvas){
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
//            canvas.compositionLine = new CompositionLine();
//            canvas.compositionLine.setStartObject(top);
//            canvas.compositionLine.setStartX(x);
//            canvas.compositionLine.setStartY(y);
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
//            canvas.compositionLine.setEndObject(top);
//            canvas.compositionLine.setEndX(x);
//            canvas.compositionLine.setEndY(y);
//            canvas.g2 = canvas.compositionLine.draw(canvas.g2);
//            canvas.repaint();
//            canvas.paintedLine.add(canvas.compositionLine);
//        }
    }
}
