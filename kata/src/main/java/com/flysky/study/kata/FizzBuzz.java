package com.flysky.study.kata;

import static java.lang.String.valueOf;

public class FizzBuzz {
    public String find(int number) {
        if (number % 3==0) {
            return "fizz";
        }
        if (number%5==0) {
            return "buzz";
        }
        return valueOf(number);
    }
}
