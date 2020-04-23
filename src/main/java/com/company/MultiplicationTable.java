package com.company;

import java.util.Scanner;

public class MultiplicationTable {
    private static Scanner in;

    public static int getTableSize(Scanner in) {
        int tableSize;

        if (in.hasNextInt()) {
            tableSize = in.nextInt();
            if (checkTableSize(tableSize)) {
                tableSize = getTableSize(in);
            }
        } else {
            System.out.println("Ошибка");
            tableSize = getTableSize(in);
        }
        return tableSize;

    }

    public static boolean checkTableSize(int tableSize) {
        boolean result = false;
        if ((tableSize < 1) || (tableSize > 32)) {

            result = true;

        }
        return result;
    }

    public static void printMultiplicationTable(int tableSize) {
        int maxValueTable = tableSize * tableSize;
        int formatSize = String.valueOf(maxValueTable).length();
        String separator = ("-".repeat(formatSize) + "+").repeat(tableSize - 1) + "-".repeat(formatSize);
        for (int i = 0; i < tableSize; i++) {

            for (int j = 0; j < tableSize; j++) {
                int value = (i + 1) * (j + 1);
                if (j < tableSize - 1) {
                    System.out.printf("%" + formatSize + "d" + "|", value);
                } else {
                    System.out.printf("%" + formatSize + "d" + ' ', value);
                }
            }
            System.out.println();
            if (i < tableSize - 1) {
                System.out.println(separator);
            }
        }
    }

    public static void main(String[] args) {
        int num;
        System.out.print("Введите размер таблицы от 1 до 32:");
        try (Scanner in = new Scanner(System.in)) {
            num = getTableSize(in);
        }

        //System.out.println(format);
        printMultiplicationTable(num);
        //in.close();
    }
}
