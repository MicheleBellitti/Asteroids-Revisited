package Listeners;

import Game.Game;
import Util.Handler;
import Screens.*;
import Util.Hud;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePauseMouseListener extends MouseAdapter {
    private Handler handler;
    int mx,my;
    public GamePauseMouseListener(Handler handler){
        this.handler=handler;
    }
    public void mouseClicked(MouseEvent e){
        mx=e.getX(); my=e.getY();
        if(GamePause.on){
            if(mx>=330*Game.getWIDTH()/784 && mx<=430*Game.getWIDTH()/784){
                if(my>= 250*Game.getHEIGHT()/561 && my<=300*Game.getHEIGHT()/561){ //resume
                    StartMenu.on = false;
                    Difficulty.on = false;
                    OptionPanel.on = false;
                    Sfondo.on = false;
                    GameOverScreen.on = false;
                    Game.setOn(true);
                    MovementSettings.on = false;
                    SoundSettings.on = false;
                    GamePause.on=false;
                    GamePause.pause=false;
                }

            }
            if(mx>=333 *Game.getWIDTH()/784 && mx<=433*Game.getWIDTH()/784){ //quit
                if(my>= 350 *Game.getHEIGHT()/561 && my<=400*Game.getHEIGHT()/561){
                    StartMenu.on = false;
                    Difficulty.on = false;
                    OptionPanel.on = false;
                    Sfondo.on = false;
                    GameOverScreen.on = false;
                    Game.setOn(false);
                    MovementSettings.on = false;
                    SoundSettings.on = false;
                    Hud.setHEALTH(0);
                    GamePause.on=false;
                }

            }

            if(mx>=342 *Game.getWIDTH()/784&& mx<=417*Game.getWIDTH()/784){ //options
                if(my>= 150*Game.getHEIGHT()/561 && my<=200*Game.getHEIGHT()/561){
                    StartMenu.on = false;
                    Difficulty.on = false;
                    OptionPanel.on = true;
                    Sfondo.on = false;
                    GameOverScreen.on = false;
                    Game.setOn(false);
                    MovementSettings.on = false;
                    SoundSettings.on = false;
                    GamePause.on=false;
                }

            }
        }

    }
}
