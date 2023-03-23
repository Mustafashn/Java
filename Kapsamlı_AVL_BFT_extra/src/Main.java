public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(12);
        avlTree.insert(8);
        avlTree.insert(5);
        avlTree.insert(7);
        avlTree.insert(3);
        System.out.println("Ağacın preOrder dönülmesi: ");
        avlTree.preOrder(avlTree.getRoot());
        System.out.println();
        int [][] graph1= new int[] []{ { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        Dijkstras dij = new Dijkstras(graph1);
        System.out.println("**** Dijkstras ile 0'a olan uzaklıkların hesaplanması ****");
        dij.calculate(0);

        Prims pr = new Prims(graph1);
        System.out.println("**** Prims ile graph dönülmesi ****");
        pr.calculate();

        BFT bft = new BFT(graph1);
        bft.traverse(0);


        String keys[] = {"the", "avl", "there", "question", "any",
                "bus", "btree", "podcast"};
        Trie trie = new Trie();
        for (String key : keys) {
            trie.insert(key);
        }
    }
}