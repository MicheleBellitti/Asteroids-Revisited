import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public Window (int width, int height, String title, Game game)  {
        ImageIcon icon = new ImageIcon("C:\\Users\\Michele\\OneDrive\\Desktop\\pngtree-blue-samurai-esports-logo-gaming-mascot-logo-png-image_1003048.jpg");
        setIconImage(icon.getImage());
        setTitle(title);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width*width,height*height));
        setMinimumSize(new Dimension(width,height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAutoRequestFocus(true);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);
        add(game);

    }

}
