package Listeners;

import Game.Game;
import Util.Handler;
import Screens.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LeaderBoardML extends MouseAdapter {
    private Handler handler;
    int mx,my;
    public LeaderBoardML(Handler handler){this.handler=handler;}
    public void mouseClicked(MouseEvent e){
        mx=e.getX();
        my=e.getY();
        if(Leaderboard.on){
            if (mx >= 640*Game.WIDTH/784 && mx < 705*Game.WIDTH/784) {
                if (my >= 500 *Game.getHEIGHT()/561 && my <= 545*Game.getHEIGHT()/561) {
                    StartMenu.on=true;
                    Difficulty.on=false;
                    OptionPanel.on=false;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.setOn(false);
                    MovementSettings.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                    Leaderboard.on=false;
                }
            }
        }
    }
}