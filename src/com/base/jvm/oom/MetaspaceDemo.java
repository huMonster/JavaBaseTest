package com.base.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description OOM之Metaspace
 * @Author Monster
 * @Date 2021/2/20 17:11
 * @Version 1.0
 */
public class MetaspaceDemo {

    static class OOMTest{
        
    }
    /**
     * JVM参数：
     * -XX:MetaspaceSize=9m -XX:MaxMetaspaceSize=9m
     *
     * Caused by: java.lang.OutOfMemoryError: Metaspace
     *
     * java8及其以后使用metaspace代替permanent gen
     * Metaspace是方法去在Hot Spot中的实现，它与持久代最大的区别在于：Metaspace并不在虚拟机内存中，而是在本地内存
     * 即classes metadata被存储在叫做Metaspace的native memory
     *
     * Permanent generation 存放一下信息：
     *  VM 加载的类信息
     *  常量池
     *  静态变量
     *  即时编译后的代码
     *
     *  模拟Metaspace空间溢出，我们不断生成类往元空间灌，类占据的空间总是会超过Metaspace指定的空间大小
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;

        try {
            while(true){
                i++;
                // 使用CGLIB生成代理:
                // 1.创建核心类:
                Enhancer enhancer = new Enhancer();
                // 2.为其设置父类:
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                // 3.设置回调:
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy)
                            throws Throwable {
                        return methodProxy.invokeSuper(object, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("**********多少次后发生了异常：  " + i);
            e.printStackTrace();
        }
    }
}
