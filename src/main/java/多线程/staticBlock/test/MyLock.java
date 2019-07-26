package 多线程.staticBlock.test;

/**
 * @className MyLock
 * @Description
 * @Date 2019/7/5 13:24
 * @Author shenguang
 * @Version 1.0
 **/
public class MyLock {
    int i = 1;
    public synchronized void run(){
        System.out.println(Thread.currentThread().getName()+"  "+(i++));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyLock lock = new MyLock();
        for(int i = 10 ;i<100;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.run();
                }
            },"Thread-name : "+i);
            thread.start();
        }
    }
}
