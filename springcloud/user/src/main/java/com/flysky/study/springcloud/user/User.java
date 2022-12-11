package com.flysky.study.springcloud.user;

public class User {
    private String username;
    private int age;
    private String sex;

    public User(String username, int age, String sex) {
        this.username = username;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
