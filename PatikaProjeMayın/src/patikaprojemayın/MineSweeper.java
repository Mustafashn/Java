/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patikaprojemayın;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author musta
 */
public class MineSweeper {

    int row;
    int column;

    public MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void draw(String list[][]) {
        for (String[] row : list) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }

    }

    public String[][] create_empty_list() {
        String list[][] = new String[this.row][this.column];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                list[i][j] = "-";
            }
        }
        return list;
    }

    public String[][] create_mine(String[][] list) {
        int mine1, mine2;
        int numb = this.row * this.column / 4;
        Random rnd = new Random();

        for (int i = 0; i < numb; i++) {
            boolean add = true;
            while (add) {
                mine1 = rnd.nextInt(this.row);
                mine2 = rnd.nextInt(this.column);
                if (!list[mine1][mine2].equals("*")) {
                    list[mine1][mine2] = "*";
                    add = false;
                }
            }

        }
        return list;
    }

    public int[] take_position() {
        Scanner scan = new Scanner(System.in);
        int[] mines = new int[2];
        int row = -1, column = -1;
        boolean error = true;
        while (error) {
            try {
                System.out.print("Please enter the row: ");
                row = scan.nextInt();
                System.out.print("Please enter the column: ");
                column = scan.nextInt();
                if ((row < this.row) && (row >= 0)) {
                    error = false;
                }
                if ((column < this.column) && (column >= 0)) {
                    error = false;
                }

            } catch (Exception e) {
                scan.nextLine();
                System.out.println("aa");

            }
        }

        mines[0] = row;
        mines[1] = column;
        return mines;
    }

    public String[][] check_position(int[] list, String[][] game, String[][] bos) {
        int counting = 0;

        if (game[list[0]][list[1]].equals("*")) {
            System.out.println("BOOM.");
            System.exit(0);
        } else {
            if (list[0] == 0) {
                if (list[1] == 0) {
                    if (game[0][1].equals("*")) {
                        counting++;
                    }
                    if (game[1][0].equals("*")) {
                        counting++;
                    }
                } else if (list[1] == this.column - 1) {
                    if (game[0][this.column - 2].equals("*")) {
                        counting++;
                    }
                    if (game[1][this.column - 1].equals("*")) {
                        counting++;
                    }
                } else {
                    if (game[0][list[1] - 1].equals("*")) {
                        counting++;
                    }
                    if (game[0][list[1] + 1].equals("*")) {
                        counting++;
                    }
                    if (game[1][list[1]].equals("*")) {
                        counting++;
                    }
                }
            } else if (list[0] == this.row - 1) {
                if (list[1] == 0) {
                    if (game[this.row - 2][0].equals("*")) {
                        counting++;
                    }
                    if (game[this.row - 1][1].equals("*")) {
                        counting++;
                    }
                } else if (list[1] == this.column - 1) {
                    if (game[this.row - 1][this.column - 2].equals("*")) {
                        counting++;
                    }
                    if (game[this.row - 2][this.column - 1].equals("*")) {
                        counting++;
                    }
                } else {
                    if (game[this.row - 1][list[1] - 1].equals("*")) {
                        counting++;
                    }
                    if (game[this.row - 1][list[1] + 1].equals("*")) {
                        counting++;
                    }
                    if (game[this.row - 2][list[1]].equals("*")) {
                        counting++;
                    }
                }
            } else {
                if (list[1] == 0) {
                    if (game[list[0] - 1][0].equals("*")) {
                        counting++;
                    }
                    if (game[list[0] + 1][0].equals("*")) {
                        counting++;
                    }
                    if (game[list[0]][1].equals("*")) {
                        counting++;
                    }
                } else if (list[1] == this.column - 1) {
                    if (game[list[0]][this.column - 2].equals("*")) {
                        counting++;
                    }
                    if (game[list[0] - 1][this.column - 1].equals("*")) {
                        counting++;
                    }
                    if (game[list[0] + 1][this.column - 1].equals("*")) {
                        counting++;
                    }
                } else {
                    if (game[list[0]][list[1] + 1].equals("*")) {
                        counting++;
                    }
                    if (game[list[0]][list[1] - 1].equals("*")) {
                        counting++;
                    }
                    if (game[list[0] - 1][list[1]].equals("*")) {
                        counting++;
                    }
                    if (game[list[0] + 1][list[1]].equals("*")) {
                        counting++;
                    }
                }
            }
        }
        String sayi = String.valueOf(counting);

        bos[list[0]][list[1]] = sayi;
        return bos;
    }

    public int isDone(int number) {
        if (number == 0) {
            System.out.println("Oyun kazanıldı.\n Çıkış yapılıyor...");
            System.exit(0);
        }
        return number - 1;
    }
}
