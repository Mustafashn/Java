package miniprojewaitnotify;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MiniProjeWaitNotify {

    
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.produce();
            }
        });
        Thread consume = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.consume();
            }
        });
    producer.start();
   consume.start();
   
        try {
            producer.join();
            consume.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MiniProjeWaitNotify.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
