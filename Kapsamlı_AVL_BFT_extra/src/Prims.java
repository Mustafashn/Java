public class Prims {
    private int vertex;
    private int [][]graph;
    private int [] keys;
    private boolean [] isIn;
    private int [] parent;

    public Prims(int [][] graph) {
        this.graph=graph;
        this.vertex=this.graph.length;
        this.keys=new int [this.vertex];
        this.isIn= new boolean[this.vertex];
        this.parent=new int[this.vertex];
        for(int i=0;i<this.vertex;i++) {
            this.isIn[i]=false;
            this.keys[i]=Integer.MAX_VALUE;
        }
    }
    private int minKey() {
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int v=0;v<this.vertex;v++) {
            if(!this.isIn[v] && this.keys[v]<=min) {
                min=this.keys[v];
                min_index=v;
            }
        }
        return min_index;
    }
    public void print() {
        System.out.println("\tEdge \tWeight");
        for(int i=1;i<this.vertex;i++) {
            System.out.println("\t"+this.parent[i]+" - "+ i+"\t"
            +this.graph[i][parent[i]]);
        }
    }
    public void calculate() {
        this.keys[0]=0;
        this.parent[0]=-1;

        for(int counter=0;counter<this.vertex-1;counter++) {
            int i= minKey();
            this.isIn[i]=true;
            for(int v=0; v<this.vertex;v++) {
                if(this.graph[i][v]!=0 && !this.isIn[v] && this.graph[i][v]<this.keys[v]){
                    this.parent[v]=i;
                    this.keys[v]=this.graph[i][v];
                }
            }
        }
        print();
    }
}
