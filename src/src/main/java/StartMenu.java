import java.awt.*;

public class StartMenu  {
    //private String[] checking = new String[3];
    int[] x = new int[3];
    int[] y = new int[3];
    int[] width = new int[3];
    int[] height = new int[3];
    String [] nomi= new String[3];
    ID StartMenu;
    static boolean on;
    public StartMenu() {
        nomi[0]="PLAY";
        nomi[1]="LEADERBOARD";
        nomi[2]="OPTIONS";
        ID StartMenu;

        //PLAY
        x[0]= 325;
        y[0]= 150;
        width[0] = 100;
        height[0] = 50;

        //LEADERBOARD
        x[1]= 300;
        y[1]= 275;
        width[1] = 158;
        height[1] = 53;

        //OPTIONS
        x[2]= 320;
        y[2]= 400;
        width[2] = 120;
        height[2] = 50;

        on=true;
    }
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawString("ASTEROIDS",340,75);
         for(int i=0;i<3;i++) {
          g.setColor(Color.WHITE);
          g.fillRect(x[i], y[i], width[i], height[i]);
          g.setColor(Color.RED);
          g.drawString(nomi[i],x[i]+33,y[i]+30);
      }

    }


}



