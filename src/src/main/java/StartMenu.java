import java.awt.*;

public class StartMenu  {
    //private String[] checking = new String[3];
    int[] x = new int[3];
    int[] y = new int[3];
    int[] width = new int[3];
    int[] height = new int[3];
    ID StartMenu;
    public StartMenu() {
        x[0]= 100;
        y[0]= 100;
        width[0] = 100;
        height[0] = 100;
        x[1]= 400;
        y[1]= 400;
        width[1] = 100;
        height[1] = 100;
        x[2] = 0;
        //ciao
        y[2] = 0;
        width[2] = 100;
        height[2] = 100;
    }
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x[0], y[0], width[0], height[0]);
        g.fillRect(x[1], y[1], width[1], height[1]);
        g.fillRect(x[2], y[2], width[2], height[2]);
        g.setColor(Color.RED);
        g.drawString("PLAY",200,200);

    }


}



