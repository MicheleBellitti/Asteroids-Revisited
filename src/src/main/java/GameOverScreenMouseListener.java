import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class GameOverScreenMouseListener extends MouseAdapter {
    int mx,my;
    private Handler handler;
    public GameOverScreenMouseListener(Handler handler) {
        this.handler = handler;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (GameOverScreen.on) {
            if (mx >= 315 && mx <= 315 + ((100 / 14) * GameOverScreen.nomi[0].length()) + (6 * GameOverScreen.nomi[0].length())) {
                if (my >= 190 && my <= 240) {
                    GameOverScreen.on = false;
                    Game.on = true;
                    SoundSettings.on=false;
                    GamePause.on=false;
                }
            }
            if (mx >= 297 && mx <= 297 + 100) {
                if (my >= 290 && my <= 340) {
                    System.out.println("BACKTOMENU");
                    GameOverScreen.on = false;
                    StartMenu.on = true;
                    SoundSettings.on=false;
                    GamePause.on=false;
                }
            }
            if (mx >= 351 && mx <= 351 + 80) {
                if (my >= 390 && my <= 440) {
                    System.out.println("SAVE");
                }
            }
        }
    }
}
