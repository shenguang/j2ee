package 多线程.juc;
import java.util.concurrent.Semaphore;

public class MyRunnableSem implements  Runnable{
    Semaphore semaphore =null;
    int  i = 0;
    public MyRunnableSem(Semaphore semaphore,int i){
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("semaphore----out-----"+i);
            Thread.sleep(100000);
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}