package com.qf.domain;

public class Order {
    private int id;
    private double amount;
    private String state;
    private String time;
    private int uid;

    public Order() {
    }

    public Order(int id, double amount, String state, String time, int uid) {
        this.id = id;
        this.amount = amount;
        this.state = state;
        this.time = time;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", state='" + state + '\'' +
                ", time='" + time + '\'' +
                ", uid=" + uid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
