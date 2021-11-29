import Database.DataSaving;

import java.awt.*;
import java.sql.SQLException;

public class Leaderboard {
    private DataSaving ds;
    private int[] Scores=new int[5];
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
        Font font=g.getFont();
        g.setColor(Color.darkGray);
        g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
        g.setColor(Color.RED);
        g.setFont(new Font("Helvetica",Font.PLAIN,30));
        g.drawString("Leaderboard", 300, 75);
        g.setFont(font);
    }
}
