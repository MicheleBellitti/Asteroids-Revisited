import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SfondoMouseListener extends MouseAdapter {

    private Handler handler;
    int mx, my;

    public SfondoMouseListener(Handler handler) {
        this.handler = handler;

    }

    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();

        if (Sfondo.on) {
            if (mx >= 330 && mx <= 430) { //sfondo rosa
                if (my >= 250 && my <= 300) {
                    Game.color= Color.pink;

                }

            }

            if (mx >= 333 && mx <= 433) { //sfondo blu
                if (my >= 350 && my <= 400) {
                    Game.color=Color.blue;

                }

            }

            if (mx >= 342 && mx < 342+75) { //sfondo bianco
                if (my >= 150 && my <= 200) {
                    Game.color=Color.black;

                }

            }
            if (mx >= 343 && mx < 343+83) { //sfondo rosso
                if (my >= 450 && my <= 500) {
                    Game.color=Color.red;

                }

            }




        }
        if(!StartMenu.on && !OptionPanel.on) {
            if (mx >= 640 && mx < 705) {
                if (my >= 500 && my <= 545) {
                    StartMenu.on=false;
                    Difficulty.on=false;
                    OptionPanel.on=true;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.on=false;
                    MovementSettings.on=false;
                    System.out.println("backnellosfondo");

                }

            }
        }
    }




}

