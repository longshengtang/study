package com.flysky.study.kata.merge;

public class OperationData {
    private String dimension;
    private int total;

    public String getDimension() {
        return dimension;
    }

    public OperationData setDimension(String dimension) {
        this.dimension = dimension;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public OperationData setTotal(int total) {
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return "OperationData{" +
                "dimension='" + dimension + '\'' +
                ", total=" + total +
                '}';
    }
}
