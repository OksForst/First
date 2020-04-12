package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер таблицы:");
        if (in.hasNextInt()== false)
            System.out.println("Запустите программу еще раз и введите целое положительное число");
        else {
            int tableSize = in.nextInt();
            in.close();

            if (tableSize > 0) {
                int size = 32 * 32;
                String formatSize = String.valueOf(size);
                int format = formatSize.length();
                String separator = ( "-".repeat(format) + "+").repeat(tableSize - 1)+ "-".repeat(format);
                for (int i = 0; i < tableSize; i++) {
                    for (int j = 0; j < tableSize; j++) {
                        int value = (i + 1) * (j + 1);
                        String tf = "%" + format + "d" + "|";
                        String tf1 = "%" + format + "d" + " ";
                        if (j < tableSize - 1) {
                            System.out.printf(tf, value);
                        } else System.out.printf(tf1, value);
                    }
                    System.out.println();
                    if (i < tableSize - 1) {
                        System.out.println(separator);
                    }
                }
            } else System.out.println("Запустите программу еще раз и введите целое положительное число");
        }
    }
}

