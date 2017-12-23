public class SelectMode implements MouseMode {
    MainCanvas canvas;
    int clicked = 0;
    int pressed = 0;
    int dragged = 0;

    public SelectMode(MainCanvas canvas) {
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
        for (int i = canvas.paintedObject.size() - 1; i >= 0; i--) {
//                if (((UmlObject) paintedObject.get(i)).getLined() || ((UmlObject) paintedObject.get(i)).clicked(x, y, g2)) {
            if (((UmlObject) canvas.paintedObject.get(i)).clicked(x, y, canvas.g2))
                ((UmlObject) canvas.paintedObject.get(i)).setSelected(true);
            else {
                ((UmlObject) canvas.paintedObject.get(i)).setSelected(false);
            }
        }

        canvas.drawPaintedObject();
    }

    @Override
    public void mousePressed(int x, int y) {
//            System.out.println("this is select btn pressed");
        pressed = 0;
        dragged = 0;
        canvas.prevUMLObject = canvas.findTopObject(x, y);
//            paintedObject.remove(prevUMLObject);
        if (canvas.prevUMLObject != null)
            pressed = 1;
        else {
            canvas.pressedX = x;
            canvas.pressedY = y;
        }
    }

    @Override
    public void mouseDragged(int x, int y) {
        if (pressed > 0) {
//                paintedObject.remove(prevUMLObject);
            canvas.clear();
            canvas.prevUMLObject.move(x, y);
            //paintedObject.add(prevUMLObject);
            canvas.drawPaintedObject();
            dragged = 1;
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
//            System.out.println("this is select btn released");
        if (dragged > 0 && pressed > 0) {
//                paintedObject.remove(prevUMLObject);
            canvas.clear();
            canvas.prevUMLObject.move(x, y);
            for (int i = 0; i < canvas.paintedObject.size(); i++) {
                if (canvas.prevUMLObject != (UmlObject) canvas.paintedObject.get(i) && canvas.prevUMLObject.getDepth() >= ((UmlObject) canvas.paintedObject.get(i)).getDepth() && canvas.prevUMLObject.hit((UmlObject) canvas.paintedObject.get(i), canvas.g2)) {
                    ((UmlObject) canvas.paintedObject.get(i)).setDepth(((UmlObject) canvas.paintedObject.get(i)).getDepth() + 1);
                }
            }
//                paintedObject.add(prevUMLObject);
            canvas.drawPaintedObject();
        } else {
            int releasedX = x, releasedY = y;
            for (int i = 0; i < canvas.paintedObject.size(); i++) {
//                    if(!((UmlObject)paintedObject.get(i)).getLined()){
                ((UmlObject) canvas.paintedObject.get(i)).setSelected(false);
//                    }
            }
            canvas.drawPaintedObject();
            for (int i = 0; i < canvas.paintedObject.size(); i++) {
                int objX, objY, objW, objH;
                objX = ((UmlObject) canvas.paintedObject.get(i)).getX();
                objY = ((UmlObject) canvas.paintedObject.get(i)).getY();
                objW = ((UmlObject) canvas.paintedObject.get(i)).getWidth();
                objH = ((UmlObject) canvas.paintedObject.get(i)).getHeight();
                if ((objX >= canvas.pressedX && objX <= releasedX) || (objX <= canvas.pressedX && objX >= releasedX)) {
                    if ((objY >= canvas.pressedY && objY <= releasedY) || (objY <= canvas.pressedY && objY >= releasedY)) {
                        if ((objX + objW >= canvas.pressedX && objX + objW <= releasedX) || (objX + objW <= canvas.pressedX && objX + objW >= releasedX)) {
                            if ((objY + objH >= canvas.pressedY && objY + objH <= releasedY) || (objY + objH <= canvas.pressedY && objY + objH >= releasedY)) {
                                ((UmlObject) canvas.paintedObject.get(i)).setSelected(true);
                                System.out.printf("pressedX = %d, pressedY = %d\n", canvas.pressedX, canvas.pressedY);
                            }
                        }
                    }
                }
            }
            canvas.drawPaintedObject();
        }
    }
}
