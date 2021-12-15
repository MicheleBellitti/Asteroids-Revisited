import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class SoundSettingsMouseListener  extends MouseAdapter {
    int mx, my;
    private Handler handler;

    public SoundSettingsMouseListener(Handler handler) {
        this.handler = handler;
    }

    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (SoundSettings.on) {
            if (mx >= 340*Game.WIDTH/786 && mx <= 440*Game.WIDTH/786) {
                if (my >= 150*Game.HEIGHT/563 && my <= 200*Game.HEIGHT/563) {
                    Game.sound = true;
                }
            }
                if (mx >= 340*Game.WIDTH/786 && mx <= 440*Game.WIDTH/786) {
                    if (my >= 250*Game.HEIGHT/563 && my <= 300*Game.HEIGHT/563) {
                        Game.sound = false;
                    }

                }
            }
            if (SoundSettings.on) { //back
                if (mx >= 640*Game.WIDTH/786 && mx <= 705*Game.WIDTH/786) {
                    if (my >= 500*Game.HEIGHT/563 && my <= 545*Game.HEIGHT/563) {
                        StartMenu.on = false;
                        Difficulty.on = false;
                        OptionPanel.on = true;
                        Sfondo.on = false;
                        GameOverScreen.on = false;
                        Game.on = false;
                        MovementSettings.on = false;
                        SoundSettings.on = false;
                        GamePause.on=false;
                    }
                }
            }
        }
    }
