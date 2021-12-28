package Screens;

import Game.Game;
import Objects.ID;

import java.awt.*;
public class StartMenu  {
    //private String[] checking = new String[3];
    final int[] x = new int[4];
    final int[] y = new int[4];
    final int[] width = new int[4];
    final int[] height = new int[4];
    final String [] nomi= new String[4];
    ID StartMenu;
    public static boolean on;
    public StartMenu() {
        nomi[0]="PLAY";
        nomi[1]="LEADERBOARD";
        nomi[2]="OPTIONS";
        nomi[3]="BACK";
        ID StartMenu;
        x[0]= 325;
        y[0]= 150;
        width[0] = 100;
        height[0] = 50;
        x[1]= 300;
        y[1]= 275;
        width[1] = 158;
        height[1] = 53;
        x[2]= 320;
        y[2]= 400;
        width[2] = 120;
        height[2] = 50;
        on=true;
    }
    public void render(Graphics g) {
        g.setColor(Color.red);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()* Game.getWIDTH()/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30* Game.getHEIGHT()/563));
        g.drawString("ASTEROIDS",300* Game.getWIDTH()/786,75* Game.getHEIGHT()/600);
        g.setFont(font);
         for(int i=0;i<4;i++) {
          g.setColor(Color.red);

          g.fill3DRect(x[i]* Game.getWIDTH()/786, y[i]* Game.getHEIGHT()/600, width[i]* Game.getWIDTH()/786, height[i]* Game.getHEIGHT()/600,true);
          g.setColor(Color.BLACK);
          g.drawString(nomi[i],(x[i]+33)* Game.getWIDTH()/786,(y[i]+30)* Game.getHEIGHT()/600);
      }
         g.setFont(font);
    }
}



