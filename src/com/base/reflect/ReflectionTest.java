package com.base.reflect;

import com.base.utils.TestUtil;

import java.lang.reflect.Field;

/**
 * 通过反射调用私有属性或变量
 *
 * @author Monster
 *
 */
public class ReflectionTest {
    public static void main(String[] args) {
        try {
            TestUtil testUtil = new TestUtil();
            Class<?> clazz = testUtil.getClass();
//            Method[] methods = clazz.getDeclaredMethods();
//            Method method = methods[0];
//            Object o = method.invoke("priMethod");
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(testUtil, "哈哈哈");
            testUtil.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
