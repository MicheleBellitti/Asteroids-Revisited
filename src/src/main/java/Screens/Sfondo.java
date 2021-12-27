package Screens;

import Game.Game;
import Screens.OptionPanel;

import java.awt.*;
public class Sfondo  extends OptionPanel {
    String[] sfo=new String[3];
    Color[] colors= new Color[3];
    int[] x= new int[3];
    int[] y= new int[3];
    int[] width= new int[3];
    int[] height= new int[3];
    public static boolean on;
    public Sfondo() {
       sfo[0]="SFONDO 2";
       sfo[1]="SFONDO 3";
       sfo[2]="SFONDO 1";
       colors[0]=Color.PINK;
       colors[1]=Color.BLUE;
       colors[2]=Color.white;

        x[0] = 330;
        y[0]= 250;
        width[0]=100;
        height[0]=50;
        x[1] = 333;
        y[1]=350;
        width[1]=100;
        height[1]=50;
        x[2] = 342;
        y[2]=150;
        width[2]=75;
        height[2]=50;
        on=false;
    }
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()* Game.WIDTH/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30* Game.WIDTH/786));
        g.drawString("ASTEROIDS",300* Game.getWIDTH()/786,75* Game.HEIGHT/563);
        g.setFont(font);
        g.fillRect(640* Game.WIDTH/786,500* Game.HEIGHT/563,65* Game.WIDTH/786,45* Game.HEIGHT/563);
        g.setColor(Color.black);
        g.drawString("BACK",655* Game.WIDTH/786,530* Game.HEIGHT/563);
        for(int i=0;i<3;i++){
            g.setColor(colors[i]);
            g.fillRect(x[i]* Game.WIDTH/786,y[i]* Game.HEIGHT/563,width[i]* Game.WIDTH/786,height[i]* Game.HEIGHT/563);
            g.setColor(Color.BLACK);
            g.drawString(sfo[i],(x[i]+15)* Game.WIDTH/786,(y[i]+30)* Game.HEIGHT/563);
        }

    }
}
