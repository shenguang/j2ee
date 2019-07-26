package 多线程.guardedsupension.test;

import java.util.Random;

/**
 * @className ServerClient
 * @Description
 * @Date 2019/7/8 16:49
 * @Author shenguang
 * @Version 1.0
 **/
public class Server extends Thread{
    private MyRequestQueue myRequestQueue;
    private String value;

    public Server(MyRequestQueue myRequestQueue,String value){
        this.myRequestQueue = myRequestQueue;
        this.value = value;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10 ;i++){
            MyRequest myRequest = new MyRequest(value+" :: " +i);
            myRequestQueue.putRequest(myRequest);
            holdOn();
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
}
