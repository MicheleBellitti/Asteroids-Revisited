import java.awt.*;

public class Player extends GameObject{
    public Player(float x, float y,float vx,float vy, ID id) {
        super(x,y,vx,vy,id);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        if(x>=Game.WIDTH) x=Game.WIDTH;
        if(x<=0) x=0;
        if(y>=Game.HEIGHT) y=Game.HEIGHT;
        if(y<=0) y=0;



    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x,(int)y,32,32);

    }
}
