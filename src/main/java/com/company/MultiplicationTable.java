package com.company;

import java.util.Scanner;

public class MultiplicationTable {
    private static int tableSize;
    private static int maxValue = tableSize*tableSize;
    //String str = Integer.toString(i);
    private static int FORMAT = Integer.toString(maxValue).length();
    private static String separator = "";
    private static Scanner in;

    public static void getTableSize() {
        in = new Scanner(System.in);
        System.out.print("Введите размер таблицы от 1 до 32:");
        checkTableSize();
    }

    public static void checkTableSize() {
        if (in.hasNextInt()) {
            tableSize = in.nextInt();
            if (tableSize < 1 || tableSize > 32) {
                getTableSize();
            }
        } else {
            System.out.println("Ошибка");
            getTableSize();
        }
    }

    public static void separateTable() {
        separator = ("-".repeat(FORMAT) + "+").repeat(tableSize - 1) + "-".repeat(FORMAT);

    }

    public static void printMultiplicationTable() {
        separateTable();
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                int value = (i + 1) * (j + 1);
                if (j < tableSize - 1) {
                    System.out.printf("%" + FORMAT + "d" + "|", value);
                } else {
                    System.out.printf("%" + FORMAT + "d" + ' ', value);
                }
            }
            System.out.println();
            if (i < tableSize - 1) {
                System.out.println(separator);
            }
        }
    }

    public static void main(String[] args) {
        getTableSize();
        printMultiplicationTable();
        in.close();
    }
}