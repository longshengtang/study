package com.flysky.study.kata;

import static java.lang.String.valueOf;

public class FizzBuzz {
    public String find(int input) {
        if (isDivisibleBy(input, 3)&&isDivisibleBy(input, 5)) {
            return "fizzBuzz";
        }
        if (isDivisibleBy(input, 3)) {
            return "fizz";
        }
        if (isDivisibleBy(input, 5)) {
            return "buzz";
        }
        return valueOf(input);
    }

    private boolean isDivisibleBy(int input, int mod) {
        return input % mod == 0;
    }
}
