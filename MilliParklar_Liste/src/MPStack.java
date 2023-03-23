import java.util.ArrayList;
public class MPStack {
    private ArrayList<MilliPark> arrayList;
    public MPStack() {
        this.arrayList=new ArrayList<>();
    }
    public void add(MilliPark mp) {
        this.arrayList.add(mp);
    }
    public MilliPark pop() {
        if(isEmpty()) {
            return null;
        }
        return this.arrayList.remove(this.arrayList.size()-1);
    }
    public boolean isEmpty() {
        if(this.arrayList.size() ==0)  {
            return true;
        }
        return false;
    }
}
