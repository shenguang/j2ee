package 多线程.future.test;

/**
 * @className MyAsynFuture
 * @Description
 * @Date 2019/7/8 13:30
 * @Author shenguang
 * @Version 1.0
 **/
class MyAsynFuture<T> implements MyFuture<T> {

    private volatile boolean done = false;

    private T result;

    public void done(T result){
        synchronized (this){
            this.result = result;
            done = true;
            this.notifyAll();
        }
    }
    @Override
    public T get() throws Exception {
        synchronized (this){
            while (!done){
                this.wait();
            }
        }
        return result;
    }
}
