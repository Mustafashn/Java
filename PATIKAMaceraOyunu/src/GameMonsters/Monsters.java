/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameMonsters;

/**
 *
 * @author musta
 */
public abstract class Monsters {
    
    private int health;
    private int damage;
    private int money;

    public Monsters( int health, int damage, int money) {
        
        this.health = health;
        this.damage = damage;
        this.money = money;
    }
    
   

    public  int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public  int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void decreaseHealth(int damage) {
        this.health-=damage;
    }
    
}
