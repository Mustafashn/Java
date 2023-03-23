public class Node {
    private int data;
    private int height;
    private Node leftChild;
    private Node rightChild;

    public void setHeight(int height) {
        this.height = height;
    }

    public Node(int data) {
        this.data=data;
        this.height=0;
    }

    public int getData() {
        return data;
    }

    public int getHeight() {
        return height;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
