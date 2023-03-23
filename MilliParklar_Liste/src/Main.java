import java.io.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //Kuyruk yığıt ve öncelikli kuyruk nesneleri oluşturuluyor
        MPStack mpStack = new MPStack();
        MPQueue mpQueue = new MPQueue();
        MPPQueue mpPQueue = new MPPQueue();
        //olustur_ekle_milli_park methodu çağırılarak milli parklar dizisi oluşuyor
        ArrayList<MilliPark> [] milli_parklar = olustur_ekle_milli_park(mpStack,mpQueue,mpPQueue);
        //ekrana_yazdir methoduyla ekrana yazdırılıyor
        ekrana_yazdir(milli_parklar);
        System.out.println("****************************************");
        System.out.println("--Yığıt yazdırılıyor--");
        //Stack eleman çıkarması yapılıyor.
        while(! mpStack.isEmpty()) {
            System.out.println(mpStack.pop());
        }
        //Queue eleman çıkarması yapılıyor.
        System.out.println("****************************************");
        System.out.println("--Kuyruk yazdırılıyor--");
        while(! mpQueue.isEmpty()) {
            System.out.println(mpQueue.deque());
        }
        //PQueue eleman çıkarması yapılıyor.
        System.out.println("****************************************");
        System.out.println("--Öncelikli Kuyruk yazdırılıyor--");
        while(! mpPQueue.isEmpty()) {
            System.out.println(mpPQueue.deque());
        }
        System.out.println("****************************************");
        //Kasa işlemleri
        MarketQueue mq = new MarketQueue();
        int [] dizi = {8,9,6,7,10,1,11,5,3,4,2};
        //Kasaya sepetler ekleniyor
        mq.add(dizi);
        //İslem tamamlanma süreleri yazdırılıyor
        System.out.println("--Market kasa işlemleri--");
        while(! mq.isEmpty()) {
            System.out.printf("İşlem süresi: %s saniye \n",mq.deque());
        }
        System.out.printf("Kasa için ortalama işlem tamamlanma süresi : %.2f saniye \n",mq.ort_sure());
        MarketPQueue mpq = new MarketPQueue();
        //Öncelikli kasaya sepetler ekleniyor
        mpq.add(dizi);
        System.out.println("--Öncelikli Market kasa işlemleri--");
        while(! mpq.isEmpty()) {
            System.out.printf("İşlem süresi: %s saniye \n",mpq.deque());
        }
        System.out.printf("Öncelikli kasa için ortalama işlem tamamlanma süresi : %.2f saniye \n",mpq.ort_sure());
    }
    public static ArrayList<MilliPark>[]  olustur_ekle_milli_park(MPStack mpStack,MPQueue mpQueue,MPPQueue mppQueue) {
        String line;
        String[] array;
        String name = "";
        int year = 0;
        double area = 0.0;
        ArrayList<String> city_names = new ArrayList<>();
        ArrayList<MilliPark> milli_parklar_15_kucuk = new ArrayList<>();
        ArrayList<MilliPark> milli_parklar_15_buyuk = new ArrayList<>();
        ArrayList<MilliPark>[] milli_parklar = new ArrayList[]{milli_parklar_15_kucuk, milli_parklar_15_buyuk};
        FileReader fr = null;
        try {
            fr = new FileReader("parklar.txt");
            BufferedReader br = new BufferedReader(fr);
            while (((line = br.readLine()) != null)) {
                array = line.split(",");
                for (int i = 0; i < array.length; i++) {
                    //İlk indis isime atanıyor
                    if (i == 0) {
                        name = array[i];
                    }
                    //Son elemanımız yüzölçümü olduğu için yüzölçümüne atanıyor
                    else if (i == array.length - 1) {
                        area = Double.parseDouble(array[i]);

                    }
                    //Sondan önceki elemanımız yıl olduğu için yıla atanıyor
                    else if (i == array.length - 2) {
                        year = Integer.parseInt(array[i].strip());
                    }
                    //Arada olan elemanlar şehir isimleri olduğu için şehir listesine atanıyorlar.
                    else {
                        city_names.add(array[i].trim());
                    }
                }
                MilliPark mp = new MilliPark(name, city_names, year, area);
                //Stack eklemesi yapılıyor.
                mpStack.add(mp);
                //Kuyruk eklemesi yapılıyor.
                mpQueue.queue(mp);
                //Öncelikli kuyruk eklemesi yapılıyor.
                mppQueue.queue(mp);
                if (area < 15.000) {
                    milli_parklar[0].add(mp);
                } else {
                    milli_parklar[1].add(mp);
                }
                city_names.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return milli_parklar;
    }
    public static void ekrana_yazdir(ArrayList<MilliPark> [] milli_parklar) {
        for(int i=0;i<milli_parklar.length;i++) {
            double toplam_yuzolcumu=0.0;
            //Kücük milli parklar yazdırılmaya başlanıyor. iLk turda sadece if dönüyor
            if(i==0) {
                System.out.println("-------Küçük milli parklar için-------");
            }
            //Büyük milli parklar yazdırılmaya başlanıyor. İkinci turda else dönüyor
            else {
                System.out.println("-------Büyük milli parklar için-------");
            }
            for(MilliPark mp: milli_parklar[i]) {
                System.out.println(mp.toString());
                toplam_yuzolcumu+=mp.getArea();
            }
            System.out.printf("Yüzölçümü: %.3f hektar \n",toplam_yuzolcumu);
        }
    }
}