/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patikaogrencibilg;

/**
 *
 * @author musta
 */
public class Course{
    String name;
    String code;
    String prefix;
    int note;
    Teacher teacher;

    public Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        int note = 0;
        this.teacher=teacher;
    }
    public void addTeacher(Teacher teacher) {
        if( teacher.branch.equals(this.name)) {
        this.teacher=teacher;
        System.out.println("Teacher add completed.");
        teacher.print();
        System.out.println("****************** \n");
        
        }
        else {
            System.out.println("This teacher cannot add this course.");
        }
    }
    
}
