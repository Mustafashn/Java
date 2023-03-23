import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFT {
    private Node V;
    private Queue<Integer> queue;
    private LinkedList<Integer>[] komsuluk;
    private boolean [] visited;

    public BFT(int [][] graph) {
        this.queue=new LinkedList<>();
        this.visited=new boolean[graph.length];
        this.komsuluk=new LinkedList[graph.length];
        for (int i = 0; i <this.komsuluk.length ; i++) {
            this.komsuluk[i]=new LinkedList<Integer>();
        }
        for (int i = 0; i <graph.length ; i++) {
            for (int j = 0; j <graph.length ; j++) {
                //Birbiri ile bağlantılı olanlar kendi linkedlistlerine bağlandı
                if(graph[i][j]!=0) {
                    this.komsuluk[i].add(j);
                }
            }
        }
    }
    public void traverse(int node) {
        //İlk node gidildi diye işaretlendi
        this.visited[node]=true;
        //Kuyruğa ilk node atıldı
        this.queue.add(node);
        System.out.println("Breadth First Traverse: ");
        while(this.queue.size()!=0) {
            //Kuyruğun başındaki eleman çıkarıldı
            node=this.queue.poll();
            System.out.print(node+" / ");
            //Çıkarılan elemanın bağlı olduğu komşular dönülüyor
            Iterator<Integer> iterator=this.komsuluk[node].listIterator();
            while(iterator.hasNext()) {
                int next=iterator.next();
                //Eğer komşu daha önce ziyaret edilmediyse kuyruğa ekleniyor ve ziyaret edildiği işaretleniyor
                if(!this.visited[next]) {
                    this.visited[next]=true;
                    this.queue.add(next);
                }
            }
        }
        System.out.println();
    }
}
