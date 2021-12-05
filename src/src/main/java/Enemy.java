import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
private int height=32,width=32;
private SpriteSheet enemySprite=new SpriteSheet();
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
        x+=velX;
        y+=velY;
        if(x<=0 || x>=Game.WIDTH) velX*=-1;
        if(y<=0 || y>=Game.HEIGHT) velY*=-1;
    }
    @Override
    public void render(Graphics g) {
        BufferedImage transparentImg;
        if(this.height!=32 || this.width!=32){
            transparentImg=enemySprite.getImage("./src/src/main/resources/asteroids-arcade.png" ).getSubimage(64,256-64,64,64);
        }
        else transparentImg=enemySprite.getImage("./src/src/main/resources/asteroids-arcade.png" ).getSubimage(128,256-64,32,32);
        //g.setColor(Color.gray);
        //g.fillOval((int)x,(int)y,width,height);
        g.drawImage(transparentImg,(int)x,(int)y,null);
    }
}
