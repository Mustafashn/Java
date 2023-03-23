import java.util.ArrayList;

public class Heap {
    private HeapNode [] dizi;
    private int maxSize;
    private int currentSize;

    public  Heap(int maxSize) {
        this.maxSize=maxSize;
        this.dizi= new HeapNode[this.maxSize];
        this.currentSize=0;
    }
    public boolean isEmpty() {
        return this.currentSize==0;
    }
    public void insert(MilliPark mp) {
        //Heap doluysa ekleme yapılamaz
        if (this.maxSize != this.currentSize) {
            //HeapNode oluşturuluyor
            HeapNode heapNode = new HeapNode(mp);
            //Dizinin ilk boş kısmına oluşturulan nesne atanıyor
            this.dizi[this.currentSize] = heapNode;
            trickleUp(this.currentSize);
            this.currentSize+=1;
        }
    }
    public void trickleUp(int index) {
        int parent_index=(index-1)/2;
        HeapNode eklenen = dizi[this.currentSize];
        //index  0 dan büyük olduğu sürece ve parent eklenen nesneden daha küçük ise yer değiştirme işlemi yapılır
        while(index>0 && dizi[parent_index].getMp().getArea()<eklenen.getMp().getArea()) {
                this.dizi[index]=this.dizi[parent_index];
                index=parent_index;
                parent_index=(parent_index-1)/2;
            }
            this.dizi[index]=eklenen;
        }
    public HeapNode remove() {
        //dizinin ilk elemanı heapNode nesnesine atanır
        HeapNode root = this.dizi[0];
        //dizideki eleman sayacımız 1 azaltılır
        this.currentSize-=1;
        //dizinin 0. indeksine son eleman atanır ve konumu trickleDown ile aranır
        this.dizi[0]=this.dizi[this.currentSize];
        trickleDown(0);
        return root;
    }
    public void trickleDown(int index) {
        //çocuk nesnelere bakılarak aşağı kaydırma işlemi yapılır
        int largerChild_index;
        HeapNode topNode = this.dizi[index];
        while(index<this.currentSize/2) {
            int leftChild_index =2*index+1;
            int rightChild_index=leftChild_index+1;
            if(this.currentSize>rightChild_index && this.dizi[leftChild_index].getMp().getArea()<this.dizi[rightChild_index].getMp().getArea()) {
                largerChild_index=rightChild_index;
            }
            else {
                largerChild_index=leftChild_index;
            }
            //yeri bulunur ve döngünün bitmesi sağlanır
            if (topNode.getMp().getArea()>=this.dizi[largerChild_index].getMp().getArea()) {
                break;
            }
            this.dizi[index]=this.dizi[largerChild_index];
            index=largerChild_index;
        }
        this.dizi[index]=topNode;
    }
}
