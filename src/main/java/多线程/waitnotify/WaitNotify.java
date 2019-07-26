package 多线程.waitnotify;

import java.util.stream.Stream;

/**
 * @className WaitNotify
 * @Description:生产-消费模式
 * @Date 2019/6/12 15:51
 * @Author shenguang
 * @Version 1.0
 **/
public class WaitNotify {
    public int i = 0;
    public static Object LOCK = new Object();
    public volatile boolean isProduce = false;
    public void produce() throws InterruptedException {
        synchronized (LOCK){
            while (isProduce){
                LOCK.wait();
            }
            i++;
            System.out.println("produce--->"+i);

            LOCK.notifyAll();
            isProduce=true;
        }
    }
    public void consum() throws InterruptedException {
        synchronized (LOCK){
            while (!isProduce){
                LOCK.wait();
            }
            System.out.println("consum--->"+i);

            LOCK.notifyAll();
            isProduce=false;
        }
    }

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();
        //TODO：看看Stream用法
        Stream.of("p1","p2").forEach(n ->
                new Thread(n){
                    @Override
                    public void run(){
                        while (true){
                            try {
                                waitNotify.produce();
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }.start()
        );
        Stream.of("c1","c2").forEach(n ->
                new Thread(n){
                    @Override
                    public void run(){
                        while (true){
                            try {
                                waitNotify.consum();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }.start()
        );
    }
}
