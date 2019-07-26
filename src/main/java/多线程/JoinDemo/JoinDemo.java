package 多线程.JoinDemo;

/**
 * @className JoinDemo
 * @Description  A,B 并行执行完毕之后执行C最后执行D
 * @Date 2019/6/11 16:19
 * @Author shenguang
 * @Version 1.0
 **/
public class JoinDemo {
    public static void main(String[] args) throws Exception{
        Thread threadA = new Thread("A线程") {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("A线程---" + i);
                }
            }
        };

        Thread threadB =new Thread("B线程") {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("B线程---" + i);
                }
            }
        };
        Thread threadC =new Thread("C线程") {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("C线程---" + i);
                }
            }
        };
        Thread threadD =new Thread("D线程") {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("D线程---" + i);
                }
            }
        };
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        threadC.start();
        threadC.join();
        threadD.start();

    }
}
