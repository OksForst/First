package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {
    private static int tableSize;
    private static int format = 4;



    public static void getTableSize(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер таблицы:");
        if (!in.hasNextInt()) {
            System.out.println("Ошибка. Введите число");
            getTableSize();
        }
        else
        {
            tableSize = in.nextInt();
            in.close();
        }
    }



    public static void checkTableSize() {
        if (tableSize > 0) {
            String separator = ("-".repeat(format) + "+").repeat(tableSize - 1) + "-".repeat(format);
            for (int i = 0; i < tableSize; i++) {
                for (int j = 0; j < tableSize; j++) {
                    int value = (i + 1) * (j + 1);
                    String tf = "%" + format + "d" + "|";
                    String tf1 = "%" + format + "d" + ' ';
                    if (j < tableSize - 1) {
                        System.out.printf(tf, value);
                    } else
                        System.out.printf(tf1, value);
                }
                System.out.println();
                if (i < tableSize - 1) {

                    System.out.println(separator);
                }
            }
        }
        System.out.println("Запустите программу еще раз и введите целое положительное число");
        if (tableSize < 1) getTableSize();

    }
    ////////////////////////////////////////////////////
    public static void main (String[] args) {
        getTableSize();
        checkTableSize();
    }
}