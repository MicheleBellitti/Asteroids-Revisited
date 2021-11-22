import java.awt.*;

public class Hud {
    private  int score;
    private  int level;
    private int kills;
    static int HEALTH;
    public Hud(){
      kills=0;
        HEALTH=255;
        score=0;
        level=1;

    }

    public int getScore() {
        return score;
    }
    public void setKills(int kills){this.kills=kills;}
public int getKills(){return kills;}
    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public  void tick(){

        HEALTH=Game.clamp(HEALTH,1,255);

        //score++;

    }
    public void render(Graphics g){
        if(Game.color ==Color.white){
            g.setColor(Color.black);
            g.drawString("HP",275,40);
            g.drawRect(10,20,255,40);
            if(HEALTH>=255/2) g.setColor(Color.GREEN);
            else if(HEALTH>=255/5) g.setColor(Color.yellow.darker());
            else g.setColor(Color.red);
            g.fillRect(10,20,HEALTH,40);
            g.setColor(Color.black); // Commento
            g.drawString("Level:"+ level,10,80);
            g.drawString("Score:"+ score,10,100);
            g.drawString("Kills:"+ kills,10,120);

        }
         else {
            g.setColor(Color.WHITE);
            g.drawString("HP", 275, 40);
            g.drawRect(10, 20, 255, 40);
            if (HEALTH >= 255 / 2) g.setColor(Color.GREEN);
            else if (HEALTH >= 255 / 5) g.setColor(Color.yellow.darker());
            else g.setColor(Color.red);
            g.fillRect(10, 20, HEALTH, 40);
            g.setColor(Color.WHITE); // Commento
            g.drawString("Level:" + level, 10, 80);
            g.drawString("Score:" + score, 10, 100);
            g.drawString("Kills:" + kills, 10, 120);
        }
    }
}

