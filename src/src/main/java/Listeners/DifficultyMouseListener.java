    package Listeners;
    
    import Game.Game;
    import Util.Handler;
    import Screens.*;
    
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    public class DifficultyMouseListener extends MouseAdapter {
        private final Handler handler;
        int mx, my;
        public DifficultyMouseListener(Handler handler) {
            this.handler = handler;
        }
        public void mouseClicked(MouseEvent e) {
            mx = e.getX();
            my = e.getY();
            if (Difficulty.on) {
                if (mx >= 340*Game.WIDTH/784 && mx <= 407*Game.WIDTH/784) {
                    if (my >= 150 * Game.getHEIGHT()/561 && my <= 200 * Game.getHEIGHT()/561) {
                        Game.setDifficulty(3);
                    }
                }
                if (mx >= 332*Game.WIDTH/784 && mx <= 417*Game.WIDTH/784) {
                    if (my >= 250 * Game.getHEIGHT()/561 && my <= 300 * Game.getHEIGHT()/561) {
                        Game.setDifficulty(2);
                    }
                }
                if (mx >= 342*Game.WIDTH/784 && mx <= 409*Game.WIDTH/784) {
                    if (my >= 350  * Game.getHEIGHT()/561&& my <= 400 * Game.getHEIGHT()/561) {
                        Game.setDifficulty(1);
                    }
                }
    
            }
            if (Difficulty.on) {
                if (mx >= 640 *Game.WIDTH/784 && mx < 705*Game.WIDTH/784) {
                    if (my >= 500 * Game.getHEIGHT()/561 && my <= 545 * Game.getHEIGHT()/561) {
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