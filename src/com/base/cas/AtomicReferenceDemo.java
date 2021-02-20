package com.base.cas;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description CAS的原子引用,不再受限于基本类型，可以使用引用类型
 * @Author Monster
 * @Date 2021/1/22 11:25
 * @Version 1.0
 */
class User {
    String userName;
    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3", 22);
        User l4 = new User("l4", 25);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, l4) + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, l4) + atomicReference.get().toString());
    }
}
