/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.armstrong_sayisi;

import java.util.Scanner;

/**
 *
 * @author musta
 */
public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Sayıyı giriniz: ");
        int sayi = scanner.nextInt();
        int sayi1=sayi;
        int gecici=sayi;
        int basamak_sayisi=1;
        int toplam=0;
        while (true) {
            if (sayi<10) {
                basamak_sayisi=1;
                break;
            }
            else {
                sayi= sayi / 10;

                if (sayi>= 10) {
                basamak_sayisi+=1;
            }
                else            {
                basamak_sayisi+=1;
                break;
                }
            }
        
        }
        
        for (int i =0 ; i<basamak_sayisi; i++){
            int eklenen=gecici%10;
            gecici/=10;
            toplam+=Math.pow(eklenen, basamak_sayisi);
            
                    
        }
        if (sayi1 == toplam) {
            System.out.println("Armstrong sayısıdır.");
        }
        else {
            System.out.println("Armstrong sayısı değildir.");
        }
    }
}
