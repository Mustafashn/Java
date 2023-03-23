public class AVLTree {
    private Node root;

    public AVLTree() {
        this.root = null;
    }
    public Node getRoot() {
        return this.root;
    }
    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private int max(int leftHeight, int rightHeight) {
        //Math max fonksiyonuyla maksimum yükseklik bulunuyor
        return Math.max(leftHeight, rightHeight);
    }

    public void insert(int data) {
        this.root = insertElement(data,this.root);
    }
    private Node insertElement(int data,Node node){
        //Ağaç boş ise köke yeni eleman direkt atanır
        if (node==null) {
            node=new Node(data);
        }
        //eklenen veri kökten küçükse(sol ağaçtaysa)
        else if(data<node.getData()) {
            node.setLeftChild(insertElement(data,node.getLeftChild()));
            //dengeleme işlemi yapılacaksa
            if( getHeight(node.getLeftChild()) - getHeight(node.getRightChild()) ==2 )  {
                if(data<node.getLeftChild().getData()) {
                    node=rotateWithLeftChild(node);
                }
                else {
                    node=doubleWithLeftChild(node);
                }
            }
        }
        else if(data>node.getData()) {
            node.setRightChild(insertElement(data,node.getRightChild()));
            //dengeleme işlemi yapılacaksa
            if( getHeight(node.getLeftChild()) - getHeight(node.getRightChild()) ==2 )  {
                if(data>node.getRightChild().getData()) {
                    node=rotateWithRightChild(node);
                }
                else {
                    node=doubleWithRightChild(node);
                }
            }
        }
        node.setHeight(max(getHeight(node.getLeftChild()),getHeight(node.getRightChild()))+1);

        return node;
    }
    private Node rotateWithRightChild(Node node) {
        Node newNode = node.getRightChild();
        node.setRightChild(newNode.getLeftChild());
        newNode.setLeftChild(node);
        node.setHeight(max(getHeight(node.getLeftChild()),getHeight(node.getRightChild()))+1);
        newNode.setHeight(max(getHeight(newNode.getRightChild()),node.getHeight())+1);
        return newNode;
    }
    private Node rotateWithLeftChild(Node node) {
        Node newNode = node.getLeftChild();
        node.setLeftChild(newNode.getRightChild());
        newNode.setRightChild(node);
        node.setHeight(max(getHeight(node.getLeftChild()),getHeight(node.getRightChild()))+1);
        newNode.setHeight(max(getHeight(newNode.getRightChild()),node.getHeight())+1);
        return newNode;
    }
    private Node doubleWithLeftChild(Node node) {
        node.setLeftChild(rotateWithRightChild(node.getLeftChild()));
        return rotateWithLeftChild(node);
    }
    private Node doubleWithRightChild(Node node) {
        node.setRightChild(rotateWithLeftChild(node.getRightChild()));
        return rotateWithRightChild(node);
    }
    public void preOrder(Node node) {
        if(node !=null) {
            System.out.print(node.getData()+" /");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
}
//https://www.javatpoint.com/avl-tree-program-in-java