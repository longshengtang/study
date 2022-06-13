package com.flysky.study.flink;

public class Alert {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                '}';
    }
}
