package com.base.keyword.useTransient;

import java.io.*;

/**
 * @Description 使用Externalizable接口，指定序列化的字段不管是否使用transient关键字修饰，都会被序列化
 * @Author Monster
 * @Date 2021/3/19 14:57
 * @Version 1.0
 */
class User1 implements Externalizable {

    private String name;
    private transient int age;

    //静态变量
    private static String sex;
    private transient static String address;

    // 不加无参构造函数，会报错：InvalidClassException
    public User1() {
    }

    public User1(String gender, String addr) {
        sex = gender;
        address = addr;

    }
    public User1(String name, int age, String gender, String addr) {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
        out.writeObject(sex);
        out.writeObject(address);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = (int) in.readObject();
        sex = (String) in.readObject();
        address = (String) in.readObject();
    }
}

public class ExternalizableDemo {

    public static void serializableUser1() {
        User1 user = new User1("李四", 23, "男", "深圳");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Code\\ioTest\\transientTest.txt"))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new User1("女", "广州");
        System.out.println(user.toString());

    }

    public static void deSerializableUser1() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Code\\ioTest\\transientTest.txt"))) {
            User1 user = (User1) ois.readObject();
            System.out.println(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /**
         * 结论： 指定序列化的变量不管是普通变量还是静态变量都会被序列化
         */
        serializableUser1();
        deSerializableUser1();
    }
}
