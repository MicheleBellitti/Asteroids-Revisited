import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class DifficultyMouseListener extends MouseAdapter {
    private Handler handler;
    int mx, my;
    public DifficultyMouseListener(Handler handler) {
        this.handler = handler;
    }
    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        if (Difficulty.on) {
            if (mx >= 340 && mx <= 407) {
                if (my >= 150 && my <= 200) {
                Game.difficulty=3;
                }
            }
            if (mx >= 332 && mx <= 332+85) {
                if (my >= 250 && my <= 300) {
                    Game.difficulty=2;
                }
            }
            if (mx >= 342 && mx <= 409) {
                if (my >= 350 && my <= 400) {
                    Game.difficulty=1;
                }
            }
        }
        if (!StartMenu.on && !OptionPanel.on) {
            if (mx >= 640 && mx < 705) {
                if (my >= 500 && my <= 545) {
                    StartMenu.on=false;
                    Difficulty.on=false;
                    OptionPanel.on=true;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.on=false;
                    MovementSettings.on=false;
                    System.out.println("backnellaoifficoltà");
                }
            }
        }
    }
}