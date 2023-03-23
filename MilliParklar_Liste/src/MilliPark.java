import java.util.ArrayList;
public class MilliPark {
    private String name;
    private ArrayList<String> city_names;
    private String citynamesString="";
    private int year;
    private double  area;
    public MilliPark(String name,ArrayList<String> city_names,int year,double area) {
        this.name=name;
        this.year=year;
        this.area=area;
        this.city_names=city_names;
        //şehir isimleri stringe dönüştürülüyor
        for(int i=0;i<this.city_names.size();i++) {
            this.citynamesString+=this.city_names.get(i);
            if(i != this.city_names.size()-1) {
                this.citynamesString += " / ";
            }
        }
    }
    public double getArea() {
        return this.area;
    }
    public String toString() {
        return String.format("Milli Park: %s || " +
                "Yıl: %s || " +
                "Yüzölçümü: %.3f hektar || " +
                "İl ad(lar)ı: %s ",this.name,this.year,this.area,this.citynamesString);
    }
}
