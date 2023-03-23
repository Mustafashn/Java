import java.util.ArrayList;
public class MarketPQueue {
    private ArrayList<Integer> arrayList;
    private final int  islem_suresi=3;
    private int beklenen_zaman=0;
    private int toplam_islem=0;
    private int toplam_zaman=0;
    public MarketPQueue() {
        this.arrayList=new ArrayList<>();
    }
    //Tekli eleman eklemek için
    public void add(int urun_sayisi) {
        //Boş ise listenin başına eklenir
        if (isEmpty()) {
                this.arrayList.add(urun_sayisi);
        }
        //eğer listenin sonuna eklenecekse
        else if (this.arrayList.get(this.arrayList.size()-1)<urun_sayisi) {
            this.arrayList.add(urun_sayisi);
        }
        //listede yeri aranacak
        else {
            for (int i = 0; i < this.arrayList.size(); i++) {
                if (this.arrayList.get(i) > urun_sayisi) {
                    this.arrayList.add(i, urun_sayisi);
                    break;
                }
            }
        }
        this.toplam_islem+=1;
    }
    //dizinin tamamı eklenecekse
    public void add(int [] dizi) {
        //dizi dönülerek elemanlar ekleniyor
        for(int urun: dizi) {
           //Yukarıdaki add metodu çağırılıyor
            add(urun);
        }
    }
    public boolean isEmpty() {
        if (this.arrayList.size() ==0) {
            return true;
        }
        return false;
    }
    public int deque() {
        //Kuyruktan çıkarma işlemi yapılıyor
        if(isEmpty()) {
            return -1;
        }
        else {
            //toplam zaman sayılıyor
            //çıkan islemin toplam zamanı hesaplanıyor
            this.beklenen_zaman+=this.arrayList.remove(0)*islem_suresi;
            this.toplam_zaman+=beklenen_zaman;
            return this.beklenen_zaman;
        }
    }
    public double ort_sure() {
        return (double)this.toplam_zaman/this.toplam_islem;
    }
}
