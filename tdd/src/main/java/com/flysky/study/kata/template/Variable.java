package com.flysky.study.kata.template;

import java.util.Map;

public class Variable implements Segment {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        return this.name.equals(((Variable) obj).name);
    }


    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String evaluate(Map<String, String> variables) {
        if (!variables.containsKey(name)) {
            throw new MissingValueError("No value for ${"+name+"}");
        }
        return variables.get(name);
    }
}
