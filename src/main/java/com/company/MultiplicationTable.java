package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class MultiplicationTable {

    public static int getTableSize(BufferedReader in) throws IOException {
        int tableSize;
        System.out.print("Введите размер таблицы от 1 до 32:");
        String line = in.readLine();

        if (checkIsInt(line)) {
            tableSize = Integer.parseInt(line);
            if (checkTableSize(tableSize)) {
                tableSize = getTableSize(in);
            }
        } else {
            System.out.println("Ошибка");
            tableSize = getTableSize(in);
        }
        return tableSize;
    }

    public static boolean checkIsInt(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
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
        int tableSize;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));) {
            tableSize = getTableSize(in);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(MultiplicationTable.class.getName()).log(Level.SEVERE, null, ex);
            tableSize = 0;
        }
        printMultiplicationTable(tableSize);
    }
}

