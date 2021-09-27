import java.awt.*;

public class Player extends GameObject{
    public Player(float x, float y,float vx,float vy, ID id) {
        super(x,y,vx,vy,id);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        x=Game.clamp((int)x,0,Game.WIDTH-30);
        y=Game.clamp((int)y,0,Game.HEIGHT-67);



    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x,(int)y,32,32);


    }
}
