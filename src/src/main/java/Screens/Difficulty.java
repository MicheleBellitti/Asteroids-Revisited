package Screens;

import Game.Game;

import java.awt.*;
public class Difficulty extends OptionPanel {
    private int type;
    public static boolean on;
    final String[] nomi= new String[3];
    final int[] x= new int[3];
    final int[] y= new int[3];
    final int[] width= new int[3];
    final int[] height= new int[3];
    public Difficulty() {
        x[0]=340;
        y[0]=150;
        width[0]=67;
        height[0]=50;
        nomi[0]="EASY";
        x[1]=332;
        y[1]=250;
        width[1]=85;
        height[1]=50;
        nomi[1]="MEDIUM";
        x[2]=342;
        y[2]=350;
        width[2]=67;
        height[2]=50;
        nomi[2]="HARD";
        on=false;
    }
    public void render(Graphics g){
        g.setColor(Color.green);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()* Game.WIDTH/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30*Game.WIDTH/786));
        g.drawString("ASTEROIDS",300*Game.WIDTH/786,75*Game.getHEIGHT()/563);
        g.setFont(font);
        g.fillRect(640*Game.WIDTH/786,500*Game.getHEIGHT()/563,65*Game.WIDTH/786,45*Game.getHEIGHT()/563);
        g.setColor(Color.black);
        g.drawString("BACK",655*Game.WIDTH/786,530*Game.getHEIGHT()/563);
        for(int i=0;i<3;i++){
            g.setColor(Color.green);
            g.fillRect(x[i]*Game.WIDTH/786,y[i]*Game.getHEIGHT()/563,width[i]*Game.WIDTH/786,height[i]*Game.getHEIGHT()/563);
            g.setColor(Color.black);
            g.drawString(nomi[i],(x[i]+15)*Game.WIDTH/786,(y[i]+30)*Game.getHEIGHT()/563);
        }
    }
}
