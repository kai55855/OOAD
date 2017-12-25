public class CompositionLineMode implements MouseMode {
    MainCanvas canvas;
    private boolean isPressedObject;
    private Shape pressedObject, releaseObject;
    private Port beginPort, endPort;
    private int endPortNumber;
    public CompositionLineMode(MainCanvas canvas){
        this.canvas = canvas;
    }
    @Override
    public void mouseClicked(int x, int y) {

    }

    @Override
    public void mousePressed(int x, int y) {
        isPressedObject = false;
        pressedObject = canvas.findTopObject(x, y);
        if (pressedObject != null) {
            beginPort = pressedObject.getPort(x, y, canvas.g2);
            isPressedObject = true;
        }
    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {
        if (isPressedObject) {
            releaseObject = canvas.findTopObject(x, y);
            if (releaseObject != null && pressedObject != releaseObject) {
                endPort = releaseObject.getPort(x, y, canvas.g2);
                endPortNumber = releaseObject.getSelectedPortNumber();
                canvas.paintedObject.add(new CompositionLine(beginPort, endPort, endPortNumber));
                pressedObject.setSelected(true);
                releaseObject.setSelected(true);
                canvas.drawPaintedObject();
            }
        }
    }

    @Override
    public void group() {

    }

    @Override
    public void unGroup() {

    }
}
