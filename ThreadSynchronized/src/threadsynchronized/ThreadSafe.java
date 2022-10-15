
package threadsynchronized;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSafe {
    private int count=0;
    public synchronized void increase () {
        count++;
    }
    public void runThread() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
            for (int i =0 ; i<5000; i++) {
                increase();
               
            }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
            for (int i =0 ; i<5000; i++) {
                increase();
                
            }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Count: "+count);
        
    }
    public static void main(String[] args) {
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.runThread();
    }
}
