package 多线程.juc;

import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask();
        FutureTask<String> futureTask = new FutureTask<>(myTask);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(5,5,1000L,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        Future<String> submit = threadPoolExecutor.submit(myTask);
        System.out.println(submit.get());
        threadPoolExecutor.shutdown();

        for(;;){
            Thread.sleep(Long.parseLong("1000"));
            System.out.println("提示--主线程已经休息一秒");
        }
    }

}
class MyTask implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "执行callable方法-----";
    }
}