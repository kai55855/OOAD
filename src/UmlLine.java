import java.awt.*;

public abstract class UmlLine {
    protected UmlObject startObject, endObject;
    protected int startX, startY, endX, endY;
    public UmlLine(){
//        this.startObject = startObject;
//        this.endObject = endObject;
        setStartX(0);
        setStartY(0);
        setEndX(0);
        setEndY(0);
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
    }

    void setEndObject(UmlObject endObject){
        this.endObject = endObject;
    }

    abstract Graphics2D draw(Graphics2D g2);
}
