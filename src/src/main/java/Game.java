//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.sound.midi.SysexMessage;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.Iterator;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    static int punteggiofinale; // 20/11/21 12:00
    static Color color= Color.BLACK;
    private Hud hud;
    private int tickTimer=0;
    public static int ENEMY_NUMBER = 15;
    private int J = 1;
    private StartMenu mn;
    static boolean on=false;
    private static String title = "Easy Game";
    private Thread thread;
    private boolean running = false;
    private boolean gameOver = false;
    Random r1 = new Random();
    private Handler handler = new Handler();
    private Spawner spawner;
    private OptionPanel op;
    private GameOverScreen gos; // 20/11/21 12:00
    private Sfondo sf;
    int cnt=-1;
    public Game() {
        new Window(WIDTH, HEIGHT, title, this);
        mn= new StartMenu();
        op = new OptionPanel();
        sf=new Sfondo();
        gos=new GameOverScreen(); // 20/11/21 12:00
        this.start();
        hud =new Hud();
        this.spawner=new Spawner(handler,hud);
        this.addKeyListener(new MyKeyListener(this.handler));
        this.addMouseListener(new OptionMouseListener(this.handler));
        this.addMouseListener(new SfondoMouseListener(this.handler));
        this.addMouseListener(new MyMouseListener(this.handler));
        this.addMouseListener(new GameOverScreenMouseListener(this.handler)); // 20/11/21 12:00
        this.handler.addGameObject(new Player(350.0F, (float) (HEIGHT - 75), 0.0F, 0.0F, ID.Player));
        for (int i = 0; i < 3; i++) {
            this.handler.addGameObject(new Enemy((float)r1.nextInt(WIDTH), 0.0F, 2*J, 2.0F, ID.Enemy));
            this.J *= -1;
        }

        this.stop();
    }
    public int Ecollision(GameObject p,Handler handler,ID id){
        int hits=0;
        Rectangle player = new Rectangle((int)p.getX(), (int)p.getY(), 32, 32);
        for(int i=0;i<handler.objList.size();i++) {
            GameObject tmp = handler.objList.get(i);
            if (tmp.getId() != id) {
                continue;
            }
            Rectangle e=new Rectangle((int)tmp.getX(),(int)tmp.getY(),16,16);
            if(player.intersects(e)) hits++;
        }
        return hits;

    }
    public void Ccollision(GameObject p,Handler handler,ID id){
        Rectangle player = new Rectangle((int)p.getX(), (int)p.getY(), 32, 32);
        for(int i=0;i<handler.objList.size();i++) {
            GameObject tmp = handler.objList.get(i);
            if (tmp.getId() != id) {
                continue;
            }
            Rectangle e=new Rectangle((int)tmp.getX(),(int)tmp.getY(),16,16);
            if(player.intersects(e)) {
                handler.removeGameObject(tmp);
                this.hud.setScore(hud.getScore()+200);
            }
        }

    }


    public void Bcollision(Handler handler) {
        int bx,by,bwidth,bheight;
        int ex,ey,ewidth,eheight;
        for(int i=0;i<handler.objList.size();i++){
            if(handler.objList.get(i).getId()==ID.Bullet){
                bx=(int)handler.objList.get(i).getX();
                by=(int)handler.objList.get(i).getY();
                bwidth=7;
                bheight=7;
                //System.out.println("BULLET: " + bx +" "+ by + " " + bwidth + " " +bheight);
                for(int p=0;p<handler.objList.size();p++) {
                    if(handler.objList.get(p).getId()==ID.Enemy){
                        ex=(int)handler.objList.get(p).getX();
                        ey=(int)handler.objList.get(p).getY();
                        ewidth= handler.objList.get(p).getWidth();
                        eheight=(int)handler.objList.get(p).getHeight();
                        //System.out.println(ex +" "+ ey + " " + ewidth + " " +eheight);
                        Rectangle pro= new Rectangle(bx,by,bwidth,bheight);
                        Rectangle nem= new Rectangle(ex,ey,ewidth,eheight);
                        if(pro.intersects(nem)){
                            hud.setScore(hud.getScore()+100);
                            hud.setKills(hud.getKills()+1);
                            handler.removeGameObject(handler.objList.get(p));
                            handler.removeGameObject(handler.objList.get(i));
                        }

                    }

                }
            }

        }


    }
    //

    public  void freezeGame(){
        for(int i=0;i<handler.objList.size();++i){
            GameObject obj=handler.objList.get(i);
            obj.setVelY(0f);
            obj.setVelX(0f);

        }
    }

    public GameObject getObject(Handler handler,ID id,int index) {
        for (int i = index; i < handler.objList.size(); i++) {
            if (handler.objList.get(i).getId() == id) {
                return handler.objList.get(i);
            }
        }
        return null;
    }
    private synchronized void start() {
        if (!this.running) {
            this.thread = new Thread(this);
            this.thread.start();
            this.running = true;
        }
    }

    private synchronized void stop() {
        if (this.running) {
            try {
                this.thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.running = false;
        }
    }
    // 20/11/21 12:00 nuovo metodo
    private void RemoveAllButPlayer(Handler handler){
        for(int i=handler.objList.size();i>0;i--){
            if(handler.objList.get(i-1).getId() !=ID.Player) handler.objList.remove(i-1);
        }
    }
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0D;
        double ns = 1.0E9D / amountOfTicks;
        double delta = 0.0D;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while(this.running) {
            long now = System.nanoTime();
            delta += (double)(now - lastTime) / ns;

            for(lastTime = now; delta >= 1.0D; --delta) {
                this.tick();
                ++updates;
            }

            this.render();
            ++frames;
            if (System.currentTimeMillis() - timer > 1000L) {
                timer += 1000L;
                frames = 0;
                updates = 0;
            }
        }

    }
    int BulletCount(Handler handler){
        int num=0;
        for(int i=0;i<handler.objList.size();i++){
            if(handler.objList.get(i).getId()==ID.Bullet){++num;}
        }

        return num;

    }
    public static int clamp(int val,int min,int max){
        if(val>=max)
            return val=max;
        else if(val<=min)
            return val=min;
        else return val;

    }


    public void RemoveBullet(Handler handler){
        for(int i=0;i<handler.objList.size();++i){
            if(handler.objList.get(i).getId()==ID.Bullet) {
                int xpos=  (int)handler.objList.get(i).getX();
                int ypos=  (int)handler.objList.get(i).getY();
                if(xpos <=0 || xpos >=800 || ypos <=0 || ypos >=600) handler.removeGameObject(handler.objList.get(i));
            }
        }
    }

    private void tick() {
        if(!StartMenu.on && Game.on) {
            tickTimer++;
            //System.out.println(tickTimer);
            this.handler.tick();
            this.spawner.tick();
            this.hud.tick();
            hud.HEALTH -= 2 * Ecollision(getObject(this.handler, ID.Player, 0), this.handler, ID.Enemy);
            Ccollision(getObject(this.handler, ID.Player, 0), this.handler, ID.Coin);
            RemoveBullet(this.handler);
            Bcollision(this.handler);
            if (tickTimer == 100) {
                this.handler.addGameObject(new Enemy((float) r1.nextInt(WIDTH), (float) r1.nextInt(HEIGHT), r1.nextInt(5), r1.nextInt(3), ID.Enemy));
                tickTimer = 0;
            }
            //System.out.println("ci sono in totale "+ BulletCount(handler)+ "bullet");

        }
        // 20/11/21 12:00
        if(Hud.HEALTH == 1) {
            Game.on=false;
            GameOverScreen.on=true;
            Hud.HEALTH = 255; //setti i valori prima salvi il punteggio
            punteggiofinale=hud.getScore();
            hud.setLevel(1);
            hud.setScore(0);
            System.out.println(handler.objList);
            RemoveAllButPlayer(this.handler);
            System.out.println(handler.objList);
            handler.objList.get(0).setX(350.0F); // reset coordinate player
            handler.objList.get(0).setY((float) (HEIGHT - 75));
            for (int i = 0; i < 3; i++) { //spawn nemici nuovo
                this.handler.addGameObject(new Enemy((float)r1.nextInt(WIDTH), 0.0F, 2*J, 2.0F, ID.Enemy));
                this.J *= -1;
            }
        }
        // if(hud.getLevel()>=10) freezeGame();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
        } else {
            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            if(!StartMenu.on  && Game.on) {
                g.setColor(color);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                this.handler.render(g);
                this.hud.render(g);
            }
            if(StartMenu.on) this.mn.render(g);
            if(OptionPanel.on && !StartMenu.on) this.op.render(g);
            if(!OptionPanel.on && Sfondo.on) this.sf.render(g);
            if(GameOverScreen.on && !Game.on && !OptionPanel.on && !Sfondo.on) this.gos.render(g); //20/11/21 12:00
            bs.show();
            g.dispose();
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
