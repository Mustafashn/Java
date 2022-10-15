/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patikaogrencibilg;

/**
 *
 * @author musta
 */
public class Teacher {
    String name;
    String branch;
    String mpno;
    
    public Teacher(String name , String branch,String mnpo) {
        this.name=name;
        this.branch=branch;
        this.mpno=mnpo;
    }
    void print() {
        System.out.println("Name : "+this.name);
        System.out.println("Phone number : "+this.mpno);
        System.out.println("Branch : "+this.branch);
    }
}
