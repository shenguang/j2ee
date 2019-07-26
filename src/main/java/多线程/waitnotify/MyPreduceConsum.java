package 多线程.waitnotify;

/**
 * @className MyPreduceConsum
 * @Description
 * @Date 2019/6/19 13:52
 * @Author shenguang
 * @Version 1.0
 **/
public class MyPreduceConsum {

    private volatile boolean ISPREDUCE=false;

    private Object LOCK = new Object();

    private int msg = 0;
    public void preduce(String name) throws Exception {
        synchronized (LOCK){
            while (ISPREDUCE){
                LOCK.wait();
            }
            msg++;
            ISPREDUCE=true;
            System.out.println(name+ " preduces a msg -->"+msg);
            Thread.sleep(1000);
            LOCK.notifyAll();
        }
    }

    public void consum(String name) throws InterruptedException {
        synchronized (LOCK){
            while (!ISPREDUCE){
                LOCK.wait();
            }
            System.out.println(name +" consums a msg -->"+msg);
            ISPREDUCE=false;
            LOCK.notifyAll();
        }
    }

    public static void main(String[] args) {
        MyPreduceConsum preduceConsum = new MyPreduceConsum();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        String name = Thread.currentThread().getName();
                        preduceConsum.preduce(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"preduce-1");
        thread.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        String name = Thread.currentThread().getName();
                        preduceConsum.preduce(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"preducer-2");
        thread2.start();


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        String name = Thread.currentThread().getName();
                        preduceConsum.consum(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"consumer-1");
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        String name = Thread.currentThread().getName();
                        preduceConsum.consum(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"consumer-2");
        thread4.start();


    }



}
