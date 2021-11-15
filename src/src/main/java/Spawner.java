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

    }



}



/*
handler.addGameObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 5, 5, ID.Enemy));
                handler.addGameObject(new Coin(r.nextInt(Game.WIDTH - 37), r.nextInt(Game.HEIGHT - 37), 0, 0, ID.Coin));

 */