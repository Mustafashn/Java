package GameLocations;


import Game.Fight;
import Game.Player;
import Game.main;
import GameMonsters.Vampire;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelRiver extends JPanel implements  KeyListener ,ActionListener{
    private BufferedImage imageRiver;
    private BufferedImage imageVampire;
     private BufferedImage imageCharacter;
    private BufferedImage imageDoor;
    private BufferedImage imageCoin;
    private Rectangle characterRectangle;
    private Rectangle doorPortal ;
    private Rectangle vampireRectangle;
    private Rectangle coinRectangle;
    private int positionX =300;
    private int positionY=400;
    private boolean vampireBoolean= true;
    private boolean coinBoolean =true;
    private Vampire vampire;
    private Timer timer = new Timer(1,this);
    private main screen1;
    private Player player;
    private boolean characterboolean=true;
    private int counter=0;
    private int monsterPositionX=300;
    private int monsterPositionY=300;
    
    public PanelRiver(Player player, main screen1) throws FileNotFoundException, IOException {
        this.player=player;
        this.screen1=screen1;
        if (this.player.getId()==1) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+1+".png")));
        }
        else if (this.player.getId()==2) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+2+".png")));
        }
        else if (this.player.getId()==3) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+3+".png")));
        }
        this.imageRiver=ImageIO.read(new FileInputStream(new File("River\\river.jpg")));
        this.imageDoor = ImageIO.read(new FileInputStream(new File("Cave\\house_door.png")));
        this.imageVampire =ImageIO.read(new FileInputStream(new File("River\\vampire.png")));
        this.imageCoin = ImageIO.read(new FileInputStream(new File("gold_coin.png")));
       this.doorPortal = new Rectangle(700,0,imageDoor.getWidth()/5,imageDoor.getHeight()/5);
       this.coinRectangle = new Rectangle(400,0,imageCoin.getHeight()/10,imageCoin.getWidth()/10);
       this.vampire= new Vampire();
       timer.start();
    }
public boolean checkMonsterFight() {
        Fight fight = new Fight(this.player, vampire);
        if (characterRectangle.intersects(vampireRectangle)) {
            this.characterboolean= fight.monsterHit();
            
       }
        return true;
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
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        g.drawImage(imageRiver,0, 0,800,600, this);
        g.drawImage(imageDoor,700,0,imageDoor.getWidth()/5,imageDoor.getHeight()/5,this);
        this.vampireRectangle = new Rectangle(monsterPositionX,monsterPositionY,imageVampire.getHeight()/7,imageVampire.getWidth()/7);

        if (characterboolean) {
         g.drawImage(imageCharacter, positionX, positionY, imageCharacter.getWidth()/5,imageCharacter.getHeight()/5,this);

        }
        if (this.vampireBoolean) {
            g.drawImage(this.imageVampire,300, 300,imageVampire.getHeight()/7,imageVampire.getWidth()/7,this);
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
    public void repaint() {
        super.repaint(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        
        Fight fight = new Fight(this.player, this.vampire);
        if (this.characterRectangle.intersects(this.vampireRectangle)) {
            this.vampireBoolean= fight.playerHit();
            
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
