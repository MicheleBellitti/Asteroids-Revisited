package Listeners;

import Game.Game;
import Objects.GameObject;
import Objects.ID;
import Util.Handler;
import Screens.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter  {
    private Handler handler;
    private  boolean changed=true;
     private boolean[] keyDown=new boolean[4];
    public MyKeyListener(Handler handler){
        this.handler=handler;
        keyDown[0]=false;
        keyDown[1]=false;
        keyDown[2]=false;
        keyDown[3]=false;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i=0;i<handler.objList.size();i++) {
            GameObject tmp = handler.objList.get(i);
            if (tmp.getId() == ID.Player && changed) {
                if (key == KeyEvent.VK_W) {
                    tmp.setVelY(-4);
                    keyDown[0]=true;
                }
                if (key == KeyEvent.VK_S) {
                    tmp.setVelY(4);
                    keyDown[1]=true;
                }
                if (key == KeyEvent.VK_A) {
                    tmp.setVelX(-4);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tmp.setVelX(4);
                    keyDown[3]=true;
                }
            }
            else  if (tmp.getId() == ID.Player && !changed) {
                if (key == KeyEvent.VK_UP) {
                    tmp.setVelY(-4);
                    keyDown[0]=true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    tmp.setVelY(4);
                    keyDown[1]=true;
                }
                if (key == KeyEvent.VK_LEFT)
                    tmp.setVelX(-4);
                    keyDown[2]=true;
                if (key == KeyEvent.VK_RIGHT) {
                    tmp.setVelX(4);
                    keyDown[3]=true;
                }
            }
            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(1);
            }
            if( Game.isOn() && key==KeyEvent.VK_P){
                StartMenu.on = false;
                Difficulty.on = false;
                OptionPanel.on = false;
                Sfondo.on = false;
                GameOverScreen.on = false;
                Game.setOn(false);
                MovementSettings.on = false;
                SoundSettings.on=false;
                GamePause.on=true;
                GamePause.pause=true;

            }
        }
    }
    public void setChanged(boolean changed) {
            this.changed = changed;
    }
    public boolean isChanged() {
        return changed;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i=0;i<handler.objList.size();i++) {
            GameObject tmp = handler.objList.get(i);
            if (tmp.getId() == ID.Player && changed) {
                if (key == KeyEvent.VK_W) {
                    keyDown[0]=false;//tmp.setVelY(0);
                }
                if (key == KeyEvent.VK_S) {
                 keyDown[1]=false;//tmp.setVelY(0);
                }
                if (key == KeyEvent.VK_A)
                    keyDown[2]=false; //tmp.setVelX(0);
                if (key == KeyEvent.VK_D) {
                    keyDown[3]=false; //tmp.setVelX(0);
                }
                if(!keyDown[0] && !keyDown[1]){
                    tmp.setVelY(0);
                }
                if(!keyDown[2] && !keyDown[3]){
                    tmp.setVelX(0);
                }
            }
            if (tmp.getId() == ID.Player && !changed) {
                if (key == KeyEvent.VK_UP) {
                    keyDown[0]=false;//tmp.setVelY(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    keyDown[1]=false;//tmp.setVelY(0);
                }
                if (key == KeyEvent.VK_LEFT)
                    keyDown[2]=false; //tmp.setVelX(0);
                if (key == KeyEvent.VK_RIGHT) {
                    keyDown[3]=false; //tmp.setVelX(0);
                }
                if(!keyDown[0] && !keyDown[1]){
                    tmp.setVelY(0);
                }
                if(!keyDown[2] && !keyDown[3]){
                    tmp.setVelX(0);
                }
            }
        }
    }
}