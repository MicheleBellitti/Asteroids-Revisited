import java.awt.*;

public class Enemy extends GameObject {
private int height=16,width=16;
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
        g.setColor(Color.red);
        g.fillOval((int)x,(int)y,width,height);
    }
}
