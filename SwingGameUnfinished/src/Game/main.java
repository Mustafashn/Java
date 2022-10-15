
package Game;

import GameCharacters.Archer;
import GameCharacters.Knight;
import GameCharacters.Samurai;
import GameLocations.MainArea;
import java.awt.Color;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class main extends JFrame{
    private int counter=0;
    public main (String title) {
        super(title);
    }
    public static void main(String[] args) throws IOException {
        
        main screen = new main("Game Screen");
        
        
       
        screen.setResizable(false);
        screen.setFocusable(false);
        screen.setSize(800,600);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        screen.setBounds(100,100,645,470);
       Border br = BorderFactory.createLineBorder(Color.black);
        
        JButton btn = new JButton("Play");
        btn.setBounds(240,180,200,30);
        
        JTextField txt= new JTextField();
        txt.setBounds(240,60,200,30);
        
        JComboBox<String> cmb_box = new JComboBox<String>();
        cmb_box.setBounds(240,120,200,30);
        cmb_box.addItem("Knight");
        cmb_box.addItem("Archer");
        cmb_box.addItem("Samurai");
        
        JPanel panel = new JPanel();
      
        
        panel.add(btn);
        panel.add(txt);
        panel.add(cmb_box);
        
        
     
        panel.setLayout(null);
      
        
        panel.setBackground(Color.gray);
        panel.setBounds(240,180,200,30);
        
        
      

        panel.setBorder(br);
        
      
        
        screen.add(panel);
        
        screen.setVisible(true);   
        btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) { 
                screen.remove(panel);
                String name =txt.getText();
                Object charachterName =cmb_box.getSelectedItem();
                String charName = charachterName.toString();
                Player player=null;
                if (charName.equals("Knight")) {
                    Knight knight = new Knight();
                    player = new Player(name,knight);
                }
                else if (charName.equals("Archer")) {
                    Archer archer = new Archer();
                    player = new Player(name,archer);
                }
                else if (charName.equals("Samurai")) {
                    Samurai samurai = new Samurai();
                     player = new Player(name,samurai);
                }
                
                screen.setResizable(false);
                screen.setFocusable(false);
                screen.setSize(800,600);
                screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                MainArea ma = null;
                try {
                    ma = new MainArea(player,screen);
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ma.requestFocus();
                ma.addKeyListener(ma);
                ma.setFocusable(true);
                ma.setFocusTraversalKeysEnabled(false); 
                ; 
                screen.add(ma);
                JOptionPane.showMessageDialog(screen, "Welcome "+player.getName());
                screen.setVisible(true);
                
            };
        });
        
       
        /*
        MainArea ma = new MainArea(player,screen);
        
        ma.requestFocus();
        ma.addKeyListener(ma);
        ma.setFocusable(true);
        ma.setFocusTraversalKeysEnabled(false);
        screen.add(ma);
        */
        
        
        
        
    }
    
}
