
package com.mustafa.Thread3;


public class main {
    public static void main(String[] args) {
        Thread print1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalıştı...");
            }
        });
        print1.start();
        System.out.println("Main çalışıyor.");
    }
}
