package Screens;

import Game.Game;

import java.awt.*;
public class OptionPanel extends StartMenu {
    public static boolean on;
    final int[] x= new int[5];
    final int[] y= new int[5];
    final int[] width= new int[5];
    final int[] height= new int[5];
    final String[] nomi= new String[5];
    public OptionPanel() {
        nomi[0]="SFONDO";
        nomi[1]="CONTROLS";
        nomi[2]="DIFFICULTY'";
        nomi[3]="SOUND";
        nomi[4]="BACK";
        x[0] = 330;
        y[0]= 250;
        width[0]=100;
        height[0]=50;
        x[1] = 333;
        y[1]=350;
        width[1]=100;
        height[1]=50;
        x[2] = 330;
        y[2]=150;
        width[2]=104;
        height[2]=50;
        x[3] = 343;
        y[3]=450;
        width[3]=83;
        height[3]=50;
        x[4]=640;
        y[4]=500;
        width[4]=65;
        height[4]=45;
        on=false;
    }
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()* Game.WIDTH/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30* Game.WIDTH/786));
        g.drawString("ASTEROIDS",300* Game.getWIDTH()/786,75* Game.HEIGHT/563);
        g.setFont(font);
        for(int i=0;i<5;i++){
            g.setColor(Color.YELLOW);
            g.fillRect(x[i]* Game.WIDTH/786,y[i]* Game.HEIGHT/563,width[i]* Game.WIDTH/786,height[i]* Game.HEIGHT/563);
            g.setColor(Color.BLACK);
            g.drawString(nomi[i],(x[i]+15)* Game.WIDTH/786,(y[i]+30)* Game.HEIGHT/563);
        }
    }
}
