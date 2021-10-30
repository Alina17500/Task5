package ru.vsu.cs.volobueva;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int s = checkCorrectValueAndRead();

        buildDrawing(s);
    }

    static int checkCorrectValueAndRead() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a number s: ");
        int value = scanner.nextInt();

        if (value < 3 || value % 2 == 0) {
            System.out.println("The entered number is incorrect. Read the condition again and try again:");
            return checkCorrectValueAndRead();
        }
        return value;
    }

    static void buildDrawing(int s) {
        int grid = (s+1)/2; //количество решеток в строке
        int star = (s+1)/2; //количество звездочек в строке
        int between = -1; //отступы - расстояния между # и *

        buildFirstLine(grid, star - 1);

        for (int row = 0; row < s/2 - 1; row++) {
            System.out.println();
            grid--;
            star--;
            between += 2;
            buildPart1(star, grid, between);
        }

        buildCentralLine(between + 2);

        for (int row = 0; row < s/2 - 1; row++) {
            System.out.println();
            buildPart2(star, grid, between);
            grid++;
            star++;
            between -= 2;
        }

        buildLastLine(star - 1, grid);
    }

    static void buildFirstLine(int grid, int star) {
        for (int i = 0; i < grid; i++) {
                System.out.print("#");
        }

        for (int i = 0; i < star; i++) {
            System.out.print("*");
        }
    }

    static void buildLastLine(int star, int grid) {
        System.out.println();
        for (int i = 0; i < star; i++) {
            System.out.print("*");
        }

        for (int i = 0; i < grid; i++) {
            System.out.print("#");
        }
    }

    static void buildPart1(int star, int grid, int between) {
        for (int i = 0; i < grid; i++) {
            System.out.print("#");
        }

        for (int i = 0; i < between; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < star; i++) {
            System.out.print("*");
        }
    }
    static void buildCentralLine(int between) {
        System.out.println();
        System.out.print("#");

        for (int i = 0; i < between; i++) {
            System.out.print(" ");
        }

        System.out.print("#");
    }

    static void buildPart2(int star, int grid, int between) {
        for (int i = 0; i < star; i++) {
            System.out.print("*");
        }

        for (int i = 0; i < between; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < grid; i++) {
            System.out.print("#");
        }
    }
}
