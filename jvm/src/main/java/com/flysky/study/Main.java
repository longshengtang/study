package com.flysky.study;

import java.util.Scanner;

public class Main {

    public int calc(int in) {

        if (in < 2)
            return 0;

        if (in == 2) {
            return 1;
        }
        //1,2,3----1
        //10 ------5
        //81 ------40
//        int i =in;
//        for (int j = 0; j < i; j++) {
//
//        }

        int result = in/2;

        return result;
//        return calc(in - 2) + 1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int next = 0;
        while ((next = in.nextInt()) > 0) {
            if (next > 1000) {
                System.out.println("请输入1 --- 100");
                continue;
            }
            System.out.println(main.calc(next));
        }
    }
}
