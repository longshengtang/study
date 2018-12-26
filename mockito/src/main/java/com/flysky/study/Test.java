package com.flysky.study;

public class Test {
    public static void t(int flag, int x, int y, int z) {
        if (x > 3) {
            z = z + 1;
        } else {
            x = flag;
        }

        if (y == 4) {
            z = y + 1;
        } else {
            x = 1;
        }

        if (x < 2) {
            z = z / 2;
        } else {
            y = -5;
        }

        z = y + x - z;
        if (y > 0) {
            z = x + y;
        } else {
            z = -1;
        }
        System.out.println(z);
    }
}
