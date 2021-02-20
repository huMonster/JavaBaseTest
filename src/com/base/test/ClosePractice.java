package com.base.test;

public class ClosePractice {

    public static class TestClosed implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("调用了close方法!");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        try(TestClosed tc = new TestClosed()){

        }catch(Exception e) {

        }
    }
}
