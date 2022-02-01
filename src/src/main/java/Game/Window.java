package Game;

import Game.Game;

import javax.swing.*;

public class Window extends JFrame{
    public Window (int width, int height, String title, Game game)  {
        ImageIcon icon = new ImageIcon("icon.png");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

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
