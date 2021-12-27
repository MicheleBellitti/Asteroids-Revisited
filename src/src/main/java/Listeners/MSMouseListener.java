package Listeners;

import Game.Game;
import Util.Handler;
import Screens.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
    public class MSMouseListener extends MouseAdapter {
        private String key;
        private Handler handler;
        private MovementSettings ms;
        int mx, my;
        public MSMouseListener(Handler handler, MovementSettings ms) {
            this.handler = handler;
            this.ms=ms;
        }
        public void mouseClicked(MouseEvent e) {
            mx = e.getX();
            my = e.getY();
            if (!OptionPanel.on && MovementSettings.on) {
                if (mx >= 20* Game.getWIDTH()/784 && mx <=320* Game.WIDTH/784) {
                    if (my >= 350* Game.HEIGHT/561 && my <= 450* Game.HEIGHT/561) {
                        ms.setChanged(false);
                        System.out.println("Standard!");
                    }
                }
                if (mx >= 465* Game.WIDTH/784 && mx <=765* Game.WIDTH/784) {
                    if (my >= 350* Game.HEIGHT/561 && my <= 450* Game.HEIGHT/561) {
                        ms.setChanged(true);
                        System.out.println("Secondary!");
                    }
                }

                if(MovementSettings.on) {
                    if (mx >= 640* Game.WIDTH/784 && mx < 705* Game.WIDTH/784) {
                        if (my >= 500* Game.HEIGHT/561 && my <= 545* Game.HEIGHT/561) {
                            StartMenu.on=false;
                            Difficulty.on=false;
                            OptionPanel.on=true;
                            Sfondo.on=false;
                            GameOverScreen.on=false;
                            Game.setOn(false);
                            MovementSettings.on=false;
                            SoundSettings.on=false;
                            GamePause.on=false;
                        }
                    }
                }
            }
        }
    }


