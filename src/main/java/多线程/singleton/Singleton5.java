package 多线程.singleton;

/**
 * @className Singleton5
 * @Description 解决来加载--这种写法会又线程安全问题
 *
 * 无论是获取还是创建都要得到锁 这种方法会对性能又很大损耗
 *
 * Singleton4--解决性能问题(双重校验)  但是有可能引起空指针异常（由于重排序---happenbefore原则）
 *
 * Singleton5--解决指令重排的问题(volatile:1 线程可见性 2：防止指令重排)
 *
 * @Date 2019/6/21 13:21
 * @Author shenguang
 * @Version 1.0
 **/
public class Singleton5 {
    private static volatile Singleton5 instance ;
    private Singleton5(){}

    public  static Singleton5 getInstance(){
        if(instance==null){
            synchronized(Singleton5.class){
                if(instance==null){
                    instance = new Singleton5();
                }
            }
        }
        return Singleton5.instance;
    }
}
