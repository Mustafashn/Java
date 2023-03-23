import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    //Tree nesnesi oluşturuluyor
    Tree tree = new Tree();
    //Hastable nesnesi oluşturuluyor
    Hashtable<String,MilliPark> hashTable= new Hashtable<>();
    //Heap yapısı oluşturuluyor
    Heap heap = new Heap(48);
    milliParkNesneleriOlustur(tree,hashTable,heap);
    //Derinlik düğüm ve dengeli olsaydı fonksiyonu çağırılıyor
    tree.bul();
    //Milli parkın ilini bulma
        System.out.print("Aranan milli parkın adının ilk 3 harfini giriniz: ");
        String arananpark=scan.nextLine();
        tree.parkAra(arananpark,tree.getRoot());
    //Kelime ağacı olusturuluyor
    Tree kelimeTree =kelimeIkiliAgacıOlustur(tree);
    //Kelime ağacı üzerinde dönülüyor
    kelimeTree.inOrderKelime(kelimeTree.getRoot());
    System.out.println("----------HashTable üzerinde eklenen milli parklar----------");
    Enumeration<String> e = hashTable.keys();
        while(e.hasMoreElements()) {
            String adı=e.nextElement();
            System.out.println("Eklenen milli park: "+adı);
        }
        System.out.println();
        hastTableTarihGuncelle(hashTable);
    System.out.println("\nMax Heap nesnesinden 3 kere çıkarma yapılıyor");
    for(int i=0;i<3;i++) {
        System.out.println("    Çıkarılan Milli park:\n"+heap.remove().getMp().toString());
        }

    int [] numbers ={3,1,2,6,10,5,12,7,20,11,30};
    numbers = bubbleSort(numbers);
    System.out.print("**Sıralanmış hali**\n-->");
    for (int n: numbers
             ) {
            System.out.print(n+",");
        }
        System.out.println("");

    }

    public static void milliParkNesneleriOlustur(Tree tree,Hashtable<String,MilliPark> hashtable,Heap heap) throws IOException {
        //Ağaç oluşturuluyor

        //Bilgilerle ilgili işlem yapılıyor
        //İsimlerin tutulacağı arraylist olusturuluyor
        ArrayList<String> isimler= new ArrayList<>();
        //Bilgilerin tutulacağı String dizi içeren arraylist olusturuluyor
        ArrayList<ArrayList<String>> bilgiler = new ArrayList<>();
        String line="";
        String gecici_dizi [];
        FileReader fr1 = new FileReader("bilgiler.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        while ((line =br1.readLine()) != null) {
            //Bilgiler isimleri ve bilgileri olarak ayrılıyor
            gecici_dizi=line.split("//");
            isimler.add(gecici_dizi[0]);
            //Bilgiler cümle cümle ayrılıp diziye atanıyor ve dizi arrayliste atanıyor
            gecici_dizi=gecici_dizi[1].split("%%");
            ArrayList<String> geciciList = new ArrayList<>();

            geciciList.addAll(Arrays.asList(gecici_dizi));
            bilgiler.add(geciciList);
        }
        FileReader fr = new FileReader("parklar.txt");
        BufferedReader br = new BufferedReader(fr);
        String [] dizi2;
        String ad="";
        String il="";
        double alan=0.0;
        String tarih="";
        while((line= br.readLine())!= null) {
            dizi2 =line.split(",");
            for(int i=0; i<dizi2.length;i++) {
                if (i ==0) {
                    ad=dizi2[i];
                }
                else if (i ==1) {
                    il = dizi2[i];
                }
                else if (i ==2) {
                    alan=Double.parseDouble(dizi2[2]);
                }
                else {
                    tarih = dizi2[i];
                }
            }
            //Bilgi indexi isim listesinden çekiliyor
            int bilgi_index=isimler.indexOf(ad);
            //Milli park nesnesi bilgileriyle birlikte oluşturuluyor
            MilliPark mp = new MilliPark(ad,il,alan,tarih,bilgiler.get(bilgi_index));
            //Ağaç oluşturuluyor
            tree.insert(mp);
            //Hashtable a milli parklar isimlerine göre ekleniyor
            hashtable.put(mp.getName(),mp);
            heap.insert(mp);
        }
    }
    public static Tree kelimeIkiliAgacıOlustur(Tree tree) {
        Tree kelimeTree = new Tree();
        tree.kelimeAgacıOlustur(tree.getRoot(),kelimeTree);
        return kelimeTree;
    }
    public static void hastTableTarihGuncelle(Hashtable<String,MilliPark>hashtable) {
        System.out.print("Güncellenecek milli park ismi: ");
        String isim=scan.nextLine();
        System.out.print("Yeni ilan tarihi: ");
        String tarih =scan.nextLine();
        //Hashtable dan milli park nesnesi bulunuyor
        MilliPark milliPark=hashtable.get(isim);
        //Nesne üzerinde tarih değiştiriliyor
        milliPark.setDate(tarih);
        System.out.println("Tarih güncellenmiştir --> "+milliPark.getDate());
    }
    public static int [] bubbleSort(int [] numbers) {
        int temp;
        for (int i = 0; i < numbers.length ; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                if (numbers[i]> numbers[j]) {
                    temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        return numbers;
    }
}