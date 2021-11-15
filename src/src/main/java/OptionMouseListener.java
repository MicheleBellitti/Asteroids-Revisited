import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class OptionMouseListener extends MouseAdapter {
  private Handler handler;
    int mx,my;
    public OptionMouseListener(Handler handler) {
        this.handler=handler;

    }

    public void mouseClicked(MouseEvent e) {
        mx=e.getX();
        my=e.getY();
        if(OptionPanel.on){



        }
    }

    public void mousePressed(MouseEvent e) {
        mx=e.getX();
        my=e.getY();
        if(OptionPanel.on){



        }
    }



}
