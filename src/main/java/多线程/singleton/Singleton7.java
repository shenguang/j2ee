package 多线程.singleton;

import java.util.stream.IntStream;

/**
 * @className Singleton5
 * @Description 枚举方式  优雅
 *
 * 枚举类是线程安全的  构造参数只被装载一次
 *
 * @Date 2019/6/21 13:21
 * @Author shenguang
 * @Version 1.0
 **/
public class Singleton7 {
    private Singleton7(){}

    private enum  Singleton{
        INSTANCE;

        private final Singleton7 instance;

        Singleton(){
            instance = new Singleton7();
        }

        public Singleton7 getInstance(){
            return instance;
        }
    }
    public static Singleton7 getInstance(){
        return  Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(i->new Thread(String.valueOf(i)){
            @Override
            public void run() {
                System.out.println(Singleton7.getInstance());
            }
        }.start());
    }
}
