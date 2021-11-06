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

            if(hud.getScore()== hud.getLevel()*200){
                if(hud.getLevel()%2==0) {
                    handler.addGameObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 5, 5, ID.Enemy));
                }
                hud.setLevel(hud.getLevel()+1);
            }


        }

}
