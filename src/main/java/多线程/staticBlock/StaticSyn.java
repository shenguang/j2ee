package 多线程.staticBlock;

public class StaticSyn {
    public synchronized static void testLock1() throws InterruptedException {
        System.out.println("testLock1---"+Thread.currentThread().getName());
        Thread.sleep(10000L);
    }
    public synchronized static void testLock2() throws InterruptedException {
        System.out.println("testLock2---"+Thread.currentThread().getName());
        Thread.sleep(10000L);
    }
    public void testLock3() throws InterruptedException {
        synchronized (StaticSyn.class){
            System.out.println("testLock3---"+Thread.currentThread().getName());
            Thread.sleep(10000L);
        }

    }
    public synchronized void testLock4() throws InterruptedException {
            System.out.println("testLock4---"+Thread.currentThread().getName());
            Thread.sleep(10000L);
    }
    public void testLock5(StaticSyn staticSyn) throws InterruptedException {
        synchronized (staticSyn){
            System.out.println("testLock5---"+Thread.currentThread().getName());
            Thread.sleep(10000L);
        }
    }
    public  void testLock6() throws InterruptedException {
        synchronized (this) {
            System.out.println("testLock6---" + Thread.currentThread().getName());
            Thread.sleep(10000L);
        }
    }

}
