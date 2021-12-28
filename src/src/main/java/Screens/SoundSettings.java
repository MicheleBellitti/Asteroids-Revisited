package Screens;

import Game.Game;
import Screens.OptionPanel;

import java.awt.*;
public class SoundSettings extends OptionPanel {
    final int[] x = new int[2];
    final int[] y =new int[2];
    final int[] width = new int[2];
    final int[] height = new int[2];
    final String [] nomi= new String[2];
    public static boolean on;
    public SoundSettings(){
        x[0]=340;
        y[0]=150;
        width[0]=100;
        height[0]=50;
        nomi[0]="ON";
        x[1]=340;
        y[1]=250;
        width[1]=100;
        height[1]=50;
        nomi[1]="OFF";
        on=false;
    }
    public void render(Graphics g){
        g.setColor(Color.pink);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()* Game.getWIDTH()/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30*Game.getWIDTH()/786));
        g.drawString("ASTEROIDS",300*Game.getWIDTH()/786,75*Game.getHEIGHT()/563);
        g.setFont(font);
        g.fillRect(640*Game.getWIDTH()/786,500*Game.getHEIGHT()/563,65*Game.getWIDTH()/786,45*Game.getHEIGHT()/563);
        g.setColor(Color.black);
        g.drawString("BACK",655*Game.getWIDTH()/786,530*Game.getHEIGHT()/563);
        for(int i=0;i<2;i++){
            g.setColor(Color.pink);
            g.fillRect(x[i]*Game.getWIDTH()/786,y[i]*Game.getHEIGHT()/563,width[i]*Game.getWIDTH()/786,height[i]*Game.getHEIGHT()/563);
            g.setColor(Color.BLACK);
            g.drawString(nomi[i],(x[i]+35)*Game.getWIDTH()/786,(y[i]+30)*Game.getHEIGHT()/563);
        }
    }
}
