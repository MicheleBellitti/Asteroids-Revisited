package Listeners;

import Game.Game;
import Util.Handler;
import Screens.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class SoundSettingsMouseListener  extends MouseAdapter {
    int mx, my;
    private final Handler handler;

    public SoundSettingsMouseListener(Handler handler) {
        this.handler = handler;
    }

    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (SoundSettings.on) {
            if (mx >= 340* Game.getWIDTH()/784 && mx <= 440* Game.WIDTH/784) {
                if (my >= 150* Game.HEIGHT/561 && my <= 200* Game.HEIGHT/561) {
                    Game.sound = true;
                }
            }
                if (mx >= 340* Game.WIDTH/784 && mx <= 440* Game.WIDTH/784) {
                    if (my >= 250* Game.HEIGHT/561 && my <= 300* Game.HEIGHT/561) {
                        Game.sound = false;
                    }

                }
            }
            if (SoundSettings.on) { //back
                if (mx >= 640* Game.WIDTH/784 && mx <= 705* Game.WIDTH/784) {
                    if (my >= 500* Game.HEIGHT/561 && my <= 545* Game.HEIGHT/561) {
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
