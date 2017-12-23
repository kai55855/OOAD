public class SelectMode implements MouseMode {
    MainCanvas canvas;

    public SelectMode(MainCanvas canvas) {
        super();
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(int x, int y) {
        System.out.println("this is select btn clicked");
        canvas.paintedObject.sort(new SortUmlObject());
        for (int i = canvas.paintedObject.size() - 1; i >= 0; i--) {
            System.out.printf("%d, ", ((UmlObject) canvas.paintedObject.get(i)).getDepth());
        }
        System.out.printf("\n");
//        for (int i = canvas.paintedObject.size() - 1; i >= 0; i--) {
////                if (((UmlObject) paintedObject.get(i)).getLined() || ((UmlObject) paintedObject.get(i)).clicked(x, y, g2)) {
//            if (((UmlObject) canvas.paintedObject.get(i)).clicked(x, y, canvas.g2))
//                ((UmlObject) canvas.paintedObject.get(i)).setSelected(true);
//            else {
//                ((UmlObject) canvas.paintedObject.get(i)).setSelected(false);
//            }
//        }

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
}
