package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void setTableSize(){
    Scanner in = new Scanner(System.in);
        System.out.print("Введите размер таблицы:");
        if (!in.hasNextInt())
            System.out.println("Запустите программму еще раз и введите целое положительное число");
        else
    {
        int tableSize = in.nextInt();
        in.close();
    }
    }

    ////////////////////////////////////////////////////
    public static void main (String[] args) {
        setTableSize();
}
}


