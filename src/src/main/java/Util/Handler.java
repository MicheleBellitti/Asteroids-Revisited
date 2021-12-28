package Util;

import Objects.GameObject;

import java.awt.*;
import java.util.LinkedList;
import java.util.logging.LogRecord;

public class Handler extends java.util.logging.Handler {
    //20/11/21 12:00 list --> linkedlist
    public final LinkedList<GameObject> objList= new LinkedList<>();

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

    @Override
    public void publish(LogRecord record) {

    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
