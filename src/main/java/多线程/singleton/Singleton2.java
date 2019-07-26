package 多线程.singleton;

/**
 * @className Singleton1
 * @Description 懒加载--这种写法会又线程安全问题
 * @Date 2019/6/21 13:21
 * @Author shenguang
 * @Version 1.0
 **/
public class Singleton2 {
    private static  Singleton2 instance ;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if(instance==null){
            instance = new Singleton2();
        }
        return Singleton2.instance;
    }
}
