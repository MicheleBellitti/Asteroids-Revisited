package Listeners;

import Game.Game;
import Util.Handler;
import Screens.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class OptionMouseListener extends MouseAdapter {
    private Handler handler;
    int mx, my;
    public OptionMouseListener(Handler handler) {
        this.handler = handler;
    }
    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (OptionPanel.on) {
            if (mx >= 330* Game.getWIDTH()/784 && mx <= 430* Game.WIDTH/784) { //sfondo
                if (my >= 250 * Game.HEIGHT/561 && my <= 300* Game.HEIGHT/561) {
                    OptionPanel.on = false;
                    Sfondo.on = true;
                    Game.setOn(false);
                    Difficulty.on=false;
                    GameOverScreen.on=false;
                    MovementSettings.on=false;
                    StartMenu.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                }
            }
            if (mx >= 330* Game.WIDTH/784 && mx <= 434* Game.WIDTH/784) { //difficolta
                if (my >= 150* Game.HEIGHT/561 && my <= 200* Game.HEIGHT/561) {
                    StartMenu.on=false;
                    Difficulty.on=true;
                    OptionPanel.on=false;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.setOn(false);
                    MovementSettings.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                }
            }
            if (mx >= 333* Game.WIDTH/784 && mx <= 433* Game.WIDTH/784) { //controlli
                if (my >= 350* Game.HEIGHT/561 && my <= 400* Game.HEIGHT/561) {
                    OptionPanel.on = false;
                    MovementSettings.on = true;
                    Sfondo.on = false;
                    Game.setOn(false);
                    Difficulty.on=false;
                    GameOverScreen.on=false;
                    StartMenu.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                }
            }
            if (mx >= 343* Game.WIDTH/784 && mx < 426* Game.WIDTH/784) { //suono
                if (my >= 450* Game.HEIGHT/561 && my <= 500* Game.HEIGHT/561) {
                    OptionPanel.on = false;
                    MovementSettings.on = false;
                    Sfondo.on = false;
                    Game.setOn(false);
                    Difficulty.on=false;
                    GameOverScreen.on=false;
                    StartMenu.on=false;
                    SoundSettings.on=true;
                    GamePause.on=false;
                }
            }
            if (OptionPanel.on && !GamePause.pause) { //back
                if (mx >= 640* Game.WIDTH/784 && mx <= 710* Game.WIDTH/784) {
                    if (my >= 500* Game.HEIGHT/561 && my <= 545* Game.HEIGHT/561) {
                        StartMenu.on=true;
                        Difficulty.on=false;
                        OptionPanel.on=false;
                        Sfondo.on=false;
                        GameOverScreen.on=false;
                        Game.setOn(false);
                        MovementSettings.on=false;
                        SoundSettings.on=false;
                        GamePause.on=false;
                    }
                }
            }
            if (OptionPanel.on && GamePause.pause) { //back
                if (mx >= 640* Game.WIDTH/784 && mx <= 710* Game.WIDTH/784) {
                    if (my >= 500* Game.HEIGHT/561 && my <= 545* Game.HEIGHT/561) {
                        StartMenu.on=false;
                        Difficulty.on=false;
                        OptionPanel.on=false;
                        Sfondo.on=false;
                        GameOverScreen.on=false;
                        Game.setOn(false);
                        MovementSettings.on=false;
                        SoundSettings.on=false;
                        GamePause.on=true;
                    }
                }
            }
        }
    }
}






