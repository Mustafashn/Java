/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package circlelist;

/**
 *
 * @author musta
 */
class Node {
    public int data;
    public Node next;    
    public Node () {
        this.data=1;
        this.next=null;
        
    }
}
public class CircleList {
    private Node head;

    public CircleList(int n) {
        
        Node current = new Node();
        current=this.head;
        for (int i =0;i<n;i++) {
            current.data=i;
            current=current.next;
        
        }
    }
    public void yazdir(int n) {
        Node newNode = new Node();
        newNode=this.head;
        for(int i =0; i<n;i++) {
            System.out.println(newNode.next.data);
            newNode=newNode.next;
        }
    }
    
    static void balonPozisyonBul(int m, int n) {
        
    }
}
