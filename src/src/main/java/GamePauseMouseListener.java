import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePauseMouseListener extends MouseAdapter {
    private Handler handler;
    int mx,my;
    public GamePauseMouseListener(Handler handler){
        this.handler=handler;
    }
    public void mouseClicked(MouseEvent e){
        mx=e.getX(); my=e.getY();
        if(GamePause.on){
            if(mx>=330 && mx<=430){
                if(my>= 250 && my<=300){ //resume
                    StartMenu.on = false;
                    Difficulty.on = false;
                    OptionPanel.on = false;
                    Sfondo.on = false;
                    GameOverScreen.on = false;
                    Game.on = true;
                    MovementSettings.on = false;
                    SoundSettings.on = false;
                    GamePause.on=false;
                }

            }
            if(mx>=333 && mx<=433){ //quit
                if(my>= 350 && my<=400){
                    Hud.HEALTH=1;
                    GamePause.on=false;
                }

            }

            if(mx>=342 && mx<=342+75){ //options
                if(my>= 150 && my<=200){
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
