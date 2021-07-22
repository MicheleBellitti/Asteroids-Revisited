import java.awt.*;

public class Enemy extends GameObject {

    public Enemy(float x, float y,float vx,float vy, ID id) {
        super(x, y,vx,vy,id);

    }
    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        if(x<=0 || x>=Game.WIDTH) velX*=-1;
        if(y<=0 || y>=Game.HEIGHT) velY*=-1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int)x,(int)y,16,16);
    }
}
