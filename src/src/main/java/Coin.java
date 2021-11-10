import java.awt.*;

public class Coin extends GameObject{
    private int scorePoints;

    public Coin(float x, float y, float velx, float vely, ID id) {
        super(x, y, velx, vely, id);
        width=15;
        height=15;
        scorePoints=150;

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.drawOval((int)x,(int)y,width+1,height+1);
        g.fillOval((int)x,(int)y,width,height);
    }
}
