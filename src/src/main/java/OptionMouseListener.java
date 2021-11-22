import com.sun.source.doctree.DocCommentTree;

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
            if (mx >= 330 && mx <= 430) { //sfondo
                if (my >= 250 && my <= 300) {
                    System.out.println("SFONDO");
                    OptionPanel.on = false;
                    Sfondo.on = true;
                    Game.on=false;
                    Difficulty.on=false;
                    GameOverScreen.on=false;
                    MovementSettings.on=false;
                    StartMenu.on=false;
                }
            }

           if (mx >= 330 && mx <= 434) { //difficolta
                if (my >= 150 && my <= 200) {
                    StartMenu.on=false;
                    Difficulty.on=true;
                    OptionPanel.on=false;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.on=false;
                    MovementSettings.on=false;
                }

            }


            if (mx >= 333 && mx <= 433) {
                if (my >= 350 && my <= 400) {
                    System.out.println("CONTROLLI");
                    OptionPanel.on = false;
                    MovementSettings.on = true;
                    Sfondo.on = false;
                    Game.on=false;
                    Difficulty.on=false;
                    GameOverScreen.on=false;
                    StartMenu.on=false;

                }

            }

            if (mx >= 343 && mx < 426) { //suono
                if (my >= 450 && my <= 500) {
                    System.out.println("SUONO");

                }

            }
            if (OptionPanel.on) { //back
                if (mx >= 640 && mx <= 710) {
                    if (my >= 500 && my <= 545) {
                        StartMenu.on=true;
                        Difficulty.on=false;
                        OptionPanel.on=false;
                        Sfondo.on=false;
                        GameOverScreen.on=false;
                        Game.on=false;
                        MovementSettings.on=false;
                    }
                }
            }


        }
    }


}






