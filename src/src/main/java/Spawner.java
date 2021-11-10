import java.awt.*;
import java.util.Random;

public class Spawner {
    private Hud hud;
    private Handler handler;
    private Random r = new Random();
    private boolean deployed = false;

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

        if (hud.getScore() == hud.getLevel() * 200) {
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() % 2 == 0) {
                System.out.println(hud.getLevel());
                handler.addGameObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 5, 5, ID.Enemy));
            } else if (hud.getLevel() % 3 == 0) {
                for (int i = 0; i < handler.objList.size(); i++) {
                    GameObject gm = handler.objList.get(i);
                    if (gm.getId() == ID.Enemy) {
                        gm.setVelX(gm.getVelX() * 2);
                        gm.setVelY(gm.getVelY() * 2);
                    }
                }
            } else if (hud.getLevel() % 7 == 0) {
                handler.addGameObject(new Coin(r.nextInt(Game.WIDTH - 37), r.nextInt(Game.HEIGHT - 37), 0, 0, ID.Coin));
            } else if (hud.getLevel() > 1) {
                GameObject gm = new Enemy((float) r.nextInt(Game.WIDTH), (float) r.nextInt(Game.HEIGHT), r.nextInt(4), r.nextInt(4), ID.Enemy);
                gm.setWidth(gm.getWidth() + hud.getLevel());
                gm.setHeight(gm.getHeight() + hud.getLevel());
                handler.addGameObject(gm);

            }

        }
            /*GameObject c = null;
            for (int i = 0; i < this.handler.objList.size(); i++) {
                if (this.handler.objList.get(i).getId() == ID.Coin) {
                    c = this.handler.objList.get(i);
                    if (cCollision(getObject(this.handler, ID.Player), c, this.handler))
                        System.out.println(cCollision(getObject(this.handler, ID.Player), c, this.handler));
                        this.handler.removeGameObject(c);
                }
            }



        }
            public GameObject getObject(Handler handler,ID id) {
                GameObject target=null;
                for (int i = 0; i < handler.objList.size(); i++) {
                    GameObject tmp = handler.objList.get(i);
                    if (tmp.getId() == id) {
                        target = tmp;
                        break;
                    }
                }
                return target;
            }

             */
    }

}