package 多线程.writeandread.test;

/**
 * @className MyReadWriteLock
 * @Description
 * @Date 2019/7/8 9:52
 * @Author shenguang
 * @Version 1.0
 **/
public class MyReadWriteLock {
    private int readingReaders = 0;
    private int waitingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;

    //读锁：
    public synchronized void readLock() throws Exception {
        //等待读加一
        waitingReaders++;
        //如果正在写或者等待写的存在，一直等到写结束再读
        while (writingWriters > 0 || waitingWriters > 0) {
            this.wait();
        }
        //正在读加一
        readingReaders++;

        //等待读减一
        waitingReaders--;
    }

    //解读锁
    public synchronized void unReadLock() {
        readingReaders--;
        this.notifyAll();
    }

//    写锁
    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;

        while (readingReaders>0||waitingWriters>0){
            this.wait();
        }
        writingWriters++;

        waitingWriters--;

    }

    private synchronized void unWriteLock(){
        writingWriters--;

        this.notifyAll();

    }

}
