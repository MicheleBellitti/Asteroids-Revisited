package Screens;

import Game.Game;

import java.awt.*;
  public class MovementSettings {
    final String[] keys=new String[4];
     static boolean changed=false;
    final int[] x= new int[5];
    final int[] y= new int[5];
    final int[] width= new int[5];
    final int[] height= new int[5];
    public static boolean on;
    public MovementSettings() {
        keys[0]="UP";
        keys[1]="LEFT";
        keys[2]="RIGHT";
        keys[3]="DOWN";
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
        x[3] = 343;
        y[3]=450;
        width[3]=83;
        height[3]=50;
        on=false;
    }

    public boolean isChanged() {
        return changed;
    }
    public void setChanged(boolean changed) {
        MovementSettings.changed = changed;
    }
    public  String getKey(int index){
        return keys[index];
    }
    public void setKey(String string,int index){
        this.keys[index]=string;
    }
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()* Game.WIDTH/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30*Game.WIDTH/786));
        g.drawString("ASTEROIDS",300*Game.WIDTH/786,75*Game.HEIGHT/563);
        g.setFont(font);
        g.fillRect(640*Game.WIDTH/786,500*Game.HEIGHT/563,65*Game.WIDTH/786,45*Game.HEIGHT/563);
        g.setColor(Color.black);
        g.drawString("BACK",655*Game.WIDTH/786,530*Game.HEIGHT/563);
        g.setColor(Color.yellow);
        g.setFont(new Font("Helvetica",Font.PLAIN,30*Game.WIDTH/786));
        g.drawString("CONTROLLI",300*Game.WIDTH/786,200*Game.HEIGHT/563);

        g.setColor(Color.yellow);
        g.drawRect(2*Game.WIDTH/786,350*Game.HEIGHT/563,250*Game.WIDTH/786,75* Game.HEIGHT/563);
        g.drawString("STANDARD",40*Game.WIDTH/786,410*Game.HEIGHT/563);
        g.drawRect(465*Game.WIDTH/786,350*Game.HEIGHT/563,250*Game.WIDTH/786,75*Game.HEIGHT/563);
        g.drawString("SECONDARY",490*Game.WIDTH/786,410*Game.HEIGHT/563);

    }
}
