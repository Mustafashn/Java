//https://www.geeksforgeeks.org/trie-insert-and-search/ yararlanıldı
public class Trie {
    private Node_Trie root;

    public Trie() {
        this.root=new Node_Trie();
    }
    public void insert(String word) {
        int level;
        int length=word.length();
        int index;

        Node_Trie p =this.root;

        for(level=0;level<length;level++) {
            index=word.charAt(level)-'a';
            //Eğer bu index boş ise index içerisinde bir node oluşturulur
            if(p.getChildren()[index]==null) {
                p.getChildren()[index]=new Node_Trie();
            }
            //üzerinde bulunduğumuz değer index children olarak atanır ve kelime bitene kadar bu işlem tekrarlanır
            p=p.getChildren()[index];
        }
        p.setEndOfWord(true);
    }
}
