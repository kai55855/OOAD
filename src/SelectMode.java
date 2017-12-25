public class SelectMode implements MouseMode {
    private MainCanvas canvas;
    private boolean isPressedObject, isDraggedObject;
    private Shape pressedObject;
    private int pressedX, pressedY;

    public SelectMode(MainCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(int x, int y) {
        for (int i = canvas.paintedObject.size() - 1; i >= 0; i--) {
            if (canvas.paintedObject.get(i).clicked(x, y, canvas.g2)) {
                canvas.paintedObject.get(i).setSelected(true);
            } else {
                canvas.paintedObject.get(i).setSelected(false);
            }
        }
        canvas.drawPaintedObject();
    }

    @Override
    public void mousePressed(int x, int y) {
        isPressedObject = false;
        isDraggedObject = false;
        pressedObject = canvas.findTopObject(x, y);
        if (pressedObject != null) {
            isPressedObject = true;
            canvas.setSelected(pressedObject, true);
            pressedObject.setLastX(x);
            pressedObject.setLastY(y);
        }
        //if not pressed object, 代表是框取物件
        else {
            pressedX = x;
            pressedY = y;
        }
    }

    @Override
    public void mouseDragged(int x, int y) {
        if (isPressedObject) {
            pressedObject.move(x, y);
            canvas.drawPaintedObject();
            isDraggedObject = true;
            pressedObject.setLastX(x);
            pressedObject.setLastY(y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        if (isPressedObject && isDraggedObject) {
            pressedObject.move(x, y);
            //這邊可以寫是否要把覆蓋到的物件壓到下一層
            canvas.drawPaintedObject();
        } else {
            for (int i = 0; i < canvas.paintedObject.size(); i++) {
                if (canvas.paintedObject.get(i).isCovered(pressedX, pressedY, x, y)) {
                    canvas.paintedObject.get(i).setSelected(true);
                }
            }
            canvas.drawPaintedObject();
        }
    }

    @Override
    public void group() {
        Shape group = new GroupObject();
        for (int i = 0; i < canvas.paintedObject.size(); i++) {
            if (canvas.paintedObject.get(i).getSelected()) {
                group.addGroup(canvas.paintedObject.get(i));
                canvas.paintedObject.remove(i);
                i--;
            }
        }
        canvas.paintedObject.add(group);
        canvas.drawPaintedObject();
    }

    @Override
    public void unGroup() {
        for (int i = 0; i < canvas.paintedObject.size(); i++) {
            if (canvas.paintedObject.get(i).getSelected()) {
                if (canvas.paintedObject.get(i).unGroup(canvas.paintedObject)) {
                    canvas.paintedObject.remove(i);
                }
            }
        }
        canvas.drawPaintedObject();
    }
}
