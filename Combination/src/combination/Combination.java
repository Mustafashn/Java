/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package combination;

import java.util.Scanner;

/**
 * n/ r(n-r)
 * @author musta
 */
public class Combination {

    /**
     * @param args the command line arguments
     */
    public static int fact (int num) {
        int f = 1;
        for (int i = 1 ; i<=num ; i++) {
            f*=i;
            
        }
        return f;
    }
    public static int comb(int n,int r) {
        int com= fact(n)/ (fact(r)*fact(n-r));
        return com;
    }
    public static void main(String[] args) {
        int n=0,r=0;
        Scanner scan = new Scanner(System.in);
        boolean hata = true;
        while (hata) {
            try {
            System.out.print("Please enter the value of combination (n) : ");
            n=scan.nextInt();
            scan.nextLine();
            System.out.print("Please enter the value of combination (r) :");
            r = scan.nextInt();
            hata=false;
            }   
        catch(Exception e) {
            System.out.println("Wrong combination number! ");
            scan.nextLine();
        }
        }
        System.out.println(comb(n, r));
    }
    
}
