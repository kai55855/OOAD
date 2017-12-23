public class UseCaseMode implements MouseMode {
    MainCanvas canvas;
    public UseCaseMode(MainCanvas canvas){
        this.canvas = canvas;
    }
    @Override
    public void mouseClicked(int x, int y) {
        System.out.println("this is use case btn clicked");
        UseCaseObject useCaseObject = new UseCaseObject(x, y, 0);
        for (int i = 0; i < canvas.paintedObject.size(); i++) {
            if (useCaseObject.hit((UmlObject) canvas.paintedObject.get(i), canvas.g2)) {
                ((UmlObject) canvas.paintedObject.get(i)).setDepth(((UmlObject) canvas.paintedObject.get(i)).getDepth() + 1);
            }
        }
        canvas.paintedObject.add(useCaseObject);
        canvas.g2 = useCaseObject.draw(canvas.g2);
        canvas.repaint();
    }

    @Override
    public void mousePressed(int x, int y) {
//            System.out.println("this is class btn pressed");

    }

    @Override
    public void mouseDragged(int x, int y) {
//            System.out.println("this is class btn dragged");

    }

    @Override
    public void mouseReleased(int x, int y) {

    }
}
