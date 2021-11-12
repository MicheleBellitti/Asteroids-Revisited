import java.awt.*;

public class Bullet extends GameObject{
    private int width=7;
    private  int height=7;
    public Bullet(float x, float y, float velx, float vely, ID id) {
        super(x, y, velx, vely, id);
    }

    @Override
    public void tick() {
    x+=velX;
    y+=velY;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "x=" + x +
                ", y=" + y +
                "" +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int)y,width,height);
    }
}
