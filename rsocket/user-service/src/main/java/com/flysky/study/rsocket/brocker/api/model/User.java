package com.flysky.study.rsocket.brocker.api.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String nick;
    public User(int id, String nick) {
        this.id = id;
        this.nick = nick;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                '}';
    }
}
