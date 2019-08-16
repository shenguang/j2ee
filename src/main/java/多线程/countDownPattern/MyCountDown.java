package 多线程.countDownPattern;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @className MyCountDown
 * @Description  之前类是的处理使用join来处理
 * @Date 2019/8/16 13:59
 * @Author shenguang
 * @Version 1.0
 **/
public class MyCountDown {
    private int total ;
    private int count ;

    public MyCountDown(int total) {
        this.total = total;
    }

    public synchronized  void  down(){
        this.count++;
        this.notifyAll();
    }
    public synchronized void await(){
        if(this.total!=this.count){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        final Random random = new Random(System.currentTimeMillis());
        MyCountDown latch = new MyCountDown(3);
        IntStream.range(0,3).forEach(i->{
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " is working.");
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.down();
            },i+"").start();
        });

        latch.await();

        //second
        System.out.println("多线程任务全部结束,准备第二阶段任务");
        System.out.println("............");
        System.out.println("FINISH");
    }


}
