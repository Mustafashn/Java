
package com.mustafa.Thread2;

public class main {
    public static void main(String[] args) {
         Thread printer = new Thread(new Printer());
        
         printer.start();
         
         System.out.println("Main çalışıyor...");
    }
}
