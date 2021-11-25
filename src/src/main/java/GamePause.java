import java.awt.*;

public class GamePause extends OptionPanel {
    static boolean on;
    static boolean pause;
    int[] x = new int[3];
    int[] width = new int[3];
    int[] height = new int[3];
    int[] y = new int[3];
    String[] nomi=new String[3];
    public GamePause(){
        x[0] = 330;
        y[0]= 250;
        width[0]=100;
        height[0]=50;
        nomi[0]="RESUME";
        x[1] = 333;
        y[1]=350;
        width[1]=100;
        height[1]=50;
        nomi[1]="QUIT";
        x[2] = 342;
        y[2]=150;
        width[2]=75;
        height[2]=50;
       nomi[2]="OPTIONS";
        on=false;
        pause=false;
    }
   /*
    public boolean getMode(){
        return on;
    }
    public void setMode(boolean on){
        this.on=on;

    }

    */
    public void render(Graphics g){
        g.setColor(Color.red);
        Font font=g.getFont();
        g.setFont(new Font("Helvetica",Font.PLAIN,30));
        g.drawString("ASTEROIDS",300,75);
        g.setFont(font);
        for(int i=0;i<3;i++){
            g.setColor(Color.red);
            g.fillRect(x[i],y[i],width[i],height[i]);
            g.setColor(Color.BLACK);
            g.drawString(nomi[i],x[i]+15,y[i]+30);

        }
    }
}
