package com.base.JDK8;

import java.util.Optional;

/**
 * @Description JDK8 Optional类 主要解决NullPointerException的
 * @Author Monster
 * @Date 2021/1/28 13:27
 * @Version 1.0
 */
class User{
    private Address address;

//    public Address getAddress() {
//        return address;
//    }
    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}
class Address{
    private Country country;

//    public Country getCountry() {
//        return country;
//    }
    public Optional<Country> getCountry(){
        return Optional.ofNullable(country);
    }
}
class Country{
    private String name;

//    public String getName() {
//        return name;
//    }
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class OptionalDemo {
    public static void main(String[] args) throws Exception {
        // 情景代码
//        User user = new User();
//        if(user != null){
//            Address address = user.getAddress();
//            if(address != null){
//                Country country = address.getCountry();
//                if(country != null){
//                    // ...
//                }
//            }
//        }

        Country country = new Country();
        country.setName("我是谁");

        // 使用Optional类
        User user = new User();
        Optional<String> name = Optional.ofNullable(user)
                .flatMap(u -> u.getAddress())
                .flatMap(u -> u.getCountry())
                .flatMap(u -> u.getName());

        System.out.println(name);

    }
}
