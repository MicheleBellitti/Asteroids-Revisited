package Util;

import Game.Game;
import Objects.*;
import Util.Handler;

import java.awt.*;
import java.util.Random;
public class Spawner {
    private final Hud hud;
    private final Handler handler;
    private final Random r = new Random();
    private boolean deployed=false;
    public Spawner(Handler handler, Hud hud) {
        this.handler = handler;
        this.hud = hud;
    }
    public boolean cCollision(GameObject p, GameObject c, Handler handler) {
        Rectangle player = new Rectangle((int) p.getX(), (int) p.getY(), p.getWidth(), p.getHeight());
        Rectangle coin = new Rectangle((int) c.getX(), (int) c.getY(), c.getWidth(), c.getHeight());
        return player.intersects(coin);
    }
    public void tick() {
        if(hud.getScore()==hud.getLevel()*200){
            if(hud.getLevel()%2==0){
                this.handler.addGameObject(new Enemy((float)r.nextInt(Game.WIDTH),0f,r.nextInt(5),4f, ID.Enemy));
                deployed=true;
            }
            else if(hud.getLevel()%3==0){
                GameObject en=new Enemy((float)r.nextInt(Game.WIDTH),0f,r.nextInt(5),r.nextInt(4),ID.Enemy);
                en.setVelX(en.getVelX()+3);
                en.setVelY(en.getVelY()+3);
                this.handler.addGameObject(en);

            }
            else if(hud.getLevel()%5==0){
                GameObject en=new Enemy((float)r.nextInt(Game.WIDTH),0f,r.nextInt(2)+0.8f,r.nextInt(4),ID.Enemy);
                en.setWidth(en.getWidth()+r.nextInt(60));
                en.setHeight(en.getHeight()+r.nextInt(60));
                this.handler.addGameObject(en);
           for (int i = 1; i < 11*Game.WIDTH/800; i++) {
                    this.handler.addGameObject(new ShipEnemy(70 * i, 0f, 0, 1, ID.ShipEnemy));
                }
            }
            else if(hud.getLevel()>1){
                this.handler.addGameObject(new Coin(r.nextInt(Game.WIDTH-50),(float)r.nextInt(Game.HEIGHT-50),0,0,ID.Coin));
            }
            hud.setLevel(hud.getLevel()+1);
        }
    }
}
