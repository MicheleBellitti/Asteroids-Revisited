package Game;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import Database.DBManager;
import Database.DataSaving;
import Listeners.*;
import Objects.Enemy;
import Objects.GameObject;
import Objects.ID;
import Objects.Player;
import Screens.*;
import Util.*;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferStrategy;
import java.sql.SQLException;
import java.util.Random;
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 5162710183389028794L;
    static Dimension screenSize;
    public SpriteSheet Sprite;
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static boolean sound = false;
    static int difficulty= 2;
   public  int gamesplayed=0;
    public static int punteggiofinale; // 20/11/21 12:00
    public static Color color=Color.black;
    private Hud hud;
    private int tickTimer=0;
    public static int ENEMY_NUMBER = 15;
    private int J = 1;
    private StartMenu mn;
    static String sfondo="darkspace.jpg";
    static boolean on=false;
    private DataSaving ds;
    {
        try {
            ds = new DataSaving();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static String title = "ASTEROIDS";
    private Thread thread;
    private boolean running = false;
    private boolean gameOver = false;
    Random r1 = new Random();
    private Handler handler = new Handler();
    private MyKeyListener kL=new MyKeyListener(this.handler);
    private Spawner spawner;
    private OptionPanel op;
    private GamePause gp;
    private GameSound enemyhit,playerhit,coinhit,gameoversound,play;
    private GameOverScreen gos; // 20/11/21 12:00
    private Sfondo sf;
    private SoundSettings ss;
    private MovementSettings movementSettings;
    private Difficulty diff;
    private Leaderboard ld;


    public Game() throws SQLException {
        new Window(WIDTH, HEIGHT, title, this);

        mn= new StartMenu();
        Sprite=new SpriteSheet();
        ld=new Leaderboard(ds);
        op = new OptionPanel();
        sf=new Sfondo();
        gp=new GamePause();
        diff=new Difficulty();
        ss=new SoundSettings();
        gos=new GameOverScreen();
        this.start();
        hud =new Hud();
        this.spawner=new Spawner(handler,hud);
        movementSettings=new MovementSettings();
        this.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent e){
                if(getBounds().width!=WIDTH || getBounds().height!=HEIGHT){

                    WIDTH=getBounds().width;
                    HEIGHT=getBounds().height;
                }
            }
        });
        this.addKeyListener(kL);
        this.addMouseListener(new OptionMouseListener(this.handler));
        this.addMouseListener(new SfondoMouseListener(this.handler));
        this.addMouseListener(new MSMouseListener(this.handler,movementSettings));
        this.addMouseListener(new MyMouseListener(this.handler));
        this.addMouseListener(new GameOverScreenMouseListener(this.handler,ds)); // 20/11/21 12:00 this.addMouseListener(new Listeners.GameOverScreenMouseListener(this.handler)); // 20/11/21 12:00
        this.addMouseListener(new DifficultyMouseListener(this.handler));
        this.addMouseListener(new SoundSettingsMouseListener(this.handler));
        this.addMouseListener(new GamePauseMouseListener(this.handler));
        this.addMouseListener(new LeaderBoardML(this.handler));
        enemyhit=new GameSound("ENEMYCOLPITO.wav");
        gameoversound = new GameSound("Shadows of Evil Game Over Song.wav");
        coinhit=new GameSound("Coinraccolto.wav");
        playerhit=new GameSound("PLAYERCOLPITO.wav");
        play= new GameSound("Street Fighter III 3rd Strike-The Theme of Q.wav");
        this.handler.addGameObject(new Player((float)this.getBounds().getWidth()/2, (float) this.getBounds().height/2, 0.0F, 0.0F, ID.Player));
        for (int i = 0; i < 3; i++) {
            this.handler.addGameObject(new Enemy((float)r1.nextInt(WIDTH), 0.0F, 2*J, 2.0F, ID.Enemy));
            this.J *= -1;
        }
        this.stop();
    }



    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        Game.screenSize = screenSize;
    }

    public SpriteSheet getSprite() {
        return Sprite;
    }

    public void setSprite(SpriteSheet sprite) {
        Sprite = sprite;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Game.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Game.HEIGHT = HEIGHT;
    }

    public static boolean isSound() {
        return sound;
    }

    public static void setSound(boolean sound) {
        Game.sound = sound;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int difficulty) {
        Game.difficulty = difficulty;
    }

    public int getGamesplayed() {
        return gamesplayed;
    }

    public void setGamesplayed(int gamesplayed) {
        this.gamesplayed = gamesplayed;
    }

    public static int getPunteggiofinale() {
        return punteggiofinale;
    }

    public static void setPunteggiofinale(int punteggiofinale) {
        Game.punteggiofinale = punteggiofinale;
    }

    public static Color getColor() {
        return color;
    }

    public static void setColor(Color color) {
        Game.color = color;
    }

    public Hud getHud() {
        return hud;
    }

    public void setHud(Hud hud) {
        this.hud = hud;
    }

    public int getTickTimer() {
        return tickTimer;
    }

    public void setTickTimer(int tickTimer) {
        this.tickTimer = tickTimer;
    }

    public static int getEnemyNumber() {
        return ENEMY_NUMBER;
    }

    public static void setEnemyNumber(int enemyNumber) {
        ENEMY_NUMBER = enemyNumber;
    }

    public int getJ() {
        return J;
    }

    public void setJ(int j) {
        J = j;
    }

    public StartMenu getMn() {
        return mn;
    }

    public void setMn(StartMenu mn) {
        this.mn = mn;
    }

    public static String getSfondo() {
        return sfondo;
    }

    public static void setSfondo(String sfondo) {
        Game.sfondo = sfondo;
    }

    public static boolean isOn() {
        return on;
    }

    public static void setOn(boolean on) {
        Game.on = on;
    }

    public DataSaving getDs() {
        return ds;
    }

    public void setDs(DataSaving ds) {
        this.ds = ds;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Game.title = title;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Random getR1() {
        return r1;
    }

    public void setR1(Random r1) {
        this.r1 = r1;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public MyKeyListener getkL() {
        return kL;
    }

    public void setkL(MyKeyListener kL) {
        this.kL = kL;
    }

    public Spawner getSpawner() {
        return spawner;
    }

    public void setSpawner(Spawner spawner) {
        this.spawner = spawner;
    }

    public OptionPanel getOp() {
        return op;
    }

    public void setOp(OptionPanel op) {
        this.op = op;
    }

    public GamePause getGp() {
        return gp;
    }

    public void setGp(GamePause gp) {
        this.gp = gp;
    }

    public GameSound getEnemyhit() {
        return enemyhit;
    }

    public void setEnemyhit(GameSound enemyhit) {
        this.enemyhit = enemyhit;
    }

    public GameSound getPlayerhit() {
        return playerhit;
    }

    public void setPlayerhit(GameSound playerhit) {
        this.playerhit = playerhit;
    }

    public GameSound getCoinhit() {
        return coinhit;
    }

    public void setCoinhit(GameSound coinhit) {
        this.coinhit = coinhit;
    }

    public GameSound getGameoversound() {
        return gameoversound;
    }

    public void setGameoversound(GameSound gameoversound) {
        this.gameoversound = gameoversound;
    }

    public GameSound getPlay() {
        return play;
    }

    public void setPlay(GameSound play) {
        this.play = play;
    }

    public GameOverScreen getGos() {
        return gos;
    }

    public void setGos(GameOverScreen gos) {
        this.gos = gos;
    }

    public Sfondo getSf() {
        return sf;
    }

    public void setSf(Sfondo sf) {
        this.sf = sf;
    }

    public SoundSettings getSs() {
        return ss;
    }

    public void setSs(SoundSettings ss) {
        this.ss = ss;
    }

    public MovementSettings getMovementSettings() {
        return movementSettings;
    }

    public void setMovementSettings(MovementSettings movementSettings) {
        this.movementSettings = movementSettings;
    }

    public Difficulty getDiff() {
        return diff;
    }

    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }

    public Leaderboard getLd() {
        return ld;
    }

    public void setLd(Leaderboard ld) {
        this.ld = ld;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    int cnt=-1;

    public int Ecollision(GameObject p, Handler handler, ID id){
        int hits=0;
        Rectangle player = new Rectangle((int)p.getX(), (int)p.getY(), 32, 32);
        for(int i=0;i<handler.objList.size();i++) {
            GameObject tmp = handler.objList.get(i);
            if (tmp.getId() != id) {
                continue;
            }
            Rectangle e=new Rectangle((int)tmp.getX(),(int)tmp.getY(),16,16);
            if(player.intersects(e)) {
                if(Game.sound) {
                    playerhit = new GameSound("PLAYERCOLPITO.wav");
                    playerhit.play();
                    playerhit.setVolume(-7.5F);
                }
                hits++;
                //sound = new Util.GameSound("PLAYERCOLPITO.wav");
            }
        }
        return hits;
    }
    public void Ccollision(GameObject p, Handler handler, ID id){
        Rectangle player = new Rectangle((int)p.getX(), (int)p.getY(), 32, 32);
        for(int i=0;i<handler.objList.size();i++) {
            GameObject tmp = handler.objList.get(i);
            if (tmp.getId() != id) {
                continue;
            }
            Rectangle e=new Rectangle((int)tmp.getX(),(int)tmp.getY(),16,16);
            if(player.intersects(e)) {
                if(Game.sound) {
                    coinhit = new GameSound("Coinraccolto.wav");
                    coinhit.play();
                    coinhit.setVolume(-7.5F);
                }
                handler.removeGameObject(tmp);
                this.hud.setScore(hud.getScore()+100);
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
                            if(Game.sound){
                                enemyhit=new GameSound("ENEMYCOLPITO.wav");
                                enemyhit.play();
                                enemyhit.setVolume(-7.5F);
                            }
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
    public  void freezeGame(){
        for(int i=0;i<handler.objList.size();++i){
            GameObject obj=handler.objList.get(i);
            obj.setVelY(0f);
            obj.setVelX(0f);
        }
    }
    public GameObject getObject(Handler handler, ID id, int index) {
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
                if(xpos <=0 || xpos >=WIDTH || ypos <=0 || ypos >=HEIGHT) handler.removeGameObject(handler.objList.get(i));
            }
        }
    }
    private void tick() {

        WIDTH=getBounds().width;
        HEIGHT=getBounds().height;


        if(Game.on) {
            if(Game.sound) {
                gameoversound.stop();
                play.loop();
                play.setVolume(-10F);
            }
            tickTimer++;

            this.handler.tick();
            this.spawner.tick();
            this.hud.tick();
            if(MovementSettings.on) this.movementSettings.tick();
            hud.setHEALTH(hud.getHEALTH()- 2 * Ecollision(getObject(this.handler, ID.Player, 0), this.handler, ID.Enemy));
            Ccollision(getObject(this.handler, ID.Player, 0), this.handler, ID.Coin);
            RemoveBullet(this.handler);
            Bcollision(this.handler);
            if (tickTimer == 65 * difficulty) {
                //System.out.println("spawno un nemico ogni tot " + tickTimer);
                this.handler.addGameObject(new Enemy((float) r1.nextInt(WIDTH), (float) r1.nextInt(HEIGHT), r1.nextInt(5), r1.nextInt(3), ID.Enemy));
                tickTimer = 0;
            }
            if(movementSettings.isChanged()) kL.setChanged(false);

        }

        if(hud.getHEALTH() == 0) {

            ++gamesplayed;
            Game.on=false;
            GameOverScreen.on=true;
            if(Game.sound) {
                play.stop();
                gameoversound.play();
            }
            hud.setHEALTH (255);
            punteggiofinale= hud.getScore();
            hud.setLevel(1);
            hud.setScore(0);
            hud.setKills(0);
            RemoveAllButPlayer(this.handler);
            handler.objList.get(0).setX(350.0F); // reset coordinate x  player
            handler.objList.get(0).setY((float) (HEIGHT - 75));// reset coordinate y player
            for (int i = 0; i < 3; i++) { //spawn nemici
                this.handler.addGameObject(new Enemy((float)r1.nextInt(WIDTH), 0.0F, 2*J, 2.0F, ID.Enemy));
                this.J *= -1;
            }
        }
        if(Leaderboard.on)  this.ld.tick();
        if(StartMenu.on && gamesplayed > 0 && Game.sound){
            gameoversound.stop();
        }
    }
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
        } else {
            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            if(Game.on) {
                g.drawImage(Sprite.getImage(Game.sfondo),0,0,this);
                this.handler.render(g);
                this.hud.render(g);
            }
            if(Leaderboard.on) this.ld.render(g);
            if(GamePause.on) this.gp.render(g);
            if(StartMenu.on) this.mn.render(g);
            if(SoundSettings.on) this.ss.render(g);
            if(OptionPanel.on) this.op.render(g);
            if(Sfondo.on) this.sf.render(g);
            if(MovementSettings.on) this.movementSettings.render(g);
            if(GameOverScreen.on) this.gos.render(g);
            if(Difficulty.on) this.diff.render(g);
            bs.show();
            g.dispose();
        }
    }
    public static void main(String[] args) throws SQLException {

        new Game();
        try {
            DBManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
