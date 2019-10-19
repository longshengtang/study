package com.flysky.study.kata;

import static java.lang.String.valueOf;

public class FizzBuzz {
    public String find(int input) {
        if (input%3==0) {
            return "fizz";
        }
        if (input%5==0) {
            return "buzz";
        }
        return valueOf(input);
    }
}
