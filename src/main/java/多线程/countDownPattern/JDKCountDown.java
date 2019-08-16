package 多线程.countDownPattern;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @className JDK
 * @Description
 * @Date 2019/8/16 13:44
 * @Author shenguang
 * @Version 1.0
 **/
public class JDKCountDown {
    private static final Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException {
        //frist

        CountDownLatch latch = new CountDownLatch(3);
        IntStream.range(0,3).forEach(i->{
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName() + " is working.");
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                },i+"").start();
        });
        latch.await();

        //second
        System.out.println("多线程任务全部结束,准备第二阶段任务");
        System.out.println("............");
        System.out.println("FINISH");
    }
}
