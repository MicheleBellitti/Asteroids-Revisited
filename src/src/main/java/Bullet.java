import java.awt.*;

public class Bullet extends GameObject{
    private int width,height;
    public Bullet(float x, float y, float velx, float vely, ID id) {
        super(x, y, velx, vely, id);
    }

    @Override
    public void tick() {
    x+=velX;
    y+=velY;
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int)y,7,7);
    }
}
