import java.awt.*;

public class OptionPanel extends StartMenu{
   static boolean on;
    int[] x= new int[4];
    int[] y= new int[4];
    int[] width= new int[4];
    int[] height= new int[4];
    String[] nomi= new String[4];
     public OptionPanel() {
        nomi[0]="LUMINOSITA";
        nomi[1]="DIFFICOLTA";
        nomi[2]="LINGUA";
        nomi[3]="SFONDO";
        x[0] = 330;
        y[0]= 250;
        width[0]=100;
        height[0]=50;
        x[1] = 333;
        y[1]=350;
        width[1]=100;
        height[1]=50;
        x[2] = 342;
        y[2]=150;
        width[2]=75;
        height[2]=50;
        x[3] = 343;
        y[3]=450;
        width[3]=83;
        height[3]=50;
        on=false;
    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.drawString("ASTEROIDS",340,75);
        for(int i=0;i<4;i++){
            g.setColor(Color.white);
            g.fillRect(x[i],y[i],width[i],height[i]);
            g.setColor(Color.red);
            g.drawString(nomi[i],x[i]+15,y[i]+30);
        }

    }
}
