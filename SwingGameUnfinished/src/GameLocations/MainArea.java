package GameLocations;

import Game.Player;
import Game.main;
import java.awt.Color;
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
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.Border;

public class MainArea extends JPanel implements KeyListener,ActionListener{
    private Timer timer = new Timer(5,this);
    private BufferedImage imageCharacter;
    private BufferedImage imagePortal;
    private BufferedImage imageArea;
    private int positionX=350;
    private int positionY=225;
    private Rectangle characterRectangle;
    private Rectangle leftPortal ;
    private Rectangle upPortal;
    private Rectangle rightPortal;
    private Rectangle downPortal;
    private int portalWeight;
    private int portalHeight;
    private Player player;
    private main screen1;
    public MainArea (Player player,main screen1) throws FileNotFoundException, IOException {
        this.player=player;
        if (this.player.getId()==1) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+1+".png")));
        }
        else if (this.player.getId()==2) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+2+".png")));
        }
        else if (this.player.getId()==3) {
            imageCharacter = ImageIO.read(new FileInputStream(new File("Characters\\"+3+".png")));
        }
        imagePortal = ImageIO.read(new FileInputStream(new File("portal.png")));
        this.portalHeight=imagePortal.getHeight()/5;
        this.portalWeight=imagePortal.getWidth()/5;
        imageArea= ImageIO.read(new FileInputStream(new File("area.png")));
        this.leftPortal = new Rectangle(0,250,portalHeight,portalHeight);
        this.upPortal = new Rectangle(350,0,portalHeight,portalWeight);
        this.rightPortal= new Rectangle(650,250,portalHeight,portalWeight);
        this.downPortal = new Rectangle(350,450,portalHeight,portalWeight);
        timer.start();
        this.screen1=screen1;
        
        
    }
    public int check() {
        this.characterRectangle= new Rectangle(positionX,positionY,imageCharacter.getWidth()/5,imageCharacter.getHeight()/5);
        if (leftPortal.intersects(characterRectangle)) {
            return 1;
        }
        else if (upPortal.intersects(characterRectangle)) {
            return 2;
        }
        else if (rightPortal.intersects(characterRectangle)) {
            return 3;
        }
        else if (downPortal.intersects(characterRectangle)) {
            return 4;
        }
        return -1;
    }
    
    @Override 
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(imageArea,0,0,800,600,this);
        g.drawImage(imageCharacter, this.positionX, this.positionY,imageCharacter.getWidth()/5,imageCharacter.getHeight()/5, this);
        //Left portal 1 
        g.drawImage(imagePortal,0,250,imagePortal.getWidth()/5,imagePortal.getHeight()/5,this);
        //Up portal  2 
        g.drawImage(imagePortal,350,0,imagePortal.getWidth()/5,imagePortal.getHeight()/5,this);
        //Right portal 3 
        g.drawImage(imagePortal,650,250,imagePortal.getWidth()/5,imagePortal.getHeight()/5,this);
        //Down portal  4
        g.drawImage(imagePortal,350,450,imagePortal.getWidth()/5,imagePortal.getHeight()/5,this);
        if (check() ==1) {
           this.screen1.setVisible(false);
           
                
           JProgressBar pg  = new JProgressBar();
                pg.setBounds(450,500,200,30);
                pg.setMinimum(0);
                pg.setMaximum(this.player.getCharacter().getHealth());
                pg.setValue(this.player.getHealth());
                pg.setBackground(Color.white);
                pg.setForeground(Color.red);
                
                main screen = new main("SafeHouse");
                
           screen.setResizable(false);
           screen.setFocusable(false);
           
           screen.setSize(800,600);
           screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           
           PanelSafeHouse psh = null;
            try {
                psh = new PanelSafeHouse(this.player,screen);
            } catch (IOException ex) {
                Logger.getLogger(MainArea.class.getName()).log(Level.SEVERE, null, ex);
            }
           psh.setLayout(null);
                psh.setBounds(600, 800, 200, 30);
                
            
            psh.requestFocus();
           psh.addKeyListener(psh);
           psh.setFocusable(true);
           psh.setFocusTraversalKeysEnabled(false);
           psh.add(pg);
           screen.add(psh);
           
           screen.setVisible(true);
           
           timer.stop();
           
           
           
        }
        else if (check() ==2) {
            this.screen1.setVisible(false);
            JProgressBar pg  = new JProgressBar();
                pg.setBounds(450,500,200,30);
                pg.setValue(50);
            main screen = new main("Cave");
           screen.setResizable(false);
           screen.setFocusable(false);
           
           screen.setSize(800,600);
           screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           PanelCave pc = null;
            try {
                pc = new PanelCave(this.player,screen);
            } catch (IOException ex) {
                Logger.getLogger(MainArea.class.getName()).log(Level.SEVERE, null, ex);
            }
           pc.setLayout(null);
                pc.setBounds(600, 800, 200, 30);
                pc.add(pg);
            pc.requestFocus();
           pc.addKeyListener(pc);
           pc.setFocusable(true);
           pc.setFocusTraversalKeysEnabled(false);
           screen.add(pc);
           screen.setVisible(true);
           timer.stop();
        }
        else if (check()==3) {
            this.screen1.setVisible(false);
            main screen = new main("Forest");
            screen.setResizable(false);
            screen.setFocusable(false);
            screen.setSize(800,600);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PanelForest pf = null;
            try {
                pf = new PanelForest(player,screen);
            } catch (IOException ex) {
                Logger.getLogger(MainArea.class.getName()).log(Level.SEVERE, null, ex);
            }
           pf.requestFocus();
           pf.addKeyListener(pf);
           pf.setFocusable(true);
           pf.setFocusTraversalKeysEnabled(false);
           screen.add(pf);
           screen.setVisible(true);
           timer.stop();
            
            
        }
        else if (check()==4) {
            this.screen1.setVisible(false);
            main screen = new main("Forest");
            screen.setResizable(false);
            screen.setFocusable(false);
            screen.setSize(800,600);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PanelRiver pr = null;
            try {
                pr = new PanelRiver(this.player,screen);
            } catch (IOException ex) {
                Logger.getLogger(MainArea.class.getName()).log(Level.SEVERE, null, ex);
            }
            pr.requestFocus();
           pr.addKeyListener(pr);
           pr.setFocusable(true);
           pr.setFocusTraversalKeysEnabled(false);
           screen.add(pr);
           screen.setVisible(true);
           timer.stop();
        }
    }
    @Override
    public void repaint() {
        super.repaint(); 
    }
    @Override
    public void keyTyped(KeyEvent e) {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       repaint();
    }
}
