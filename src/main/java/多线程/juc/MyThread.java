package 多线程.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread{
    CountDownLatch countDownLatch =null;

    Semaphore semaphore = null;

    CyclicBarrier cyclicBarrier =null;
    int i ;

    public MyThread(CountDownLatch countDownLatch,int i){
        this.countDownLatch = countDownLatch;
        this.i = i;
    }

    public MyThread(Semaphore semaphore,int i){
        this.semaphore = semaphore;
        this.i = i;
    }

    public MyThread(CyclicBarrier cyclicBarrier,int i){
        this.cyclicBarrier = cyclicBarrier;
        this.i = i;
    }

    @Override
    public void run() {
        if(this.semaphore != null){
            System.out.println("Mysemaphore----out----"+i);
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(this.countDownLatch != null){
            System.out.println("MyCountDownLatch----out----"+i);
            countDownLatch.countDown();
        }
//        if(this.cyclicBarrier != null){
//            System.out.println("MycyclicBarrier----out----"+i);
//            cyclicBarrier.
//        }
    }
}