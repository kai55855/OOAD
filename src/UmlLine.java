import java.awt.*;

public abstract class UmlLine {
    protected UmlObject startObject, endObject;
    protected int startX, startY, endX, endY, startObjX, startObjY, endObjX, endObjY;
    public UmlLine(){
//        this.startObject = startObject;
//        this.endObject = endObject;
        setStartX(0);
        setStartY(0);
        setEndX(0);
        setEndY(0);
        setStartObjX(0);
        setStartObjY(0);
        setEndObjX(0);
        setEndObjY(0);
    }

    void setStartObjX(int startObjX){
        this.startObjX = startObjX;
    }

    void setStartObjY(int startObjY){
        this.startObjY = startObjY;
    }

    void setEndObjX(int endObjX){
        this.endObjX = endObjX;
    }

    void setEndObjY(int endObjY){
        this.endObjY = endObjY;
    }

    int getStartObjX(){
        return this.startObjX;
    }

    int getStartObjY(){
        return this.startObjY;
    }

    int getEndObjX(){
        return this.endObjX;
    }

    int getEndObjY(){
        return this.endObjY;
    }

    void setStartX(int startX){
        this.startX = startX;

    }

    int getStartX(){
        return this.startX;
    }

    void setStartY(int startY){
        this.startY = startY;
    }

    int getStartY(){
        return this.startY;
    }

    void setEndX(int endX){
        this.endX = endX;
    }

    int getEndX(){
        return this.endX;
    }

    void setEndY(int endY){
        this.endY = endY;
    }

    int getEndY(){
        return this.endY;
    }

    void setStartObject(UmlObject startObject){
        this.startObject = startObject;
        setStartObjX((this.startObject).getX());
        setStartObjY((this.startObject).getY());
    }

    void setEndObject(UmlObject endObject){
        this.endObject = endObject;
        setEndObjX((this.endObject).getX());
        setEndObjY((this.endObject).getY());
    }

    abstract Graphics2D draw(Graphics2D g2);

}
