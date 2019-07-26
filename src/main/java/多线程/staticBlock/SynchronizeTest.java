package 多线程.staticBlock;
/* *
 * @Author shenguang
 * @Description //可重入锁，同类有ReentrantLock
 * @Date 13:59 2019/6/24
 * @Param
 * @return
 **/
public class SynchronizeTest implements Runnable{
    @Override
    public void run() {
        set();
    }

    public synchronized void set(){
        System.out.println("set方法");
        get();
    }

    public synchronized void get(){
        System.out.println("get方法");
    }
    
    public static void main(String[] args) {
        SynchronizeTest synchronizeTest = new SynchronizeTest();
        Thread t1 =  new Thread(synchronizeTest);
        t1.start();
    }
    
} 