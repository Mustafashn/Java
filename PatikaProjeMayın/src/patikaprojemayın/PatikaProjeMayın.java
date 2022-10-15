/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patikaprojemayın;

import java.util.Scanner;

/**
 *
 * @author musta
 */
public class PatikaProjeMayın {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the row : ");
        int row = scan.nextInt();
        scan.nextLine();
        System.out.print("Please enter the column: ");
        int column = scan.nextInt();

        MineSweeper mn = new MineSweeper(row, column);
        String[][] list = mn.create_empty_list();
        String[][] list1 = mn.create_empty_list();

        String[][] minelist = mn.create_mine(list);
        mn.draw(minelist);
        System.out.println("************");
        int sayac = mn.isDone(row * column - row * column / 4);
        while (true) {
            int[] positions = mn.take_position();
            list1 = mn.check_position(positions, minelist, list1);
            mn.draw(list1);
            sayac = mn.isDone(sayac);
        }

    }

}
