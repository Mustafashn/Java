/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameLocations;

import patıkamaceraoyunu.Player;

/**
 *
 * @author musta
 */
public class SafeHouse extends Location{

    private Player player;
    private int health;

    public SafeHouse(Player player) {
        super(player);      
        this.player=player;
    }

   
    public void setHealth(int health) {
        player.setHealth(health);
    }

    public int getHealth() {
        return this.health;
    }

    public void increaseHealth() {
        this.health = this.player.getCharHealth();
    }
}
