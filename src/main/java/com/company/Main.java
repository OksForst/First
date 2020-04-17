package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {

    private static int tableSize;
    private static int format = 4;
    private static String separator = "";
    private static Scanner in;

    public static void getTableSize() {
        in = new Scanner(System.in);
        System.out.print("Введите размер таблицы:");
        if (in.hasNextInt()) {
            tableSize = in.nextInt();
            if (tableSize < 1) {
                getTableSize();
            }
        } else {
            System.out.println("Ошибка. Введите число");
            getTableSize();
        }
    }

    public static void printTable() {
        String separator = ("-".repeat(format) + "+").repeat(tableSize - 1) + "-".repeat(format);
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                int value = (i + 1) * (j + 1);
                String tf = "%" + format + "d" + "|";
                String tf1 = "%" + format + "d" + ' ';
                if (j < tableSize - 1) {
                    System.out.printf(tf, value);
                } else {
                    System.out.printf(tf1, value);
                }
            }
            System.out.println();
            if (i < tableSize - 1) {
                System.out.println(separator);
            }
        }
    }

    ////////////////////////////////////////////////////
    public static void main(String[] args) {
        getTableSize();
        printTable();
        in.close();
    }
}