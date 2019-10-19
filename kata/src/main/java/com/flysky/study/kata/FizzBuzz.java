package com.flysky.study.kata;

import static java.lang.String.valueOf;

public class FizzBuzz {
    public String find(int input) {
        if (input%3==0) {
            return "fizz";
        }
        return valueOf(input);
    }
}
