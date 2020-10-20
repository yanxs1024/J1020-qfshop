package com.qf.domain;

public class Goods_type {
    private int id;
    private String name;
    private int level;
    private int Parent;

    public Goods_type() {
    }

    public Goods_type(int id, String name, int level, int parent) {
        this.id = id;
        this.name = name;
        this.level = level;
        Parent = parent;
    }

    @Override
    public String toString() {
        return "Goods_type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", Parent=" + Parent +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParent() {
        return Parent;
    }

    public void setParent(int parent) {
        Parent = parent;
    }
}
