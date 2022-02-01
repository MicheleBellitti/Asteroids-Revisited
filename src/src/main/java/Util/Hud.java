package Util;

import Game.Game;

import java.awt.*;
public class Hud {
    private  int score;
    private  int level;
    private int kills;
    static int HEALTH;
    public Hud(){
      kills = 0;
      HEALTH = 255;
      score = 0;
      level = 1;
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
        HEALTH=Game.clamp(HEALTH,0,255);
    }
    public void render(Graphics g){
        if(Game.color ==Color.white){
            g.setColor(Color.black);
            g.drawString("HP",275*Game.WIDTH/784,40*Game.getHEIGHT()/571);
            g.drawRect(10*Game.WIDTH/784,20*Game.getHEIGHT()/571,255*Game.WIDTH/784,40*Game.getHEIGHT()/571);
            if(HEALTH>=255*Game.WIDTH/784/2) g.setColor(Color.GREEN);
            else if(HEALTH>=255*Game.WIDTH/784/5) g.setColor(Color.yellow.darker());
            else g.setColor(Color.red);
            g.fillRect(10*Game.WIDTH/784,20*Game.getHEIGHT()/571,HEALTH*Game.WIDTH/784,40*Game.getHEIGHT()/571);
            g.setColor(Color.black);
        }
         else {
            g.setColor(Color.WHITE);
            g.drawString("HP", 275*Game.WIDTH/784, 40*Game.getHEIGHT()/571);
            g.drawRect(10*Game.WIDTH/784, 20*Game.getHEIGHT()/571, 255*Game.WIDTH/784, 40*Game.getHEIGHT()/571);
            if (HEALTH >= (255*Game.WIDTH/784)/ 2) g.setColor(Color.GREEN);
            else if (HEALTH >= (255*Game.WIDTH/784) / 5) g.setColor(Color.yellow.darker());
            else g.setColor(Color.red);
            g.fillRect(10*Game.WIDTH/784, 20*Game.getHEIGHT()/571, HEALTH*Game.WIDTH/784, 40*Game.getHEIGHT()/571);
            g.setColor(Color.WHITE); // Commento
        }
        g.drawString("Level:"+ level,10*Game.WIDTH/784,80*Game.getHEIGHT()/571);
        g.drawString("Score:"+ score,10*Game.WIDTH/784,100*Game.getHEIGHT()/571);
        g.drawString("Kills:"+ kills,10*Game.WIDTH/784,120*Game.getHEIGHT()/571);
    }

    public int getHEALTH() {
        return HEALTH;
    }

    public static void setHEALTH(int health) {
        HEALTH=health;
    }
}

