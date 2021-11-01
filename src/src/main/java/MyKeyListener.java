import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.security.Key;

public class MyKeyListener extends KeyAdapter  {
    private Handler handler;
     private boolean[] keyDown=new boolean[4];
    public MyKeyListener(Handler handler){
        this.handler=handler;



    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i=0;i<handler.objList.size();i++) {
            GameObject tmp = handler.objList.get(i);
            if (tmp.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {

                    tmp.setVelY(-5);
                }
                if (key == KeyEvent.VK_S) {

                    tmp.setVelY(5);
                }
                if (key == KeyEvent.VK_A)

                tmp.setVelX(-5);
                if (key == KeyEvent.VK_D) {

                    tmp.setVelX(5);
                }
            }
            else  if (tmp.getId() == ID.Player2) {
                if (key == KeyEvent.VK_UP) {
                    tmp.setVelY(-5);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tmp.setVelY(5);
                }
                if (key == KeyEvent.VK_LEFT)
                    tmp.setVelX(-5);
                if (key == KeyEvent.VK_RIGHT) {
                    tmp.setVelX(5);
                }

            }
            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("[tasto:"+e.getKeyChar()+"]");
        for(int i=0;i<handler.objList.size();i++) {
            GameObject tmp = handler.objList.get(i);
            if (tmp.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                   tmp.setVelY(0);
                }
                if (key == KeyEvent.VK_S) {
                 tmp.setVelY(0);
                }
                if (key == KeyEvent.VK_A)
                    tmp.setVelX(0);
                if (key == KeyEvent.VK_D) {
                    tmp.setVelX(0);
                }
            }
            if (tmp.getId() == ID.Player2) {
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
            /*if(!keyDown[0] && !keyDown[1]){
                tmp.setVelX(0);
            }
            if(!keyDown[2] && !keyDown[3]){
                tmp.setVelY(0);
            }
            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }*/
        }
    }

}