package 多线程.singleton;

/**
 * @className Singleton1
 * @Description 饿汉--能够实现线程安全-不能懒加载
 * @Date 2019/6/21 13:21
 * @Author shenguang
 * @Version 1.0
 **/
public class Singleton1 {
    private static  final Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public static  Singleton1 getInstance(){
        return instance;
    }
}
