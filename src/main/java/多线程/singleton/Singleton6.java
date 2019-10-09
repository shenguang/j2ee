package 多线程.singleton;

import java.util.stream.IntStream;

/**
 * @className Singleton5
 * @Description Holder方式  优雅
 *
 * @Date 2019/6/21 13:21
 * @Author shenguang
 * @Version 1.0
 **/
public class Singleton6 {
    private Singleton6(){}

    private static  class InstanceHolder{

        private final  static  Singleton6 instance = new Singleton6();

        public static  Singleton6 getInstance(){
            return InstanceHolder.instance;
        }

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
