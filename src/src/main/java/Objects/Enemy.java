package Objects;

import Game.Game;
import Util.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Enemy extends GameObject {
private int height=32,width=32;
protected final SpriteSheet enemySprite=new SpriteSheet();
    public Enemy(float x, float y,float vx,float vy, ID id) {
        super(x, y,vx,vy,id);
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    @Override
    public void tick() {
        if(velX==0 && velY==0){
            velX++;
            velY=1.9f;




        }
        x+=velX;
        y+=velY;
        if(x<=0 || x>= Game.getWIDTH()) velX*=-1;
        if(y<=0 || y>= Game.getHEIGHT()) velY*=-1;
    }
    @Override
    public void render(Graphics g) {
        BufferedImage transparentImg;
        if(this.height!=32 || this.width!=32){
            transparentImg=enemySprite.getImage("asteroids-arcade.png" ).getSubimage(64,256-64,64,64);
        }
        else transparentImg=enemySprite.getImage("asteroids-arcade.png" ).getSubimage(128,256-64,32,32);

        g.drawImage(transparentImg,(int)x,(int)y,null);
    }
}
