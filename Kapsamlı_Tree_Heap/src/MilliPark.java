import java.util.ArrayList;

public class MilliPark implements Comparable<MilliPark> {
    private String name;
    private String city;
    private double area;
    private String date;
    private ArrayList<String> information;
    private String informationString="";

    public MilliPark(String name,String city,double area,String date,ArrayList<String> information){
        this.name=name;
        this.city=city;
        this.area=area;
        this.date=date;
        this.information=information;
        for (String s: this.information
             ) {
            this.informationString += s;
        }
    }
    public void setDate(String date) {
        this.date=date;
    }
    public String getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }
    public String toString() {
        return String.format("--> Adı: %s || İl: %s || Yüzölçümü: %.2f hektar || Tarih: %s \n" +
                "    Bilgi: %s",this.name,this.city,this.area,this.date,this.informationString);
    }
    public String getCity() {
        return this.city;
    }
    public double getArea() {
        return this.area;
    }
    public String getInformationString() {
        return this.informationString;
    }

    @Override
    public int compareTo(MilliPark milliPark) {
        //isimler eşittir
        if (this.name.compareTo(milliPark.getName())==0) {
            return 0;
        }
        //this nesnesinin ismi milliPark nesnesinden önce gelir
        else if (this.name.compareTo(milliPark.getName())<0) {
            return -1;
        }
        //this nesnesinin ismi milliPark nesnesinden sonra gelir
        else {
            return 1;
        }
    }

}
