package 多线程.guardedsupension.test;

/**
 * @className Test
 * @Description
 * @Date 2019/7/8 17:24
 * @Author shenguang
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        MyRequestQueue queue = new MyRequestQueue();
        new Server(queue," Request ").start();
        new Client(queue).start();
    }
}
