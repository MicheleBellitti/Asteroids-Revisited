import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LeaderBoardML extends MouseAdapter {
    private Handler handler;
    int mx,my;
    public LeaderBoardML(Handler handler){this.handler=handler;}
    public void mouseClicked(MouseEvent e){
        mx=e.getX();
        my=e.getY();
        if(Leaderboard.on){
            if (mx >= 640 && mx < 705) {
                if (my >= 500 && my <= 545) {
                    StartMenu.on=true;
                    Difficulty.on=false;
                    OptionPanel.on=false;
                    Sfondo.on=false;
                    GameOverScreen.on=false;
                    Game.on=false;
                    MovementSettings.on=false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                    Leaderboard.on=false;
                }
            }
        }
    }
}