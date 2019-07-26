package 多线程.singleton;

/**
 * @className Singleton3
 * @Description 解决来加载--这种写法会又线程安全问题
 * 无论是获取还是创建都要得到锁 这种方法会对性能又很大损耗
 * @Date 2019/6/21 13:21
 * @Author shenguang
 * @Version 1.0
 **/
public class Singleton3 {
    private static Singleton3 instance ;
    private Singleton3(){}

    public synchronized static Singleton3 getInstance(){
        if(instance==null){
            instance = new Singleton3();
        }
        return Singleton3.instance;
    }
}
