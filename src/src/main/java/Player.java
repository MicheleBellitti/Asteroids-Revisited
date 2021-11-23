import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
public class Player extends GameObject{
   private static float HEIGHT=32;
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
        if (Game.color==Color.pink) {
            g.setColor(Color.black.darker());
            g.fill3DRect((int) x, (int) y, 32, 32, true);
        }
        if (Game.color==Color.black) {
            g.setColor(Color.white.darker());
            g.fill3DRect((int) x, (int) y, 32, 32, true);
        }
        if (Game.color==Color.white) {
            g.setColor(Color.black.darker());
            g.fill3DRect((int) x, (int) y, 32, 32, true);
        }
        if (Game.color==Color.blue) {
            g.setColor(Color.white.darker());
            g.fill3DRect((int) x, (int) y, 32, 32, true);
        }
        if (Game.color==Color.red) {
            g.setColor(Color.white.darker());
            g.fill3DRect((int) x, (int) y, 32, 32, true);
        }
    g.setColor(Color.BLACK);
        g.drawLine((int)x,(int)y,(int)x+width,(int)y+height);
    }
}
