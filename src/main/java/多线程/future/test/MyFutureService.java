package 多线程.future.test;

import java.util.function.Consumer;

/**
 * @className MyFutureService
 * @Description
 * @Date 2019/7/8 13:47
 * @Author shenguang
 * @Version 1.0
 **/
public class MyFutureService {
    public <T> MyFuture<T> submit(MyFutureTask<T> myFutureTask){
        MyAsynFuture<T> myAsynFuture = new MyAsynFuture<>();
        new Thread(()->{
            T res = myFutureTask.call();
            myAsynFuture.done(res);
        }).start();
        return myAsynFuture;
    }

    public <T> MyFuture<T> submit(final MyFutureTask<T> task, final Consumer<T> consumer) {
        MyAsynFuture<T> asynFuture = new MyAsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }

    public <T> MyFuture<T> submitaa(final MyFutureTask<T> task) {
        MyAsynFuture<T> asynFuture = new MyAsynFuture<>();
        new Thread(() -> {
            try {
                T result = task.call();
                asynFuture.done(result);
                System.out.println(asynFuture.get());
            } catch (Exception e) {
                e.printStackTrace();

            }
        }).start();
        return asynFuture;
    }


    public static void test(String str){
        System.out.println(str);
    }

}
