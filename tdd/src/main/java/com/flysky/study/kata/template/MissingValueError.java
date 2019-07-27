package com.flysky.study.kata.template;

public class MissingValueError extends RuntimeException {
    public MissingValueError(String message) {
        super(message);
    }
}
