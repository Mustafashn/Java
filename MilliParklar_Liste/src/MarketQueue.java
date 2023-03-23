import java.util.ArrayList;
public class MarketQueue {
    private ArrayList<Integer> arrayList;
    private final int  islem_suresi=3;
    private int toplam_islem=0;
    private int beklenen_zaman=0;
    private int toplam_zaman=0;
    public MarketQueue() {
        this.arrayList= new ArrayList<>();
    }
    public void add(int urun_sayisi) {
        //yığıta zaman ekleniyor
        this.arrayList.add(urun_sayisi);
        //toplam zaman işleme giriyor
        //toplam işlem arttırılıyor
        this.toplam_islem+=1;
    }
    public void add(int [] dizi) {
        //toplu ekleme için diziden ekleme yapılıyor
        for(int i=0;i<dizi.length;i++) {
            this.arrayList.add(dizi[i]);
        }
        this.toplam_islem+=dizi.length;
    }
    public int deque() {
        if(isEmpty()) {
            return -1;
        }
        else {
            //islemin toplam zamanı ve kasanın toplam zamanı hesaplanıyor
            this.beklenen_zaman+=this.arrayList.remove(0)*islem_suresi;
            this.toplam_zaman+=beklenen_zaman;
            return this.beklenen_zaman;
        }
    }
    public double ort_sure() {
        return (double)this.toplam_zaman/this.toplam_islem;
    }
    public boolean isEmpty() {
        if (this.arrayList.size()==0) {
            return true;
        }
        return false;
    }
}
