public class UseCaseMode implements MouseMode {
    MainCanvas canvas;

    public UseCaseMode(MainCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(int x, int y) {
        UseCase useCaseObj = new UseCase(x, y, 0, "default");
        for (int i = 0; i < canvas.paintedObject.size(); i++) {
            if (useCaseObj.hit(canvas.paintedObject.get(i), canvas.g2)) {
                canvas.paintedObject.get(i).setDepth(canvas.paintedObject.get(i).getDepth() + 1);
            }
        }
        canvas.paintedObject.add(useCaseObj);
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
