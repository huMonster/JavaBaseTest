package com.base.keyword.useTransient;

import java.io.*;

/**
 *  Serializable接口本身不参与序列化，它只相当于一个通知标记，JVM会去实现序列化
 */
class User implements Serializable {
    // 序列化标号，反序列化时识别此标号
    private static final long serialVersionUID = 1L;

    private String name;
    // 将age指定不参与序列化
    private transient int age;

    //静态变量
    private static String sex;
    private transient static String address;

    public User(String gender, String addr) {
        sex = gender;
        address = addr;

    }
    public User(String name, int age, String gender, String addr) {
        this.name = name;
        this.age = age;
        sex = gender;
        address = addr;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                "age='" + age + '\'' +
                "sex='" + sex + '\'' +
                ", address=" + address +
                '}';
    }
}
/**
 * @Description transient关键字标记的变量不参与序列化
 * @Author Monster
 * @Date 2021/3/19 14:12
 * @Version 1.0
 */
public class SerializableDemo {
    public static void serializableUser(){
        User user = new User("张三",24, "男", "深圳");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\Code\\ioTest\\transientTest.txt"))) {
            outputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new User("女", "广州");
        // 打印IO操作的age的值
        System.out.println(user.toString());
    }

    public static void deSerializable(){
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\Code\\ioTest\\transientTest.txt"))) {
            User user = (User) inputStream.readObject();
            // 如果参与序列化，会打印age的值，反之，则不然
            System.out.println(user.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        /**
         * 结论：1、被transient标记的变量不参与序列化
         *      2、静态变量不管是否使用transient修饰，均不参与序列化
         *      由于静态变量在方法区存着，流里面没有写入静态变量，打印静态变量时会全局查找，因此在方法区中取静态变量的值
         */
        serializableUser();
        deSerializable();
    }
}
