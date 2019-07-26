package 多线程.writeandread.test;

/**
 * @className MyShareData
 * @Description
 * @Date 2019/7/8 10:32
 * @Author shenguang
 * @Version 1.0
 **/
public class MyShareData {
    private final char[] buffer;

    private final  MyReadWriteLock lock = new MyReadWriteLock();

    public MyShareData(int  size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            this.buffer[i] = '*';
        }
    }
    public char[] read(){
        try {
            lock.readLock();
            return doRead();
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            lock.unReadLock();
        }
        return null;
    }

    private char[] doRead() {
        return buffer;
    }

}

