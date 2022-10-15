
package com.mustafa.thread1;

public class Printer extends Thread{
    private String name;

    @Override
    public void run() {
        System.out.println(name+"çalışıyor");
    }

    
    public Printer(String name) {
        this.name = name;
    }
    
}
