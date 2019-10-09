package 多线程.atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className AtomicIntegerTest
 * @Description
 * @Date 2019/8/19 17:39
 * @Author shenguang
 * @Version 1.0
 **/
public class AtomicIntegerTest {
    /* *
     可见性
     顺序
     不能原子性
     **/

    private static volatile int value =0;
    //需要一个线程安全的set  不然会出现问题
    private static Set<Integer> set =Collections.synchronizedSet(new HashSet<Integer>());
//    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int x = 0;
                while (x<100){
                    int andIncrement = atomicInteger.getAndIncrement();
                    System.out.println(andIncrement);
//                    set.add(andIncrement);
                    x++;
                }

            }
        };

        Thread t2  = new Thread(){
            @Override
            public void run() {
                int x = 0;
                while (x<100){
                    int andIncrement = atomicInteger.getAndIncrement();
//                    set.add(andIncrement);
                    System.out.println(andIncrement);
                    x++;

                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        System.out.println(set.size());

    }
}
