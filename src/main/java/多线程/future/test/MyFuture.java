package 多线程.future.test;

public interface MyFuture<T> {
    T get() throws Exception;
}
