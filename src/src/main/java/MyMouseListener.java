import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MyMouseListener extends MouseAdapter {
    private Handler handler;
    private GameSound bulletsound;
    private GameObject tmp=null;
    public MyMouseListener(Handler handler){
        this.handler=handler;
    }
    public void FindPlayer(){
        for(int i=0;i<handler.objList.size();i++){
            if(handler.objList.get(i).getId()==ID.Player || handler.objList.get(i).getId()==ID.Enemy){
                tmp= handler.objList.get(i);
                break;
            }
        }
    }
    public void mouseClicked(MouseEvent e) {
        int mx, my;
        mx = e.getX();
        my = e.getY();
        if (StartMenu.on) {
            if (mx >= 325 && mx <= 425) { //play
                if (my >= 150 && my <= 200) {
                    System.out.println("GIOCA");
                    Game.on = true;
                    StartMenu.on = false;
                    GameOverScreen.on = false;
                    OptionPanel.on = false;
                    Difficulty.on = false;
                    Sfondo.on = false;
                    MovementSettings.on = false;
                    SoundSettings.on=false;
                    GamePause.on=false;

                }
            }
            if (mx >= 320 && mx <= 440) { //options
                if (my >= 400 && my <= 450) {
                    StartMenu.on = false;
                    Difficulty.on = false;
                    OptionPanel.on = true;
                    Sfondo.on = false;
                    GameOverScreen.on = false;
                    Game.on = false;
                    MovementSettings.on = false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                    Leaderboard.on=false;

                }
            }
            /*
            x[1]= 300;
        y[1]= 275;
        width[1] = 158;
        height[1] = 53;
             */
            if (mx >= 300 && mx <= 458) { //leaderboard
                if (my >= 275 && my <= 328) {
                    StartMenu.on = false;
                    Difficulty.on = false;
                    OptionPanel.on = false;
                    Sfondo.on = false;
                    GameOverScreen.on = false;
                    Game.on = false;
                    MovementSettings.on = false;
                    SoundSettings.on=false;
                    GamePause.on=false;
                    Leaderboard.on=true;

                }
            }
        }
        else FindPlayer();
    }
    public void mousePressed(MouseEvent e) {
        int mx,my;
        mx=e.getX();
        my=e.getY();
        if(tmp!=null && Game.on){
            GameObject tmpBullet=new Bullet(tmp.getX() + 16, tmp.getY() + 16, 0,0 , ID.Bullet);
            handler.objList.offerFirst(tmpBullet);
            if(Game.sound) {
                bulletsound = new GameSound(".\\src\\src\\main\\resources\\Bulletshot.wav");
                bulletsound.play();
                bulletsound.setVolume(-7.5F);
            }
            float angle=(float) Math.atan2(my-tmp.getY()-16,mx-tmp.getX()-16);
            int bullVel=10;
            tmpBullet.setVelX((float) (bullVel*Math.cos(angle)));
            tmpBullet.setVelY((float) (bullVel*Math.sin(angle)));
        }
        else FindPlayer();
    }
}
