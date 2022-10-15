package threadsynchronizedlocks;


public class main {

    
    public static void main(String[] args) {
        ListWorker worker = new ListWorker();
       /* long start = System.currentTimeMillis();
        
        worker.setValue();
        
        long finish =System.currentTimeMillis();
        
        System.out.println("Time: "+(finish-start));
        */
       worker.run();
    }

}
