import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends GameObject{
   private static float HEIGHT=32;
   public static SpriteSheet playerSprite=new SpriteSheet();


    public Player(float x, float y,float vx,float vy, ID id) {
        super(x,y,vx,vy,id);
        Player.playerSprite.getImage("./src/src/main/resources/test3.png");

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

        BufferedImage transparentImg=SpriteSheet.makeTransparentImage(playerSprite.getSubimage(0,0,playerSprite.getWidth()/6,32));
        if (Game.color==Color.pink) {
            g.setColor(Color.black.darker());
            g.fill3DRect((int) x, (int) y, 32, 32, true);
        }
        if (Game.color==Color.black) {
           // g.setColor(Color.white.darker());
           // g.fill3DRect((int) x, (int) y, 32, 32, true);

            g.drawImage(transparentImg,(int)x,(int)y,null);

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

    }
}
