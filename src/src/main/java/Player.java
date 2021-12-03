import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends GameObject{
   private static float HEIGHT=32;
    public static BufferedImage img;

    {
        try {
            img = ImageIO.read(new File("./src/src/main/resources/test3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player(float x, float y,float vx,float vy, ID id) {
        super(x,y,vx,vy,id);
    }
    ImageFilter filter = new RGBImageFilter() {
        int transparentColor = Color.white.getRGB() | 0xFF000000;

        public final int filterRGB(int x, int y, int rgb) {
            if ((rgb | 0xFF000000) == transparentColor) {
                return 0x00FFFFFF & rgb;
            } else {
                return rgb;
            }
        }
    };


    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        x=Game.clamp((int)x,0,Game.WIDTH-30);
        y=Game.clamp((int)y,0,Game.HEIGHT-67);
    }
    public static  BufferedImage makeTransparentImage(BufferedImage br) {
        for (int i = 0; i < br.getHeight(); i++) {
            for (int j = 0; j < br.getWidth(); j++) {
                Color c = new Color(br.getRGB(j, i));
                int r = c.getRed();
                int b = c.getBlue();
                int g = c.getGreen();
                if ((r == 255 && b == 255 && g == 255)) {
                    System.out.println("r g b " + r + g + b);
                    br.setRGB(j, i, 0xFF000000);
                }
            }
        }
        return br;
    }
    @Override
    public void render(Graphics g) {

        BufferedImage transparentImg=makeTransparentImage(img.getSubimage(0,0,img.getWidth()/6,32));
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
