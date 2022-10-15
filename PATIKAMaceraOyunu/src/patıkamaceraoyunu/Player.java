/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patıkamaceraoyunu;

import GameCharacters.Characters;
import java.awt.BorderLayout;

/**
 *
 * @author musta
 */
public class Player extends Characters{
    private Inventory inventory;
    private String name;
    private Characters characters;
    private int charHealth;
    public Player(String name,Characters characters) {
        super(characters.getDamage(),characters.getHealth(),characters.getMoney());
        this.characters=characters;
        this.name = name;
        this.charHealth=characters.getHealth();
    }
    public int getCharHealth() {
        return this.charHealth;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isBuy(int cost) {
        if(cost>this.getMoney()) {
            System.out.println("Paranız yetmemektedir...");
            System.out.println("Paranız : "+this.getMoney());
            return false;
        }
        else {
            this.characters.decreaseMoney(cost);
            System.out.println("Satın alım başarılı");
            return true;
        }
    }
}
