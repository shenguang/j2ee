package 多线程.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Test {

    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(5);
//
//        for(int i = 1 ;i<=10 ;i++){
//            new Thread(new MyRunnableCountDownLatch(countDownLatch)).start();
//        }
//        countDownLatch.await();
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i <= 10; i++) {
            new Thread(new MyRunnableSem(semaphore,i)).start();
        }
        System.out.println("执行完毕");


    }
}