package com.base.reflect;

/**
 * @Description AnimalTest
 * @Author Monster
 * @Date 2021/1/15 11:20
 * @Version 1.0
 */
public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println(name);
    }
}
