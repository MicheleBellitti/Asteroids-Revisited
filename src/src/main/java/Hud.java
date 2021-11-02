import java.awt.*;

public class Hud {
    private  int i;
    static int HEALTH;
    public Hud(){
        HEALTH=255;
        i=0;

    }
    public  void tick(){
        HEALTH--;
        HEALTH=Game.clamp(HEALTH,1,255);
        i++;
    }
    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString("HP",275,40);
        g.drawRect(10,20,255,40);
       if(HEALTH>=255/2) g.setColor(Color.GREEN);
       else if(HEALTH>=255/5) g.setColor(Color.yellow.darker());
       else g.setColor(Color.red);
        g.fillRect(10,20,HEALTH,40);
        g.setColor(Color.WHITE);
        g.drawString("Level:"+ i/200,10,80);
        g.drawString("Score:"+ i,10,100);
    }
}

