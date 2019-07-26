package 多线程.singleton;

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
}
