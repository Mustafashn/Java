/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patıkamaceraoyunu;

import GameMonsters.Monsters;

/**
 *
 * @author musta
 */
public class Fight {
    private Player player;
    private Monsters monster;

    public Fight(Player player, Monsters monster) {
        this.player = player;
        this.monster = monster;
    }
    public void Hit () throws InterruptedException  {
        System.out.println("Dövüş başladı!!");
        int i =0;
        while(isEnd()) {
            if(i%2==0) {
                System.out.println("Karakter saldırıyor...");
                this.monster.decreaseHealth(this.player.getDamage());
                if(this.monster.getHealth()<=0) {
                    System.out.println("Canavarın canı : 0 ");
                }
                else {
                    System.out.println("Canavarın canı :"+this.monster.getHealth());
                }
            }
            else {
                System.out.println("Canavar saldırıyor...");
                this.player.decreaseHealth(this.monster.getDamage()-this.player.getDodge());
                if(this.player.getHealth()<=0) {
                    System.out.println("Karakterin canı : 0 ");
                }
                else {
                    System.out.println("Karakterin canı : "+this.player.getHealth());
                }
            }
        i+=1;
        Thread thread = new Thread();
        thread.sleep(1000);
        }
    }
    private boolean isEnd() {
        if (this.monster.getHealth()<=0 || this.player.getHealth()<=0) {
        return false;
    }
        return true;
            
        
    }
}