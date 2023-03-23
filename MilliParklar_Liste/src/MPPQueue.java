import java.util.ArrayList;
public class MPPQueue {
    private ArrayList<MilliPark> arrayList;
    public MPPQueue() {
        this.arrayList= new ArrayList<>();
    }
    public void queue(MilliPark mp) {
        this.arrayList.add(mp);
    }
    public MilliPark deque() {
        if(this.isEmpty()) {
            return null;
        }
        else {
            int index=0;
            double yuz_olcumu=this.arrayList.get(0).getArea();
            //en kücük yüzölçümüne sahip milli park bulunuyor ve indexi tutuluyor
            for(int i=1;i<this.arrayList.size();i++) {
                if(this.arrayList.get(i).getArea()<yuz_olcumu) {
                    index=i;
                    yuz_olcumu=this.arrayList.get(i).getArea();
                }
            }
            return this.arrayList.remove(index);
        }
    }
    public boolean isEmpty() {
        if(this.arrayList.size() ==0)  {
            return true;
        }
        return false;
    }
}
