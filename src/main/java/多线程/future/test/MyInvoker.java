package 多线程.future.test;

/**
 * @className MyInvoker
 * @Description
 *
 * Future        ->代表的是未来的一个凭据
 * FutureTask    ->将你的调用逻辑进行了隔离
 * FutureService ->桥接 Future和 FutureTask
 * @Date 2019/7/8 13:35
 * @Author shenguang
 * @Version 1.0
 **/
public class MyInvoker {
    public static void main(String[] args) {
//        MyFutureService futureService = new MyFutureService();
//        //这个模式主要有futureService实现   submit提交任务，是将开启一个线程执行Task  主线程不干扰
//        MyFuture<String> submit = futureService.submitaa(() -> {
//            try {
//                Thread.sleep(10000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "FINISH";
//        });
        MyInvoker myInvoker = new MyInvoker();
        myInvoker.test2();

        System.out.println(" =========do other things ======== ");
    }
    void test2(){
        MyFutureService futureService = new MyFutureService();
        //这个模式主要有futureService实现   submit提交任务，是将开启一个线程执行Task  主线程不干扰
        MyFuture<String> submit = futureService.submit(() -> {
            try {
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },MyFutureService::test);

        System.out.println(" =========do other things ======== ");
    }
    void test(){
        MyFutureService futureService = new MyFutureService();
        //这个模式主要有futureService实现   submit提交任务，是将开启一个线程执行Task  主线程不干扰
        MyFuture<String> submit = futureService.submit(() -> {
            try {
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        });

        System.out.println(" =========do other things ======== ");

        try {

            //获取时  是通过不断轮询
            System.out.println(submit.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
