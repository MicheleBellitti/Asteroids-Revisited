package Screens;

import Game.Game;

import java.awt.*;

public class GamePause extends OptionPanel {
    public static boolean on;
    public static boolean pause;
    final int[] x = new int[3];
    final int[] width = new int[3];
    final int[] height = new int[3];
    final int[] y = new int[3];
    final String[] nomi=new String[3];
    public GamePause(){
        x[0] = 330;
        y[0]= 250;
        width[0]=100;
        height[0]=50;
        nomi[0]="RESUME";
        x[1] = 333;
        y[1]=350;
        width[1]=100;
        height[1]=50;
        nomi[1]="QUIT";
        x[2] = 342;
        y[2]=150;
        width[2]=75;
        height[2]=50;
       nomi[2]="OPTIONS";
        on=false;
        pause=false;
    }
   public void render(Graphics g){
        g.setColor(Color.red);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()* Game.WIDTH/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30*Game.getWIDTH()/784));
        g.drawString("ASTEROIDS",300*Game.getWIDTH()/784,75* Game.getHEIGHT()/561);
        g.setFont(font);
        for(int i=0;i<3;i++){
            g.setColor(Color.red);
            g.fillRect(x[i]*Game.getWIDTH()/786,y[i]* Game.getHEIGHT()/563,width[i]*Game.getWIDTH()/786,height[i]* Game.getHEIGHT()/563);
            g.setColor(Color.BLACK);
            g.drawString(nomi[i],(x[i]+15)* Game.getWIDTH()/786,(y[i]+30)* Game.getHEIGHT()/563);

        }
    }
}
