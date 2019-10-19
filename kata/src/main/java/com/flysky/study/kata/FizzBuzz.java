package com.flysky.study.kata;

import static java.lang.String.valueOf;

public class FizzBuzz {
    public String find(int number) {
        String fizz = "fizz";
        if (remainder(number, 3)) {
            return fizz;
        }
        if (contains(number, "3")) {
            return fizz;
        }
        String buzz = "buzz";
        if (remainder(number, 5)) {
            return buzz;
        }
        if (contains(number, "5")) {
            return buzz;
        }
        return valueOf(number);
    }

    private boolean contains(int number, String s) {
        return valueOf(number).contains(s);
    }

    private boolean remainder(int number, int mod) {
        if (number % mod == 0) {
            return true;
        }
        return false;
    }
}
