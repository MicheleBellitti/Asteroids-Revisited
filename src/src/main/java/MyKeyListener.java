import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.security.Key;

import static java.awt.event.KeyEvent.VK_S;

public class MyKeyListener extends KeyAdapter  {
    private Handler handler;
    private  boolean changed=false;
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
                    tmp.setVelY(-5);
                    keyDown[0]=true;
                }
                if (key == KeyEvent.VK_S) {
                    tmp.setVelY(5);
                    keyDown[1]=true;
                }
                if (key == KeyEvent.VK_A) {
                    tmp.setVelX(-5);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tmp.setVelX(5);
                    keyDown[3]=true;
                }
            }

            else  if (tmp.getId() == ID.Player && !changed) {
                if (key == KeyEvent.VK_UP) {
                    tmp.setVelY(-5);
                    keyDown[0]=true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    tmp.setVelY(5);
                    keyDown[1]=true;
                }
                if (key == KeyEvent.VK_LEFT)
                    tmp.setVelX(-5);
                    keyDown[2]=true;
                if (key == KeyEvent.VK_RIGHT) {
                    tmp.setVelX(5);
                    keyDown[3]=true;
                }

            }
            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(1);
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
                    tmp.setVelY(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tmp.setVelY(0);
                }
                if (key == KeyEvent.VK_LEFT)
                   tmp.setVelX(0);
                if (key == KeyEvent.VK_RIGHT) {
                    tmp.setVelX(0);
                }
            }

        }
    }

}