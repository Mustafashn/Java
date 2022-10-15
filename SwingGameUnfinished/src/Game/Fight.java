
package Game;

import GameMonsters.Monster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Fight implements KeyListener,ActionListener {
  private static Monster monster;
  private static Player player;
  
  public Fight(Player player,Monster monster) {
      this.player=player;
      this.monster=monster;
  }
  public static boolean  playerHit() {
      if (monster.getHealth()>player.getDamage()) {
          monster.setHealth(monster.getHealth()-player.getDamage());
          return true;
      }
      else {
          monster.setHealth(0);
          return false;
      }
  }
  public static boolean monsterHit() {
      if (player.getHealth()>monster.getDamage()) {
          player.setHealth(player.getHealth()-monster.getDamage());
          return true;
      }
      else {
          player.setHealth(0);
          return false;
      }
  }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
