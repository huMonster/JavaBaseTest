package com.base.jvm.oom;

/**
 * @Description OOM异常之栈溢出  默认大小512k~1024k
 * @Author Monster
 * @Date 2021/2/20 11:00
 * @Version 1.0
 */
public class StackOverflowErrorDemo {

    /**
     * StackOverflowError 属于 Error
     * 结构： java.lang.Object
     *          java.lang.Throwable
     *             java.lang.Error
     *                  java.lang.VirtualMachineError
     * @param args
     */
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        // Exception in thread "main" java.lang.StackOverflowError
        stackOverflowError();
    }
}
