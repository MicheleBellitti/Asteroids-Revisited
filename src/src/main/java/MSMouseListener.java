import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
    public class MSMouseListener extends MouseAdapter {
        private String key;
        private Handler handler;
        private MovementSettings ms;
        int mx, my;
        public MSMouseListener(Handler handler,MovementSettings ms) {
            this.handler = handler;
            this.ms=ms;
        }
        public void mouseClicked(MouseEvent e) {
            mx = e.getX();
            my = e.getY();
            if (!OptionPanel.on && MovementSettings.on) {
                if (mx >= 20 && mx <=320) {
                    if (my >= 350 && my <= 450) {
                        ms.changed = false;
                        System.out.println("Standard!");
                    }
                }
                if (mx >= 465 && mx <=765) {
                    if (my >= 350 && my <= 450) {
                        ms.changed = true;
                        System.out.println("Secondary!");
                    }
                }

                if(MovementSettings.on) {
                    if (mx >= 640 && mx < 705) {
                        if (my >= 500 && my <= 545) {
                            StartMenu.on=false;
                            Difficulty.on=false;
                            OptionPanel.on=true;
                            Sfondo.on=false;
                            GameOverScreen.on=false;
                            Game.on=false;
                            MovementSettings.on=false;
                            SoundSettings.on=false;
                        }
                    }
                }
            }
        }
    }


