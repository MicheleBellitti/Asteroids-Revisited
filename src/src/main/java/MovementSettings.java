import java.awt.*;

public class MovementSettings {
    String[] keys=new String[4];
    private boolean changed=false;
    int[] x= new int[5];
    int[] y= new int[5];
    int[] width= new int[5];
    int[] height= new int[5];
    static boolean on;
    public MovementSettings() {
        keys[0]="UP";
        keys[1]="LEFT";
        keys[2]="RIGHT";
        keys[3]="DOWN";

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
    void tick() {
    if(   keys[0]!="UP" || keys[1]!="LEFT"|| keys[2]!="RIGHT" || keys[3]!="DOWN"){
        changed=true;
        keys[0]="W";
        keys[1]="A";
        keys[2]="D";
        keys[3]="S";
    }
    else{
        changed=false;
        keys[0]="UP";
        keys[1]="LEFT";
        keys[2]="RIGHT";
        keys[3]="DOWN";
    }

    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public  String getKey(int index){
        return keys[index];
    }
    public void setKey(String string,int index){
        this.keys[index]=string;
    }
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        Font font=g.getFont();
        g.setFont(new Font("Helvetica",Font.PLAIN,30));
        g.drawString("ASTEROIDS",300,75);
        g.setFont(font);
        g.fillRect(640,500,65,45);
        g.setColor(Color.black);
        g.drawString("BACK",655,530);
        for(int i=0;i<4;i++){
            g.setColor(Color.WHITE);
            g.drawRect(x[i],y[i],width[i],height[i]);

            g.drawString(keys[i],x[i]+15,y[i]+30);
        }

    }
}
