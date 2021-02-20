package com.base.jvm;

/**
 * @Description StackErrorMock 栈异常
 * @Author Monster
 * @Date 2020/12/30 11:16
 * @Version 1.0
 */
public class StackErrorMock {
    private static int index = 1;

    // 当申请不到空间时，会抛出 OutOfMemoryError
    // 当栈调用深度大于JVM所允许的范围，会抛出StackOverflowError的错误
    public void call(){
        index++;
        call();
    }


    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable e) {
            // StackOverflowError 和 OutOfMemoryError都属于Throwable
            System.out.println("Stack deep : "+index);
            e.printStackTrace();
        }
    }
}
