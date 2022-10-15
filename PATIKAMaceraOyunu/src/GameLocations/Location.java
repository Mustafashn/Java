/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameLocations;


import GameMonsters.Bear;
import GameMonsters.Vampire;
import GameMonsters.Zombie;
import java.util.Scanner;
import patıkamaceraoyunu.Player;
import java.util.Random;
import patıkamaceraoyunu.Fight;


/**
 *
 * @author musta
 */
public class Location {

    private Player player;
    private String locName = "";
    public String Locations
            = "----------------- \n"
            + "Konum Seçim Menüsü \n "
            + "----------------- \n "
            + "1-Safe House \n Özellikler: Can Yenilemesi \n "
            + "2-Cave \n \t Özellikler: Savaş + Ganimet "
            + "\n \t Eşya: Yemek \n \t Canavar: Zombi (1-3 Adet) \n "
            + "3-The Forest \n \t Özellikler: Savaş + Ganimet "
            + "\n \t Eşya: Odun \n \t Canavar: Ayı (1-3 Adet) \n "
            + "4-River \n \t Özellikler: Savaş + Ganimet "
            + "\n \t Eşya: Su \n \t Canavar: Vampir (1-3 Adet) \n "
            + "5-Market \n \t Özellikler: Destekleyici Eşyalar Satın "
            + "Almak \n \t Silah: Tabanca, Kılıç, Tüfek \n"
            + " \t Zırh: Hafif, Orta, Ağır";

    public Location(Player player) {
        this.player = player;
    }

    public String setLocation() {
        Scanner scan = new Scanner(System.in);
        locName = scan.nextLine();
        return locName;

    }

    public boolean getLocation(String locName) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        int rand_numb = rnd.nextInt(1, 4);
        if (locName.equals("Safe House")) {
            SafeHouse safeHouse = new SafeHouse(player);

            System.out.println("Canınız yenileniyor...");
            System.out.print("Canınız: ");
            System.out.println(player.getHealth());
            int heal = player.getCharHealth();
            safeHouse.setHealth(heal);
            System.out.print("Canınız yenilenmiştir : ");
            System.out.println(player.getHealth());
            System.out.println("Güncel paranız: "+player.getMoney());
            System.out.println("Güncel zırhınız: "+player.getDodge());
        } else if (locName.equals("Cave")) {
            Cave cave = new Cave(player);
            System.out.println("Mağarada " + rand_numb + " tane zombi ile karşılaştın");
            
            for (int i = 0; i < rand_numb; i++) {
                System.out.println("****************");
                Zombie zombie = new Zombie();
                Fight fight = new Fight(player, zombie);
                fight.Hit();
                if(player.getHealth()>=0) {
                    System.out.println(i + 1 + ". zombi yenildi...");
                player.increaseMoney(3);
                
                }
            }
        } else if (locName.equals("The Forest")) {
            Forest forest = new Forest(player);
            System.out.println("Ormanda " + rand_numb + " tane ayı ile karşılaştın");
            for (int i = 0; i < rand_numb; i++) {
                System.out.println("****************");
                Bear bear = new Bear();
                Fight fight = new Fight(player, bear);
                fight.Hit();
                if (player.getHealth() >= 0) {
                    System.out.println(i + 1 + ". ayı yenildi...");
                    player.increaseMoney(10);
                }
            }
        } else if (locName.equals("River")) {
            River river = new River(player);
            System.out.println("Nehirde " + rand_numb + " tane vampir ile karşılaştın");
            for (int i = 0; i < rand_numb; i++) {
                System.out.println("****************");
                Vampire vampire = new Vampire();
                Fight fight = new Fight(player, vampire);
                fight.Hit();
                if (player.getHealth() >= 0) {
                    System.out.println(i + 1 + ". vampir yenildi...");
                    player.increaseMoney(6);
                }

            }
        } else if (locName.equals("Market")) {
            Market market = new Market(player);
            System.out.print("Silah / Kalkan menüsü seçiniz : ");
            String choose = scan.nextLine();
            System.out.println("Para: "+this.player.getMoney());
            if (choose.equals("Kalkan")) {
                market.setArmors();
            }
            else if (choose.equals("Silah")) {
                market.setGuns();
            }
            else {
                System.out.println("Geçersiz item");
            }
            }
        return isLive();
    }

    public boolean isLive() {
        if (this.player.getHealth() <= 0) {
            return false;
        }
        return true;
    }
}


