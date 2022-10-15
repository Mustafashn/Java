/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patıkamaceraoyunu;

import GameCharacters.Characters;
import GameLocations.Location;
import GameWeapons.Weapons;
import java.awt.BorderLayout;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author musta
 */
public class Game {
    private  Player player;
    
    private Scanner scan = new Scanner(System.in);
    public void  start() throws InterruptedException {
        String locName;
        System.out.println("Oyun başladı !");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = scan.nextLine();
        
        Player player= new Player(playerName,Characters.setChar());
        Location location = new Location(player);
        boolean error = true;
        System.out.println("Geçiş yapılacak mekanı belirleyiniz: ");
        System.out.println("***************");
        System.out.println(location.Locations);
        while(error) {
            System.out.println("///////////////////////////");
            System.out.print("Konum Seçiminiz: ");
        locName=location.setLocation();
        System.out.println("Konum belirleniyor.");
        System.out.println("***********");
        error= location.getLocation(locName);
        if(! error) {
               System.out.println("Öldün amque");
               error=false;
           }
           
        }
        
    }
}
