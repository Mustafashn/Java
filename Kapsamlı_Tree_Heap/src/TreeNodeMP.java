public class TreeNodeMP {
    private MilliPark mp;
    private TreeNodeMP leftChildMP;
    private TreeNodeMP rightChildMP;
    private Kelime kelime;

    public TreeNodeMP(MilliPark mp) {
        this.mp=mp;
    }
    public TreeNodeMP(Kelime kelime) {
        this.kelime=kelime;
    }
    public Kelime getKelime() {
        return this.kelime;
    }
    public MilliPark getMp() {
        return this.mp;
    }
    public TreeNodeMP getLeftChildMP() {
        return this.leftChildMP;
    }

    public void setLeftChildMP(TreeNodeMP leftChild) {
        this.leftChildMP = leftChild;
    }

    public void setRightChildMP(TreeNodeMP rightChild) {
        this.rightChildMP = rightChild;
    }

    public TreeNodeMP getRightChildMP() {
        return this.rightChildMP;
    }

}
