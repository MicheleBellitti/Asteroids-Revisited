import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Handler {
    public List<GameObject> objList=new LinkedList<GameObject>();
    public void tick(){
        for(int i=0;i<objList.size();i++){
            GameObject tmp=objList.get(i);
            tmp.tick();
        }
    }
    public void render(Graphics g){
        for(int i=0;i<objList.size();i++){
            GameObject tmp=objList.get(i);
            tmp.render(g);
        }
    }
    public void addGameObject(GameObject obj){
        objList.add(obj);
    }
    public void removeGameObject(GameObject obj) { objList.remove(obj); }
   public static int Ecollision(GameObject p,Handler handler){
        int hits=0;
           Rectangle player = new Rectangle((int)p.getX(), (int)p.getY(), 32, 32);
               for(int i=0;i<handler.objList.size();i++) {
                   GameObject tmp = handler.objList.get(i);
                   if (tmp.getId() != ID.Enemy) {
                        continue;
                   }
                   Rectangle e=new Rectangle((int)tmp.getX(),(int)tmp.getY(),16,16);
                   if(player.intersects(e)) hits++;
       }
               return hits;

   }
}
