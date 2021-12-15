import javax.swing.*;
import java.awt.*;
public class Window extends JFrame{
    public Window (int width, int height, String title, Game game)  {
        ImageIcon icon = new ImageIcon("./src/src/main/resources/icon.png");
        setIconImage(icon.getImage());
        setTitle(title);
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAutoRequestFocus(true);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        add(game);
    }
}
