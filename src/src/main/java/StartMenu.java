import java.awt.*;

public class StartMenu  {
    //private String[] checking = new String[3];
    int[] x = new int[4];
    int[] y = new int[4];
    int[] width = new int[4];
    int[] height = new int[4];
    String [] nomi= new String[4];
    ID StartMenu;
    static boolean on;
    public StartMenu() {
        nomi[0]="PLAY";
        nomi[1]="LEADERBOARD";
        nomi[2]="OPTIONS";
        nomi[3]="BACK";
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

       /* x[3]=0;
        x[3]=0;
        width[3]=100;
        height[3]=50;
*/
        on=true;
    }
    public void render(Graphics g) {
        g.setColor(Color.red);
        Font font=g.getFont();
        g.setFont(new Font("Helvetica",Font.PLAIN,30));
        g.drawString("ASTEROIDS",300,75);
        g.setFont(font);
         for(int i=0;i<4;i++) {
          g.setColor(Color.red);
          g.fill3DRect(x[i], y[i], width[i], height[i],true);
          g.setColor(Color.BLACK);
          g.drawString(nomi[i],x[i]+33,y[i]+30);
      }

    }


}



