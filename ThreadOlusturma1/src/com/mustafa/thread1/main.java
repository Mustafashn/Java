package com.mustafa.thread1;

public class main {
    public static void main(String[] args) {
        Printer p =  new Printer("Mustafa");
        
        p.start();
        
        
        System.out.println("Main çalışıyor...");
    }
}
