import Database.DataSaving;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

public class Leaderboard {
    private DataSaving ds;
    private ArrayList<Integer> Scores=new ArrayList<Integer>();
    static boolean on=false;
    public Leaderboard(DataSaving ds){
        this.ds=ds;
    }
    public void tick(){
        if(on){
            try {
                Scores= ds.getTopScores();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void render(Graphics g){
        int x=330,y=125,width=100,height=50;
        g.setColor(Color.CYAN);
        Font font=g.getFont();
        g.setFont(new Font("Helvetica",Font.PLAIN,30));
        g.drawString("ASTEROIDS",300,75);
        g.setFont(font);
        g.fillRect(640,500,65,45);
        g.setColor(Color.black);
        g.drawString("BACK",655,530);
        for(int i=0;i<5;i++){
            g.setColor(Color.CYAN);
            g.fillRect(x,y,width,height);

            g.setColor(Color.black);
            Scores.sort(Comparator.reverseOrder());
            System.out.println(Scores.get(i));
           g.drawString(""+Scores.get(i),x+15,y+15);
            y+=75;

        }
    }
}
