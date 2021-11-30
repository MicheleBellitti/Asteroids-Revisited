import Database.DataSaving;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class GameOverScreenMouseListener extends MouseAdapter {
    int mx,my;
    private int id=1;
    private Handler handler;
    private DataSaving ds;



    public GameOverScreenMouseListener(Handler handler,DataSaving ds) {
        this.handler = handler;
        this.ds=ds;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (GameOverScreen.on) {
            if (mx >= 315 && mx <= 315 + ((100 / 14) * GameOverScreen.nomi[0].length()) + (6 * GameOverScreen.nomi[0].length())) {
                if (my >= 190 && my <= 240) {
                    GameOverScreen.on = false;
                    Game.on = true;
                    SoundSettings.on=false;
                    GamePause.on=false;
                    GameOverScreen.saved=false;
                }
            }
            if (mx >= 297 && mx <= 297 + 100) {
                if (my >= 290 && my <= 340) {
                    System.out.println("BACKTOMENU");
                    StartMenu.on=true;
                    Difficulty.on=false;
                    OptionPanel.on=false;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.on=false;
                    MovementSettings.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                    GamePause.pause=false;
                    Leaderboard.on=false;
                    GameOverScreen.saved=false;
                }
            }
            if (mx >= 351 && mx <= 351 + 80) {
                if (my >= 390 && my <= 440) {
                    if(!GameOverScreen.saved) {
                        id = id + 1;
                        System.out.println("SAVE");
                        try {
                            ds.InsertScore(id, Game.punteggiofinale);
                            GameOverScreen.saved=true;
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
