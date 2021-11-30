import java.awt.*;
public class GameOverScreen  {
    int[] x = new int[3];
    int[] y = new int[3];
     int[] width = new int[3];
     int[] height = new int[3];
     static String[] nomi= new String[3];
    static boolean on;
    static boolean saved;
    public GameOverScreen() {
        nomi[0]="PLAY AGAIN";
        nomi[1]="BACK TO MENU";
        nomi[2]="SAVE";
        x[0] = 315;
        y[0] = 190;
        width[0] = ((100/14)* nomi[0].length())+ (6* nomi[0].length());
        height[0] = 50;
        x[1] = 297;
        y[1] = 290;
        width[1] = (((100/14) +1)* nomi[1].length())+ (6* nomi[1].length());
        height[1] = 50;
        x[2] = 351;
        y[2] = 390;
        width[2] = (((100/14)+1) * nomi[2].length())+ (6* nomi[2].length());
        height[2] = 50;
        on = false;
        saved=false;
    }
    public void render(Graphics g) {
        Font font=g.getFont();
        g.setColor(Color.RED);
        g.setFont(new Font("Helvetica",Font.PLAIN,30));
        g.drawString("GAME OVER", 300, 75);
        g.setFont(font);
        g.drawString("SCORE: "+ Game.punteggiofinale, 345, 135);
        for(int i=0;i<3;i++){
            g.setColor(Color.red);
            g.fillRect(x[i],y[i],width[i],height[i]);
            g.setColor(Color.BLACK);
            g.drawString(nomi[i],x[i]+(3*nomi[i].length()),y[i]+30);
        }
        }
    }

