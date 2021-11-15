import java.awt.*;
import java.util.Random;

public class Spawner {
    private Hud hud;
    private Handler handler;
    private Random r = new Random();

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
                this.handler.addGameObject(new Enemy((float)r.nextInt(Game.WIDTH),(float)r.nextInt(Game.HEIGHT),r.nextInt(5),r.nextInt(3),ID.Enemy));
            }
            else if(hud.getLevel()%3==0){
                GameObject en=new Enemy((float)r.nextInt(Game.WIDTH),(float)r.nextInt(Game.HEIGHT),r.nextInt(5),r.nextInt(3),ID.Enemy);
                en.setVelX(en.getVelX()+3);
                en.setVelY(en.getVelY()+3);
                this.handler.addGameObject(en);
            }
            else if(hud.getLevel()%5==0){
                GameObject en=new Enemy((float)r.nextInt(Game.WIDTH),(float)r.nextInt(Game.HEIGHT),r.nextInt(5),r.nextInt(3),ID.Enemy);
                en.setWidth(en.getWidth()+50);
                en.setHeight(en.getHeight()+r.nextInt(60));
                this.handler.addGameObject(en);
            }

        }

    }



}



/*
handler.addGameObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 5, 5, ID.Enemy));
                handler.addGameObject(new Coin(r.nextInt(Game.WIDTH - 37), r.nextInt(Game.HEIGHT - 37), 0, 0, ID.Coin));

 */