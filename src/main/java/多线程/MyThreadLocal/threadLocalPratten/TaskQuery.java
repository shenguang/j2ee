package 多线程.MyThreadLocal.threadLocalPratten;

import java.util.Date;
import java.util.stream.IntStream;


/**
 * @className TaskQuery
 * @Description
 * @Date 2019/8/15 15:41
 * @Author shenguang
 * @Version 1.0
 **/
public class TaskQuery implements Runnable{
    @Override
    public void run() {
        ActionContext actionContext = ActionContext.getInstanceContext();
        Context context = actionContext.getContext();

        //访问数据库
        queryDbUser();

        //访问第三方
        queryThridApi();
        System.out.println(context);
    }

    private void queryThridApi() {
        try {
//            Thread.sleep(1000L);
            String idCard =Thread.currentThread().getName()+ "  "+ new Date().getTime();
            ActionContext.getInstanceContext().getContext().setCardId(idCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void queryDbUser() {
        try {
//            Thread.sleep(1000L);
            String name = "Alex " + Thread.currentThread().getName();
            ActionContext.getInstanceContext().getContext().setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(1,5).forEach(i->{
            new Thread(new TaskQuery()).start();
        });
    }
}
