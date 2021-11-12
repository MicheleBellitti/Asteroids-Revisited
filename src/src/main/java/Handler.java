import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Handler {
    public List<GameObject> objList=new LinkedList<GameObject>();
    public List<GameObject> bulletList=new LinkedList<GameObject>();
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

}
