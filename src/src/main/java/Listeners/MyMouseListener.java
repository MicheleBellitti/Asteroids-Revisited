package Listeners;

import Game.Game;
import Objects.Bullet;
import Objects.GameObject;
import Objects.ID;
import Util.GameSound;
import Util.Handler;
import Screens.*;

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
            if(handler.objList.get(i).getId()== ID.Player || handler.objList.get(i).getId()== ID.Enemy){
                tmp= handler.objList.get(i);
                break;
            }
        }
    }
    public void mouseClicked(MouseEvent e) {
        int mx, my;
        mx = e.getX();
        my = e.getY();
        System.out.println(mx + " " + my);
        if (StartMenu.on) {
            if (mx >= 325* Game.getWIDTH()/784 && mx <= 425* Game.WIDTH/784) { //play
                if (my >= 150* Game.HEIGHT/561 && my <= 200* Game.HEIGHT/561) {
                    System.out.println("GIOCA");
                    Game.setOn(true);
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
            if (mx >= 320* Game.WIDTH/784 && mx <= 436* Game.WIDTH/784) { //options
                if (my >= 374* Game.HEIGHT/561 && my <= 420* Game.HEIGHT/561) {
                    StartMenu.on = false;
                    Difficulty.on = false;
                    OptionPanel.on = true;
                    Sfondo.on = false;
                    GameOverScreen.on = false;
                    Game.setOn(false);
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
            if (mx >= 300* Game.WIDTH/784 && mx <= 458* Game.WIDTH/784) { //leaderboard
                if (my >= 275* Game.HEIGHT/561 && my <= 328* Game.HEIGHT/561) {
                    StartMenu.on = false;
                    Difficulty.on = false;
                    OptionPanel.on = false;
                    Sfondo.on = false;
                    GameOverScreen.on = false;
                    Game.setOn(false);
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
        if(tmp!=null && Game.isOn()){
            GameObject tmpBullet=new Bullet(tmp.getX() + 16, tmp.getY() + 16, 0,0 , ID.Bullet);
            handler.objList.offerFirst(tmpBullet);
            if(Game.sound) {
                bulletsound = new GameSound("Bulletshot.wav");
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
