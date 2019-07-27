package com.flysky.study.kata.merge;

public class OperationStatement {
    private String dimension;
    private int newUserTotal;
    private int newPushTotal;
    private int newTeamTotal;

    public String getDimension() {
        return dimension;
    }

    public OperationStatement setDimension(String dimension) {
        this.dimension = dimension;
        return this;
    }

    public int getNewUserTotal() {
        return newUserTotal;
    }

    public OperationStatement setNewUserTotal(int nweUserTotal) {
        this.newUserTotal = nweUserTotal;
        return this;
    }

    public int getNewPushTotal() {
        return newPushTotal;
    }

    public OperationStatement setNewPushTotal(int newPushTotal) {
        this.newPushTotal = newPushTotal;
        return this;
    }

    public int getNewTeamTotal() {
        return newTeamTotal;
    }

    public OperationStatement setNewTeamTotal(int newTeamTotal) {
        this.newTeamTotal = newTeamTotal;
        return this;
    }

    @Override
    public String toString() {
        return "OperationStatement{" +
                "dimension='" + dimension + '\'' +
                ", newUserTotal=" + newUserTotal +
                ", newPushTotal=" + newPushTotal +
                ", newTeamTotal=" + newTeamTotal +
                '}';
    }
}
