package Objects;

import Game.Game;
import Objects.GameObject;

import java.awt.*;
public class Player2 extends GameObject {
    public Player2(float x, float y, float velx, float vely, ID id) {
        super(x, y, velx, vely, id);
    }
    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        if(x> Game.getWIDTH()) x= Game.WIDTH-1;
        if(x<0) x=0;
        if(y> Game.HEIGHT) y= Game.HEIGHT-1;
        if(y<0) y=0;
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int)y,32,32);
    }
}
