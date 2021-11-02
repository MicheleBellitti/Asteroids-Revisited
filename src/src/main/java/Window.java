import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public Window (int width, int height, String title, Game game)  {

        ImageIcon icon = new ImageIcon("C:\\Users\\Michele\\OneDrive\\Immagini\\Saved Pictures\\R.jpg");
        setIconImage(icon.getImage());
        setTitle(title);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width*width,height*height));
        setMinimumSize(new Dimension(width,height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAutoRequestFocus(true);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        add(game);

    }

}
