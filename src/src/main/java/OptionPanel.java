import java.awt.*;
public class OptionPanel extends StartMenu{
    static boolean on;
    int[] x= new int[5];
    int[] y= new int[5];
    int[] width= new int[5];
    int[] height= new int[5];
    String[] nomi= new String[5];
    public OptionPanel() {
        nomi[0]="SFONDO";
        nomi[1]="CONTROLLI";
        nomi[2]="DIFFICOLTA'";
        nomi[3]="SUONO";
        nomi[4]="BACK";
        x[0] = 330;
        y[0]= 250;
        width[0]=100;
        height[0]=50;
        x[1] = 333;
        y[1]=350;
        width[1]=100;
        height[1]=50;
        x[2] = 330;
        y[2]=150;
        width[2]=104;
        height[2]=50;
        x[3] = 343;
        y[3]=450;
        width[3]=83;
        height[3]=50;
        x[4]=640;
        y[4]=500;
        width[4]=65;
        height[4]=45;
        on=false;
    }
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        g.drawString("ASTEROIDS",340,75);
        for(int i=0;i<5;i++){
            g.setColor(Color.YELLOW);
            g.fillRect(x[i],y[i],width[i],height[i]);
            g.setColor(Color.BLACK);
            g.drawString(nomi[i],x[i]+15,y[i]+30);
        }
    }
}
