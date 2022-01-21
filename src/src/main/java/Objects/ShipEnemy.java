package Objects;

import Game.Game;
import Util.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ShipEnemy extends Enemy{
    public ShipEnemy(float x, float y, float vx, float vy, ID id) {
        super(x, y, vx, vy, id);
    }

    public void tick() {
        if( velY==0){

            velY=1.9f;




        }
        x+=velX;
        y+=velY;

    }

    @Override
    public void render(Graphics g) {
        BufferedImage transparentImg;
        if(velX > 0){
            transparentImg=enemySprite.getImage("asteroids-arcade.png" ).getSubimage(0,0,32,32);
        }
        else
            transparentImg=enemySprite.getImage("asteroids-arcade-upsidedown.png" ).getSubimage(256-32,256-32,32,32);
        g.drawImage(transparentImg,(int)x,(int)y,null);
    }

}
