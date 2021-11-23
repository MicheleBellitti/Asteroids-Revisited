import java.awt.*;
public class Difficulty extends OptionPanel{
    private int type;
    static boolean on;
    String[] nomi= new String[3];
    int[] x= new int[3];
    int[] y= new int[3];
    int[] width= new int[3];
    int[] height= new int[3];
    public Difficulty() {
        x[0]=340;
        y[0]=150;
        width[0]=67;
        height[0]=50;
        nomi[0]="EASY";
        x[1]=332;
        y[1]=250;
        width[1]=85;
        height[1]=50;
        nomi[1]="MEDIUM";
        x[2]=342;
        y[2]=350;
        width[2]=67;
        height[2]=50;
        nomi[2]="HARD";
        on=false;
    }
    public void render(Graphics g){
        g.setColor(Color.green);
        Font font=g.getFont();
        g.setFont(new Font("Helvetica",Font.PLAIN,30));
        g.drawString("ASTEROIDS",300,75);
        g.setFont(font);
        g.fillRect(640,500,65,45);
        g.setColor(Color.black);
        g.drawString("BACK",655,530);
        for(int i=0;i<3;i++){
            g.setColor(Color.green);
            g.fillRect(x[i],y[i],width[i],height[i]);
            g.setColor(Color.black);
            g.drawString(nomi[i],x[i]+15,y[i]+30);
        }
    }
}
