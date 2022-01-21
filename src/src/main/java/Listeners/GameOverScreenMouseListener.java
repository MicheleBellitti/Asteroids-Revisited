package Listeners;

import Database.DataSaving;

import Game.Game;
import Screens.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Handler;


public class GameOverScreenMouseListener extends MouseAdapter {
    int mx,my;
    private int id=1;
    private final Handler handler;
    private final DataSaving ds;



    public GameOverScreenMouseListener(Handler handler, DataSaving ds) {
        this.handler = handler;
        this.ds=ds;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (GameOverScreen.on) {
            if (mx >= 315 *Game.WIDTH/784 && mx/Game.WIDTH/784 <= 315 + ((100 / 14) * GameOverScreen.nomi[0].length()) + (6 * GameOverScreen.nomi[0].length())) {
                if (my >= 190*Game.getHEIGHT()/561 && my <= 240*Game.getHEIGHT()/561) {
                    GameOverScreen.on = false;
                    Game.setOn(true);
                    SoundSettings.on=false;
                    GamePause.on=false;
                    GameOverScreen.saved=false;
                }
            }
            if (mx >= 297 *Game.WIDTH/784 && mx <= 397 *Game.WIDTH/784) {
                if (my >= 290*Game.getHEIGHT()/561 && my <= 340*Game.getHEIGHT()/561) {
                    System.out.println("BACKTOMENU");
                    StartMenu.on=true;
                    Difficulty.on=false;
                    OptionPanel.on=false;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.setOn(false);
                    MovementSettings.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                    GamePause.pause=false;
                    Leaderboard.on=false;
                    GameOverScreen.saved=false;
                }

            }
            if (mx >= 351*Game.WIDTH/784 && mx <= 431*Game.WIDTH/784) {
                if (my >= 390*Game.getHEIGHT()/561 && my <= 440*Game.getHEIGHT()/561) {
                    if(!GameOverScreen.saved) {
                        id = Integer.hashCode(Game.punteggiofinale);
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
