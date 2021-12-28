package Screens;

import Database.DataSaving;
import Game.Game;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

public class Leaderboard {
    private final DataSaving ds;
    private int[] Scores = new int[5];
    public static boolean on=false;
    public Leaderboard(DataSaving ds){
        this.ds=ds;
    }
    public void tick(){
            try {
                Scores= ds.getTopScores(Scores);
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
    public void render(Graphics g){
        int x=330,y=125,width=100,height=50;
        g.setColor(Color.CYAN);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()* Game.WIDTH/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30* Game.getWIDTH()/786));
        g.drawString("ASTEROIDS",300* Game.getWIDTH()/786,75* Game.getHEIGHT()/563);
        g.setFont(font);
        g.fillRect(640* Game.getWIDTH()/786,500* Game.getHEIGHT()/563,65* Game.getWIDTH()/786,45* Game.getHEIGHT()/563);
        g.setColor(Color.black);
        g.drawString("BACK",655* Game.getWIDTH()/786,530* Game.getHEIGHT()/563);
        for(int i=0;i<5;i++){
            g.setColor(Color.CYAN);
            g.fillRect(x* Game.getWIDTH()/786,y* Game.getHEIGHT()/563,width* Game.getWIDTH()/786,height* Game.getHEIGHT()/563);
            g.setColor(Color.black);
            g.drawString(""+Scores[i],(x+15)* Game.getWIDTH()/786,(y+15)* Game.getHEIGHT()/563);
            y+=75* Game.getHEIGHT()/563;

        }
    }
}
