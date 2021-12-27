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
                if (mx >= 20* Game.getWIDTH()/786 && mx <=320* Game.WIDTH/786) {
                    if (my >= 350* Game.HEIGHT/563 && my <= 450* Game.HEIGHT/563) {
                        ms.setChanged(false);
                        System.out.println("Standard!");
                    }
                }
                if (mx >= 465* Game.WIDTH/786 && mx <=765* Game.WIDTH/786) {
                    if (my >= 350* Game.HEIGHT/563 && my <= 450* Game.HEIGHT/563) {
                        ms.setChanged(true);
                        System.out.println("Secondary!");
                    }
                }

                if(MovementSettings.on) {
                    if (mx >= 640* Game.WIDTH/786 && mx < 705* Game.WIDTH/786) {
                        if (my >= 500* Game.HEIGHT/563 && my <= 545* Game.HEIGHT/563) {
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


