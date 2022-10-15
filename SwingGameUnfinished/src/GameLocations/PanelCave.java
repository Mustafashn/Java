
package GameLocations;
import GameMonsters.Zombie;
import Game.Fight;
import Game.Player;
import Game.main;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class PanelCave extends JPanel implements  KeyListener,ActionListener{
    private BufferedImage imageCave;
    private BufferedImage imageZombie;
    private BufferedImage imageCharacter;
    private BufferedImage imageDoor;
    private BufferedImage imageCoin;
    private Rectangle characterRectangle;
    private Rectangle doorPortal ;
    private Rectangle zombieRectangle;
    private Rectangle coinRectangle;
    private int positionX =300;
    private int positionY=400;
    private int monsterPositionX=300;
    private int monsterPositionY=300;
    private Timer timer = new Timer(1,this);
    private boolean zombieBoolean= true;
    private boolean coinBoolean =true;
    private Player player;
    private Zombie zombie;
    private main screen1;
    private int counter=0;
    private boolean characterboolean=true;
    public PanelCave (Player player,main screen1) throws IOException {
        this.player=player;
        this.imageCave=ImageIO.read(new FileInputStream(new File("Cave\\cave.png")));
        this.imageZombie=ImageIO.read(new FileInputStream(new File("Cave\\zombie.png")));
        if (this.player.getId()==1) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+1+".png")));
        }
        else if (this.player.getId()==2) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+2+".png")));
        }
        else if (this.player.getId()==3) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+3+".png")));
        }
        this.imageDoor = ImageIO.read(new FileInputStream(new File("Cave\\house_door.png")));
        this.imageCoin = ImageIO.read(new FileInputStream(new File("gold_coin.png")));
        this.doorPortal = new Rectangle(700,0,imageDoor.getWidth()/5,imageDoor.getHeight()/5);
        this.zombie= new Zombie();
        this.screen1=screen1;
        timer.start();
    }
    public boolean checkCoin() {
        this.characterRectangle = new Rectangle(positionX,positionY,imageCharacter.getWidth()/10,imageCharacter.getHeight()/10);
        if (characterRectangle.intersects(this.coinRectangle)) {
            return true;
        }
        return false;
    }
    public boolean checkPortal() {
        this.characterRectangle = new Rectangle(positionX,positionY,imageCharacter.getWidth()/5,imageCharacter.getHeight()/5);
        if(characterRectangle.intersects(doorPortal)) {
            return true;
        }
        return false;
    }
    public boolean checkMonsterFight() {
        Fight fight = new Fight(this.player, this.zombie);
        if (characterRectangle.intersects(zombieRectangle)) {
            this.characterboolean= fight.monsterHit();
            
       }
        return true;
    }
    @Override
   
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        g.drawImage(imageCave,0,0, 800, 600, this);
        this.zombieRectangle=new Rectangle(monsterPositionX,monsterPositionY,imageZombie.getHeight()/5,imageZombie.getWidth()/5);
        g.drawImage(imageDoor,700,0,imageDoor.getWidth()/5,imageDoor.getHeight()/5,this);
        
        if (characterboolean) {
            g.drawImage(imageCharacter, positionX, positionY, imageCharacter.getWidth()/5,imageCharacter.getHeight()/5,this);
        }
        if (zombieBoolean) {
            
            g.drawImage(imageZombie,monsterPositionX,monsterPositionY, imageZombie.getHeight()/4, imageZombie.getWidth()/4, this);
            if (characterboolean) {
            this.counter++;
            
            
            if (counter ==100) {
                
                checkMonsterFight();
                counter=0;
                
                
            }
        }
        }
        else {
            this.monsterPositionX=1500;
            this.monsterPositionY=1500;
            if (this.coinBoolean) {
                g.drawImage(imageCoin,400,0,imageCoin.getHeight()/10,imageCoin.getWidth()/10,this);
                this.coinRectangle = new Rectangle(400,0,imageCoin.getHeight()/10,imageCoin.getWidth()/10);
                if (checkCoin()) {
                    this.coinBoolean=false;
                }
            }
               
            
        }
        
        if (checkPortal()) {
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
                Logger.getLogger(PanelCave.class.getName()).log(Level.SEVERE, null, ex);
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
    public void repaint(int x, int y, int width, int height) {
        super.repaint(x, y, width, height); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        if (c== KeyEvent.VK_F) {
           this.characterRectangle= new Rectangle(positionX,positionY,imageCharacter.getWidth()/5,imageCharacter.getHeight()/5);
        
        Fight fight = new Fight(this.player, this.zombie);
        if (characterRectangle.intersects(zombieRectangle)) {
            this.zombieBoolean= fight.playerHit();
           
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
