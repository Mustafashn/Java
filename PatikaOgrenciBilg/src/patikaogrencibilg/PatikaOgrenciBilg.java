/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patikaogrencibilg;

/**
 *
 * @author musta
 */
public class PatikaOgrenciBilg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Teacher t1 = new Teacher("Mahmut","Pyhsic","555");
     Teacher t2 = new Teacher("Recaizade","Chemistry","444");
     Teacher t3 = new Teacher ("Kazım","Math","333");
     
     Course pyhsic = new Course("Pyhsic","101","PYH");
     pyhsic.addTeacher(t1);
     
     Course chemistry = new Course("Chemistry","101","CHE");
     chemistry.addTeacher(t2);
     
     Course math = new Course("Math", "101", "MATH");
     math.addTeacher(t3);
     
     Student s1 = new Student("Ali", "123", 1, math, pyhsic, chemistry);
     s1.adBulkExamNote(50, 150, 80);
     s1.isPass();
    }
    
}
