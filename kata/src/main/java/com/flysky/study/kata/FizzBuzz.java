package com.flysky.study.kata;

public class FizzBuzz {
    public String find(int number) {
        if (number % 3 == 0) {
            return "fizz";
        }
        if (number % 5 == 0) {
            return "buzz";
        }
        return String.valueOf(number);
    }
}
