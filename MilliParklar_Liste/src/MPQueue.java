import java.util.ArrayList;
public class MPQueue {
    private ArrayList<MilliPark> arrayList;
    public MPQueue() {
        this.arrayList=new ArrayList<>();
    }
    public void queue(MilliPark mp) {
        this.arrayList.add(mp);
    }
    public MilliPark deque() {
        if(isEmpty()) {
            return null;
        }
        return this.arrayList.remove(0);
    }
    public boolean isEmpty() {
        if(this.arrayList.size() ==0)  {
            return true;
        }
        return false;
    }
}
