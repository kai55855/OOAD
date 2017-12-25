public class ClassMode implements MouseMode {
    MainCanvas canvas;

    public ClassMode(MainCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(int x, int y) {
        Class classObj = new Class(x, y, 0, "default");
        for (int i = 0; i < canvas.paintedObject.size(); i++) {
            if (classObj.hit(canvas.paintedObject.get(i), canvas.g2)) {
                canvas.paintedObject.get(i).setDepth(canvas.paintedObject.get(i).getDepth() + 1);
            }
        }
        canvas.paintedObject.add(classObj);
        canvas.drawPaintedObject();
    }

    @Override
    public void mousePressed(int x, int y) {
    }

    @Override
    public void mouseDragged(int x, int y) {
    }

    @Override
    public void mouseReleased(int x, int y) {
    }

    @Override
    public void group() {

    }

    @Override
    public void unGroup() {

    }
}
