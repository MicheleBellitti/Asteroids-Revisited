import java.awt.*;
import java.util.Random;

public class Spawner {
    private Hud hud;
    private Handler handler;
    private Random r=new Random();
    private boolean deployed=false;
        public Spawner(Handler handler,Hud hud){
        this.handler=handler;
        this.hud=hud;
        }
        public void tick(){
        if(hud.getLevel()%2==0 && !deployed){
            handler.addGameObject(new Enemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),5,5,ID.Enemy));
            deployed=true;
            }
        else deployed=false;

        }

}
