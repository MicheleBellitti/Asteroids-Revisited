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
            if (mx >= 330*Game.WIDTH/786 && mx <= 430*Game.WIDTH/786) { //sfondo
                if (my >= 250 *Game.HEIGHT/563 && my <= 300*Game.HEIGHT/563) {
                    OptionPanel.on = false;
                    Sfondo.on = true;
                    Game.on=false;
                    Difficulty.on=false;
                    GameOverScreen.on=false;
                    MovementSettings.on=false;
                    StartMenu.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                }
            }
            if (mx >= 330*Game.WIDTH/786 && mx <= 434*Game.WIDTH/786) { //difficolta
                if (my >= 150*Game.HEIGHT/563 && my <= 200*Game.HEIGHT/563) {
                    StartMenu.on=false;
                    Difficulty.on=true;
                    OptionPanel.on=false;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.on=false;
                    MovementSettings.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                }
            }
            if (mx >= 333*Game.WIDTH/786 && mx <= 433*Game.WIDTH/786) { //controlli
                if (my >= 350*Game.HEIGHT/563 && my <= 400*Game.HEIGHT/563) {
                    OptionPanel.on = false;
                    MovementSettings.on = true;
                    Sfondo.on = false;
                    Game.on=false;
                    Difficulty.on=false;
                    GameOverScreen.on=false;
                    StartMenu.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                }
            }
            if (mx >= 343*Game.WIDTH/786 && mx < 426*Game.WIDTH/786) { //suono
                if (my >= 450*Game.HEIGHT/563 && my <= 500*Game.HEIGHT/563) {
                    OptionPanel.on = false;
                    MovementSettings.on = false;
                    Sfondo.on = false;
                    Game.on=false;
                    Difficulty.on=false;
                    GameOverScreen.on=false;
                    StartMenu.on=false;
                    SoundSettings.on=true;
                    GamePause.on=false;
                }
            }
            if (OptionPanel.on && !GamePause.pause) { //back
                if (mx >= 640*Game.WIDTH/786 && mx <= 710*Game.WIDTH/786) {
                    if (my >= 500*Game.HEIGHT/563 && my <= 545*Game.HEIGHT/563) {
                        StartMenu.on=true;
                        Difficulty.on=false;
                        OptionPanel.on=false;
                        Sfondo.on=false;
                        GameOverScreen.on=false;
                        Game.on=false;
                        MovementSettings.on=false;
                        SoundSettings.on=false;
                        GamePause.on=false;
                    }
                }
            }
            if (OptionPanel.on && GamePause.pause) { //back
                if (mx >= 640*Game.WIDTH/786 && mx <= 710*Game.WIDTH/786) {
                    if (my >= 500*Game.HEIGHT/563 && my <= 545*Game.HEIGHT/563) {
                        StartMenu.on=false;
                        Difficulty.on=false;
                        OptionPanel.on=false;
                        Sfondo.on=false;
                        GameOverScreen.on=false;
                        Game.on=false;
                        MovementSettings.on=false;
                        SoundSettings.on=false;
                        GamePause.on=true;
                    }
                }
            }
        }
    }
}






