package 多线程.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyRunnableCountDownLatch  implements  Runnable{
    CountDownLatch countDownLatch =null;
    public MyRunnableCountDownLatch(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("MyRunnableCountDownLatch----out");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}