public class Node_Trie {
    private Node_Trie[] children;
    private boolean isEndOfWord;
    public Node_Trie() {
        this.isEndOfWord=false;
        //alfabe harf sayısı için 26 girildi
        this.children=new Node_Trie[26];
        for(Node_Trie child: this.children) {
            child=null;
        }
    }

    public Node_Trie[] getChildren() {
        return children;
    }
    public boolean isEndOfWord() {
        return isEndOfWord;
    }
    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
