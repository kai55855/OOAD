import java.awt.*;

public class Port {
    int x, y;
    Rectangle port;
    public Port(int x, int y){
        setX(x);
        setY(y);
        port = new Rectangle(getX(), getY(), 8, 8);
    }
    void setX(int x) {
        this.x = x;
    }

    int getX() {
        return this.x;
    }

    void setY(int y) {
        this.y = y;
    }

    int getY() {
        return this.y;
    }

    Graphics2D draw(Graphics2D g2){
        g2.fill(port);
        return g2;
    }

    void move(int x, int y){
        setX(x);
        setY(y);
        port = new Rectangle(getX(), getY(), 8, 8);
    }
}
