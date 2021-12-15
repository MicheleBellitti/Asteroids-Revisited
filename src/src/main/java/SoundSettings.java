import javax.sound.sampled.Mixer;
import java.awt.*;
public class SoundSettings extends OptionPanel {
    int x[]= new int[2];
    int y[]=new int[2];
    int width[]= new int[2];
    int height[]= new int[2];
    String [] nomi= new String[2];
    static boolean on;
    public SoundSettings(){
        x[0]=340;
        y[0]=150;
        width[0]=100;
        height[0]=50;
        nomi[0]="ON";
        x[1]=340;
        y[1]=250;
        width[1]=100;
        height[1]=50;
        nomi[1]="OFF";
        on=false;
    }
    public void render(Graphics g){
        g.setColor(Color.pink);
        Font font=new Font(g.getFont().getName(),Font.PLAIN,g.getFont().getSize()*Game.WIDTH/786);
        g.setFont(new Font("Helvetica",Font.PLAIN,30));
        g.drawString("ASTEROIDS",300,75);
        g.setFont(font);
        g.fillRect(640,500,65,45);
        g.setColor(Color.black);
        g.drawString("BACK",655,530);
        for(int i=0;i<2;i++){
            g.setColor(Color.pink);
            g.fillRect(x[i],y[i],width[i],height[i]);
            g.setColor(Color.BLACK);
            g.drawString(nomi[i],x[i]+35,y[i]+30);
        }
    }
}
