/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hafızaoyunu;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author musta
 */
public class HafızaOyunu {

    private static Kart[][] kartlar = new Kart[4][4];

    /**
     * @param args the command line arguments
     */
    public static void kayittanAl() {
        Scanner scan = new Scanner(System.in);
        File file = new File ("kayit.bin");
       if (file.exists()) {
           System.out.print("Kaydedilmiş bir oyununuz var kayıttan devam etmek ister misiniz ?");
           String cevap = scan.nextLine();
           if (cevap.equals("yes")) {
               kartlar =OyunKayıt.takeSave();
               return;
           }
           
       }
       kartlar[0][0] = new Kart('E');
        kartlar[0][1] = new Kart('A');
        kartlar[0][2] = new Kart('B');
        kartlar[0][3] = new Kart('F');
        kartlar[1][0] = new Kart('G');
        kartlar[1][1] = new Kart('A');
        kartlar[1][2] = new Kart('D');
        kartlar[1][3] = new Kart('H');
        kartlar[2][0] = new Kart('F');
        kartlar[2][1] = new Kart('C');
        kartlar[2][2] = new Kart('D');
        kartlar[2][3] = new Kart('H');
        kartlar[3][0] = new Kart('E');
        kartlar[3][1] = new Kart('G');
        kartlar[3][2] = new Kart('B');
        kartlar[3][3] = new Kart('C');
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        kayittanAl();
        while (oyunBittiMi() == false) {
            oyunTahtasi();
            System.out.print("Çıkmak istiyor musunuz (yes / no) :");
            String quit =scan.nextLine();
            if (quit.equals("yes")) {
                System.out.println("Oyunu kaydetmek istiyor musunuz (yes no )");
                String kayit = scan.nextLine();
                
                if (kayit.equals("yes")) {
                    OyunKayıt.gameSave(kartlar);
                }
                else {
                    System.out.println("Oyun kaydedilmedi.");
                }
                System.out.println("Programdan çıkılıyor...");
                break;
            }
            tahminEt();
            
        }
    }

    public static void tahminEt() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinci Tahmin, i1 ve j1 değerlerini bir boşluklu girin:  ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();
        kartlar[i1][j1].setTahmin(true);
        oyunTahtasi();
        System.out.println("İkinci Tahmin, i2 ve j2 değerlerini bir boşluklu girin:");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        if (kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()) {
            System.out.println("Doğru tahmin!!");
            kartlar[i2][j2].setTahmin(true);
            
        }
        else {
            System.out.println("Yanlış tahmin!! (");
            kartlar[i1][j1].setTahmin(false);
        }
    }

    public static boolean oyunBittiMi() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (kartlar[i][j].getTahmin() == false) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void oyunTahtasi() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (kartlar[i][j].getTahmin()) {
                    System.out.print(" |" + kartlar[i][j].getDeger() + "| ");
                } else {
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
    }
}
