package 多线程.guardedsupension.test;

import java.util.Random;

/**
 * @className Client
 * @Description
 * @Date 2019/7/8 16:50
 * @Author shenguang
 * @Version 1.0
 **/
public class Client extends Thread{
    private MyRequestQueue myRequestQueue;
    private volatile boolean close = false;

    public Client(MyRequestQueue myRequestQueue) {
        this.myRequestQueue = myRequestQueue;
    }

    @Override
    public void run() {
        synchronized (myRequestQueue){
            while (!close){
                try {
                    MyRequest request = myRequestQueue.getRequest();
                    if(null == request){
                        continue;
                    }
                    holdOn();
                    System.out.println(request.getValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void holdOn(){
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        this.close = true;
    }
}
