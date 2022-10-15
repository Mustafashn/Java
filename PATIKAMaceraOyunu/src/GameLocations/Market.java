/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameLocations;

import GameArmors.HeavyArmor;
import GameArmors.LightArmor;
import GameArmors.MediumArmor;
import GameWeapons.Pistol;
import GameWeapons.Rifle;
import GameWeapons.Sword;
import java.util.Scanner;
import patıkamaceraoyunu.Player;

/**
 *
 * @author musta
 */
public class Market extends Location {
    private  Scanner scan = new Scanner(System.in);
    private Player player;
    public String Guns = "Silahlar \n"
            + "1-Pistol \n \t Hasar = 2 \n \t Para = 25 \n "
            + "2-Sword \n \t Hasar = 3 \n \t Para = 35 \n "
            + "3-Rifle \n \t Hasar = 7 \n \t Para = 45 \n ";
    public String Armors = "Kalkanlar \n "
            + "1-Light Armor \n \t Engelleme = 1 \n \t Para = 15 \n "
            + "2-Medium Armor \n \t Engelleme = 3 \n \t Para = 25 \n "
            + "3-Heavy Armor \n \t Engelleme = 5 \n \t Para = 40 \n ";

    public Market(Player player) {
        super(player);
        this.player = player;
    }

  
 

    public void setArmors() {
         
            System.out.println(Armors);
            System.out.print("Kalkan seçiniz: ");
            String armor_name = scan.nextLine();
            if (armor_name.equals("Light Armor")) {
                LightArmor lArmor = new LightArmor();
                boolean is = player.isBuy(lArmor.getMoney());
                if (is) {
                    player.decreaseMoney(lArmor.getMoney());
                    player.increaseDodge(lArmor.getDodge());
                    System.out.println("Güncel para: " + player.getMoney());
                    System.out.println("Güncel zırh: " + player.getDodge());
                }
            } else if (armor_name.equals("Heavy Armor")) {
                HeavyArmor hArmor = new HeavyArmor();
                boolean is = player.isBuy(hArmor.getMoney());
                if (is) {
                    player.decreaseMoney(hArmor.getMoney());
                    player.increaseDodge(hArmor.getDodge());
                    System.out.println("Güncel para: " + player.getMoney());
                    System.out.println("Güncel zırh: " + player.getDodge());
                }
            } else if (armor_name.equals("Medium Armor")) {
                MediumArmor mArmor = new MediumArmor();
                boolean is = this.player.isBuy(mArmor.getMoney());
                if (is) {
                    player.decreaseMoney(mArmor.getMoney());
                    player.increaseDodge(mArmor.getDodge());
                    System.out.println("Güncel para: " + player.getMoney());
                    System.out.println("Güncel zırh: " + player.getDodge());
                }
            }
        }
    public void setGuns() {
        System.out.println(Guns);
        System.out.print("Silah seçiniz: ");
        String gun_name=scan.nextLine();
        if (gun_name.equals("Pistol")) {
            Pistol pistol = new Pistol();
            boolean is = player.isBuy(pistol.getMoney());
            if (is) {
                    player.decreaseMoney(pistol.getMoney());
                    player.increaseDamage(pistol.getDamage());
                    System.out.println("Güncel para: " + player.getMoney());
                    System.out.println("Güncel hasar: " + player.getDamage());
                }
        }
        else if (gun_name.equals("Rifle")) {
            Rifle rifle = new Rifle();
            boolean is = player.isBuy(rifle.getMoney());
            if (is) {
                    player.decreaseMoney(rifle.getMoney());
                    player.increaseDamage(rifle.getDamage());
                    System.out.println("Güncel para: " + player.getMoney());
                    System.out.println("Güncel hasar: " + player.getDamage());
                }
        }
        else if (gun_name.equals("Sword")) {
            Sword sword = new Sword();
            boolean is = player.isBuy(sword.getMoney());
            if (is) {
                    player.decreaseMoney(sword.getMoney());
                    player.increaseDamage(sword.getDamage());
                    System.out.println("Güncel para: " + player.getMoney());
                    System.out.println("Güncel hasar: " + player.getDamage());
                }
        }
    }
}

