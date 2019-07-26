package 多线程.singleton;

/**
 * @className Singleton4
 * @Description 解决来加载--这种写法会又线程安全问题
 * 无论是获取还是创建都要得到锁 这种方法会对性能又很大损耗
 * --解决性能问题(双重校验)  但是有可能引起空指针异常（由于重排序---happenbefore原则）
 * @Date 2019/6/21 13:21
 * @Author shenguang
 * @Version 1.0
 **/
public class Singleton4 {
    private static Singleton4 instance ;
    private Singleton4(){}

    public  static Singleton4 getInstance(){
        if(instance==null){
            synchronized(Singleton4.class){
                if(instance==null){
                    instance = new Singleton4();
                }
            }
        }
        return Singleton4.instance;
    }
}
/**
 简单的理解：
 由于java实例化一个对象的操作（new）不是原子性的。所以在线程a 在执行到 代码  3 处时，当3完成了一部分时，instance就已经非null了，
 但是此时实例对象并没有构造完成。假如这个时候线程b进来if语句就会得道instance不是null， 会直接拿到未完成的 instance，从而导致空指针。
 说明：
 java创建一个对象，在java虚拟机上会进行以下三步操作
 1、给instance分配内存
 2、调用构造方法 初始化
 3、指向内存分配区域
 这里牵涉到一个重排序的问题。也就是123的执行顺序是随机的。而其中的3执行完后对象就不为null了
 所以当3在2的前面执行时，当2执行完3还未执行时，其他线程进来就会返回未执行3的实例对象，从而导致空指针
 **/