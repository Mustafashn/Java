/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameCharacters;


import java.util.Scanner;

/**
 *
 * @author musta
 */
public abstract class Characters {
    private int damage;
    private int health;
    private int money;
    private static String char_name="";
    private static Scanner scan = new Scanner(System.in);
    private int dodge;
   
    public Characters(int damage,int health,int money) {    
    this.damage=damage;
    this.health=health;
    this.money=money;
    this.dodge=0;
    }
    public static Characters setChar() {
       
        System.out.println("-----------------");
        System.out.println("Karakter Seçim Menüsü");
        System.out.println("-----------------");
        System.out.println("1-Samurai \t Damage: 5 \t Health: 21 \t Money: 15");
        System.out.println("2-Archer \t Damage: 7 \t Health: 18 \t Money: 20");
        System.out.println("3-Knight \t Damage: 8 \t Health: 24 \t Money: 5");
        
        while(true) {
            System.out.print("Seçiminiz: ");
        char_name=scan.nextLine();
            
            if(char_name.equals("Samurai")) {
            Samurai samurai = new Samurai();
            
            return samurai;
        }
        else if(char_name.equals("Archer")) {
            Archer archer = new Archer();
            return archer;
            
        }
        else if (char_name.equals("Knight")) {
            Knight knight = new Knight();
            return knight;
          
        }
        else {
            
        }
        }
        
    }
    
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
   public static String  getCharName() {
       return char_name;
   }
   public void setDodge(int dodge) {
       this.dodge=dodge;
   }
   public int getDodge() {
       return this.dodge;
   }
   public void decreaseHealth(int damage) {
       this.health-=damage;
   }
   public void decreaseMoney(int costs) {
       this.money-=costs;
   }
   public void increaseDodge (int dodge) {
       this.dodge+=dodge;
   }
   public void increaseDamage(int damage) {
       this.damage+=damage;
   }
   public void increaseMoney(int costs) {
       this.money+=costs;
   }
}
