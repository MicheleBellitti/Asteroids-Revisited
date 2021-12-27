package Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {
    private  BufferedImage img;
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

    public SpriteSheet (){
        this.img=null;
    }
public SpriteSheet (BufferedImage img){
    this.img=img;
}
public  BufferedImage getImage( String path){
    try {
        img = ImageIO.read(new File(path));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return img;
}
    public int getWidth(){
        return img.getWidth();
    }
    public int getHeight(){
        return img.getHeight();
    }
    public BufferedImage getSubimage(int x,int y,int w,int h){
        return img.getSubimage(x,y,w,h);
    }
    public   BufferedImage makeTransparentImage(BufferedImage br) {
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
}
