import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
    private Handler handler;
    private GameObject tmp=null;
    public MyMouseListener(Handler handler){
        this.handler=handler;
    }
    public void FindPlayer(){
        for(int i=0;i<handler.objList.size();i++){
            if(handler.objList.get(i).getId()==ID.Player || handler.objList.get(i).getId()==ID.Player2){
                tmp= handler.objList.get(i);
                break;
            }
        }
    }
     public void mouseClicked(MouseEvent e) {

        int mx,my;
        mx=e.getX();
        my=e.getY();
        System.out.println(mx);
        System.out.println(my);
        if(tmp!=null){
            GameObject tmpBullet=new Bullet(tmp.getX() + 16, tmp.getY() + 16, 0,0 , ID.Bullet);
            handler.addGameObject(tmpBullet);
            float angle=(float) Math.atan2(my-tmp.getY()-16,mx-tmp.getX()-16);
            int bullVel=10;
            tmpBullet.setVelX((float) (bullVel*Math.cos(angle)));
            tmpBullet.setVelY((float) (bullVel*Math.sin(angle)));
        }
        if(StartMenu.on==true) {
            if (mx >= 325 && mx <=425 ) {
                if (my >= 150 && my <= 200 ) {
                    StartMenu.on = false;
                    Game.on=true;
                }
            }
            if(mx >= 320 && mx <= 440 ){
                if(my>= 400  && my <=450){
                    OptionPanel.on=true;
                   StartMenu.on=false;
// 400   600 300  500
                }

            }
        }
        else FindPlayer();
    }
    public void mousePressed(MouseEvent e){
        int mx,my;
        mx=e.getX();
        my=e.getY();
        if(tmp!=null){
            GameObject tmpBullet=new Bullet(tmp.getX() + 16, tmp.getY() + 16, 0,0 , ID.Bullet);
            handler.addGameObject(tmpBullet);
            float angle=(float) Math.atan2(my-tmp.getY()-16,mx-tmp.getX()-16);
            int bullVel=10;
            tmpBullet.setVelX((float) (bullVel*Math.cos(angle)));
            tmpBullet.setVelY((float) (bullVel*Math.sin(angle)));
        }
        else FindPlayer();
    }

}
