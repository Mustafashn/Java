public class Dijkstras {
    private int vertex;
    private int [] [] graph;
    private int [] distance;
    private boolean [] isIn;

    public Dijkstras(int [] [] graph) {
            this.graph=graph;
            this.vertex= graph.length;
            //graph'a ekli mi kontrolü için dizi oluşturuluyor
            this.isIn=new boolean[this.vertex];
            //uzaklıklar için dizi oluşturuluyor
            this.distance=new int[this.vertex];

            for(int i=0;i<this.vertex;i++) {
            //Uzaklıklara max değer atanıyor
            distance[i]=Integer.MAX_VALUE;
            //diziye eklendi mi elemanları false yapılıyor
            isIn[i]=false;
        }
    }
    private int minDistance() {
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        //dizi üzerinde dönülerek minimum değer aranıyor
        for(int v=0;v<this.vertex;v++) {
            if ( !this.isIn[v] && this.distance[v] <= min) {
                min=this.distance[v];
                min_index=v;
            }
        }
        return min_index;
    }
    private void print() {
        System.out.println("\tVertex \t\t Distance");
        for(int i=0;i<this.vertex;i++) {
            System.out.println("\t"+i+" \t\t\t  "+ this.distance[i]);
        }
    }
    public void calculate(int source) {
        //seçilen vertex uzaklığı uzaklıklar dizisinde 0'a atanıyor
        this.distance[source]=0;
        for(int counter=0;counter<this.vertex-1;counter++) {
            //min distance bulunup isIn dizisinde true yapılıyor
            int i = minDistance();
            this.isIn[i]=true;
            //köşelerde dönülüp ısIn dizisinde olmayan ve kısa yol oluşturanlar distance dizisinde güncelleniyor
            for(int k =0;k<this.vertex;k++) {
                if (!isIn[k] && this.graph[i][k]!=0 && this.distance[i]!=Integer.MAX_VALUE
                        && this.distance[i]+this.graph[i][k]<this.distance[k]){
                    this.distance[k]=this.distance[i]+this.graph[i][k];
                }
            }
        }
        print();
    }
}
