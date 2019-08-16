package 多线程.waitnotify.exProducceAndCosumer;

import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @className ClientTest
 * @Description
 * @Date 2019/8/16 10:37
 * @Author shenguang
 * @Version 1.0
 **/
public class ClientTest {
    public static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws  Exception{
        MessageQueue queue = MessageQueue.getMessageQueueInstance();

        IntStream.range(0,3).forEach(i->{
            new Thread("THREAD-PRODUCE-"+i){
                @Override
                public void run() {
                    try {
                        Message message = new Message("CONTENT : " + "this is a message for " + i,Thread.currentThread().getName());

                        queue.put(message);

                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        });
        System.out.println("===================");
        IntStream.range(0,2).forEach(i->{
            new Thread("THREAD-CONSUMER-"+i){
                @Override
                public void run() {

                    try {
                        Message take = queue.take();
                        System.out.println("===="+Thread.currentThread().getName() +  "    "+take);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        });



    }
}
