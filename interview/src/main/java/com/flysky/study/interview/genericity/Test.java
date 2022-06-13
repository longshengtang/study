package com.flysky.study.interview.genericity;

import java.util.List;

public class Test implements IP<Manager> {
    List<Manager> t;
    @Override
    public <Y extends Employee>  List<Y> getY() {
        return (List<Y>) t;
    }

    public static void main(String[] args) {
        Test t = null;
        List<Manager> x = (List<Manager>) t.getX();
        List<Employee> x2 = (List<Employee>) t.getX();

        List<? extends Employee> e = t.getX();
        List<Employee> m = t.getM();

        List<Employee> y = t.getY();

        List<Employee> y1 = t.getY();
        List<Employee> x1 = (List<Employee>) t.getX();
        IP i =t;
        List<Employee> y2 = i.getY();
        for (Employee employee : y2) {
            System.out.println(employee);
        }

    }

    List<Manager> employees;

    @Override
    public List<? extends Employee> getX() {
        return employees;
    }

    @Override
    public List getM() {
        return t;
    }

}

interface IP<T extends Employee>{
    List<? extends Employee> getX();
    List<T> getM();
    <Y extends Employee> List<Y> getY();
}
