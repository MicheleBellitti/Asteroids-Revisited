package Objects;

import Game.Game;
import Objects.GameObject;
import Objects.ID;
import Util.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject {
    private final int width=7;
    private final int height=7;
    private final SpriteSheet bulletSprite=new SpriteSheet();
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
        return "Objects.Bullet{" +
                "x=" + x +
                ", y=" + y +
                "" +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
    @Override
    public void render(Graphics g) {
        BufferedImage transparentImg=bulletSprite.getImage("asteroids-arcade.png" ).getSubimage(192,64,32,32);

            g.drawImage(transparentImg,(int)x,(int)y,null);
    }
}
