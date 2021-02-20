package com.base.reflect;

/**
 * @Description Reflect2Demo
 * @Author Monster
 * @Date 2021/1/21 10:13
 * @Version 1.0
 */
interface IMessage{
    // 定义发送消息的接口
    public void send();
}
interface IConn{
    // 连接请求
    public void conn();
}
class Message implements IMessage{

    @Override
    public void send() {
        System.out.println("发送消息！！！");
    }
}
class Conn implements IConn{
    @Override
    public void conn() {
        System.out.println("连接请求收到！！！");
    }
}
class Factory {
    private Factory() {
        // 不产生实例化
    }

//    public static IMessage getInstance(String classname) throws Exception{
//        // 静态工厂模式
//        // 缺点：如果追加一个子类，工厂类就要进行相应的修改，否则无法获取新的子类实例化对象
////        if("Message".equals(classname)){
////            return new Message();
////        }
////        return null;
//        // 解决：通过工厂设计模式不直接new对象完成实例化操作，即工厂模式 + 反射
//        // 优点：子类的扩充将不再影响工厂类的定义
////        return (IMessage) Class.forName(classname).newInstance();
//    }
    /**
     * 上述解决的问题：实际开发中，通常有大量的接口，并且这些接口都要通过工厂类来实例化。
     *               因此工厂设计模式不能只为Message服务，而应该变为所有的接口服务，即加入泛型
     *               classname = 路径 + 实现类名称
     *               tClass = 类名（可以是实现类名称.class，也可以是接口名称.class）
     *  结论：此时的工厂设计模式才是高可用的，而这种操作最依赖泛型，且不再受制于指定的接口，可以为所有接口提供实例化对象
     */
    public static <T> T getInstance(String classname, Class<T> tClass) throws Exception{
        return tClass.cast(Class.forName(classname).newInstance());
    }
}
public class Reflection2Demo {

    public static void main(String[] args) throws Exception {
        /*
        缺点：在实际开发中，接口的主要作用是为不同的层提供一个操作标准，
        如果直接将一个子类设置为接口的实例化操作，那么一定有耦合问题
        解决：工厂设计模式
         */
//        IMessage message = new Message();
//        message.send();


        // 工厂模式
        IMessage instance = Factory.getInstance("com.base.reflect.Message", Message.class);
        instance.send();
        IConn conn = Factory.getInstance("com.base.reflect.Conn", Conn.class);
        conn.conn();

    }
}
