
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class GameScreen extends JFrame{

    public GameScreen(String title) {
        super(title);
    }
    
    public static void main(String[] args) {
        try {
            GameScreen screen = new GameScreen("Space Game");
            screen.setResizable(false);
            screen.setFocusable(false);
            
            screen.setSize(800,600);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            Game game = new Game();
            
            game.requestFocus();
            
            game.addKeyListener(game);
            
            game.setFocusable(true);
            
            game.setFocusTraversalKeysEnabled(false);
            
            screen.add(game);
            
            screen.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
