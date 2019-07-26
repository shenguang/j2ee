package 多线程.future.test;

/**
 * @className MyFutureTask
 * @Description
 * @Date 2019/7/8 13:34
 * @Author shenguang
 * @Version 1.0
 **/
public interface MyFutureTask<T> {
    T call();
}
