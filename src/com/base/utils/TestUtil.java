package com.base.utils;

import java.io.*;

public class TestUtil {

    private String name = "Test的私有属性";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void priMethod() {
        System.out.println("私有方法！");
    }

    public void print() {
        System.out.println("print方法！" + name);
    }

    public static void main(String[] args) {
//        try (InputStream in = new FileInputStream("E:\\io流测试.txt")) {
//            int i = 0;
//            while ((i = in.read()) != -1) {
//                System.out.print((char) i + " ");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("E:\\io流测试.txt"))) {
//            char[] chs = {'E', 'F', 'G'};
//            writer.write(chs);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        try (InputStream in = new FileInputStream("E:\\io流测试.txt");BufferedInputStream bs = new BufferedInputStream(in)) {
//            byte[] bytes = new byte[20];
//            int len = 0;
//            while (( len = bs.read(bytes)) == -1){
//                System.out.println(new String(bytes, 0, len));
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
        try (BufferedOutputStream bio = new BufferedOutputStream(new FileOutputStream("E:\\io流测试.txt", true))) {
            String str = "EFG";
            bio.write(str.getBytes());
            bio.flush();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
