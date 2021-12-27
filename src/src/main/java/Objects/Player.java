package Objects;

import Game.Game;
import Objects.GameObject;
import Util.SpriteSheet;

import java.awt.*;
import java.awt.image.*;

public class Player extends GameObject {
    private static float HEIGHT = 64;
    public SpriteSheet playerSprite = new SpriteSheet();
    BufferedImage transparentImg;

    public Player(float x, float y, float vx, float vy, ID id) {
        super(x, y, vx, vy, id);


    }


    @Override
    public void tick() {
        x += velX;
        y += velY;
        x = Game.clamp((int) x, 0, Game.getWIDTH() - 30);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 67);
    }

    @Override
    public void render(Graphics g) {
        //if (velY <= 0)
            transparentImg = playerSprite.getImage("asteroids-arcade.png").getSubimage(0, 64, 64, 64);

        if (Game.color == Color.pink) {

            g.drawImage(transparentImg, (int) x, (int) y, null);
        }
        if (Game.color == Color.black) {
            // g.setColor(Color.white.darker());
            // g.fill3DRect((int) x, (int) y, 32, 32, true);

            g.drawImage(transparentImg, (int) x, (int) y, null);

        }
        if (Game.color == Color.white) {
            g.drawImage(transparentImg, (int) x, (int) y, null);
        }
        if (Game.color == Color.blue) {

        }
    }
}
