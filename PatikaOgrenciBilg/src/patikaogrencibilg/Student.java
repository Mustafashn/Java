/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patikaogrencibilg;

/**
 *
 * @author musta
 */
public class Student {

    String name;
    String stuNo;
    int classes;
    Course c1;
    Course c2;
    Course c3;
    double avarage;
    boolean isPass;

    public Student(String name, String stuNo, int classes, Course c1, Course c2, Course c3) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.isPass = false;
        this.avarage = 0.0;
    }
    public void adBulkExamNote(int note1,int note2, int note3) {
        if (note1 <= 100 && note1>=0) {
            this.c1.note=note1;
        }
        if (note2 <= 100 && note2>=0) {
            this.c2.note=note2;
        }
        if (note3 <= 100 && note3>=0) {
            this.c3.note=note3;
        }
        
    }
    void printNote() {
        System.out.println(this.c1.name+" note: "+this.c1.note);
        System.out.println(this.c2.name+" note: "+this.c2.note);
        System.out.println(this.c3.name+" note: "+this.c3.note);
        System.out.println("Your note avarage: "+this.avarage);
    }

    public void isPass() {
        this.avarage = (this.c1.note + this.c2.note + this.c3.note) / 3.0;
        if (this.avarage >= 60) {
            this.isPass = true;
        }
        else {
            System.out.println("Zort");
        }
    }

    
}