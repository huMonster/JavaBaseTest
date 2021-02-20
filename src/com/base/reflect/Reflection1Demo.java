package com.base.reflect;

/**
 * @Description 反射实例化对象
 * @Author Monster
 * @Date 2021/1/21 9:51
 * @Version 1.0
 */
class Person{
    public Person(){
        System.out.println("我是Person实例");
    }
    public Person(int a){
        System.out.println("我是Person有参得实例，参数是" + a);
    }

    @Override
    public String toString() {
        return "我是一个好人！";
    }
}
public class Reflection1Demo {

    public static void main(String[] args) {
        /**
         * clz.newInstance() 只能调用无参的构造方法，
         * 因此JDK1.9中被弃用，使用clz.getDeclaredConstructor().newInstance()代替
         * 通过 getDeclaredConstructor(int.class,String.class)指定参数类型搜索构造函数，
         * 在实例化（newInstance）的时候传参数，未指定参数类型就返回无参构造方法
         */
        try {
            Class clz = Class.forName("com.base.reflect.Person");
            // 只能调用无参
            Object o = clz.newInstance();
            // 调用有参构造函数，并传入参数
            Object o2 = clz.getDeclaredConstructor(int.class).newInstance(5);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
