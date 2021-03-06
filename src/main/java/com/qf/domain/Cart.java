package com.qf.domain;

public class Cart {
    private int id;
    private int pid;
    private int Num;
    private int money;

    private String goodName;

    public Cart() {
    }

    public Cart(int id, int pid, int num, int money, String goodName) {
        this.id = id;
        this.pid = pid;
        Num = num;
        this.money = money;
        this.goodName = goodName;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", pid=" + pid +
                ", Num=" + Num +
                ", money=" + money +
                ", goodName='" + goodName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}
