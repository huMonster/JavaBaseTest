package com.base.test;

class B extends A{

    public void colse() {
        System.out.println("B的Public");
    }
}

class A{
    public void colse(){
        System.out.println("A的public方法！");
    }

    void test(){
        System.out.println("A的私有方法！");
    }
}
public class OverrideTest extends A{

    public static void main(String[] args) {
        A a = new B();
        a.test();
    }
}