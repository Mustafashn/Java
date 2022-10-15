

package main;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Worker implements  Runnable {
    private String name ;
    private int taskId;

    public Worker(String name, int taskId) {
        this.name = name;
        this.taskId = taskId;
    }
    @Override
    public void run() {
        System.out.println("Worker: "+name +"  "+taskId+ " is running..");
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Worker: "+name +"  "+taskId+ " finished the work..");
    }

}
