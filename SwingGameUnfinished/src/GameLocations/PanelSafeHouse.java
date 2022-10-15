package GameLocations;
import Game.Player;
import Game.main;
import GameCharacters.Character;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelSafeHouse extends JPanel implements  KeyListener,ActionListener{
    private Timer timer = new Timer(5,this);
    private Character character;
    private BufferedImage imageBed;
    private BufferedImage imageCharacter;
    private BufferedImage imageKitchen;
    private BufferedImage imageDoor;
    private Rectangle characterRectangle;
    private Rectangle doorPortal ;
    private int positionX=400;
    private int positionY=400;
    private Player player;
    private main screen1;
//  private int x;
    public PanelSafeHouse(Player player,main screen1) throws IOException {
        this.player=player;
        imageBed = ImageIO.read(new FileImageInputStream(new File("SafeHouse\\bed.png")));
        imageKitchen = ImageIO.read(new FileImageInputStream(new File("SafeHouse\\kitchen.png")));
        if (this.player.getId()==1) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+1+".png")));
        }
        else if (this.player.getId()==2) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+2+".png")));
        }
        else if (this.player.getId()==3) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+3+".png")));
        }
        imageDoor = ImageIO.read(new FileInputStream(new File("SafeHouse\\house_door.png")));
        this.doorPortal=new Rectangle(700,0,imageDoor.getWidth()/5,imageDoor.getHeight()/5);
        setBackground(Color.GRAY);
        this.screen1= screen1;
// this.x = character.getCharacterX();
        timer.start();
    }

    @Override
    public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
        return super.getListeners(listenerType); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    public int check() {
        this.characterRectangle=new Rectangle(positionX,positionY,imageCharacter.getWidth()/5,imageCharacter.getHeight()/5);
        if (doorPortal.intersects(characterRectangle)) {
            return 1;
        }
        return -1;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        g.drawImage(imageBed, 0, 0, imageBed.getWidth()/5,imageBed.getHeight()/5,this);
        g.drawImage(imageKitchen, 125,0 , imageKitchen.getWidth()/5,imageKitchen.getHeight()/5,this);
        g.drawImage(imageDoor, 700,0 , imageDoor.getWidth()/5,imageDoor.getHeight()/5,this);
        g.drawImage(imageCharacter, positionX, positionY, imageCharacter.getWidth()/5,imageCharacter.getHeight()/5,this);
        if (check() ==1) {
           this.screen1.setVisible(false);
            main screen = new main("Game");
           screen.setResizable(false);
           screen.setFocusable(false);
           
           screen.setSize(800,600);
           screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           MainArea ma = null;
            try {
                ma = new MainArea(this.player,screen);
            } catch (IOException ex) {
                Logger.getLogger(PanelSafeHouse.class.getName()).log(Level.SEVERE, null, ex);
            }
           ma.requestFocus();
           ma.addKeyListener(ma);
           ma.setFocusable(true);
           ma.setFocusTraversalKeysEnabled(false);
           screen.add(ma);
           screen.setVisible(true);
           timer.stop();
        }
    }

    @Override
    public void repaint() {
        super.repaint(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public int checkImage(Image image, ImageObserver observer) {
        return super.checkImage(image, observer); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c =e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            if(this.positionX<=0) {
                positionX=0;
            }
            else {
                
                positionX-=5;
                
            }
       
    }
    if (c == KeyEvent.VK_RIGHT) {
            if(this.positionX>=700) {
                positionX=700;
            }
            else {
                
                positionX+=5;
                
            }
        }
    if (c == KeyEvent.VK_UP) {
            if(this.positionY<=0) {
                positionY=0;
            }
            else {
                
                positionY-=5;
                
            }
        }
    if (c == KeyEvent.VK_DOWN) {
            if(this.positionY>=500) {
                positionY=500;
            }
            else {
                
                positionY+=5;
                
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
    }
    
}
