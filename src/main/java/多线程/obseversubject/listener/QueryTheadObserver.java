package 多线程.obseversubject.listener;

import java.util.Arrays;
import java.util.List;

/**
 * @className QueryTheadObserver
 * @Description
 * @Date 2019/7/3 15:39
 * @Author shenguang
 * @Version 1.0
 **/
public class QueryTheadObserver implements TheadObserver {
    private final Object LOCK = new Object();
    public void queryThead(List<String> ids){
        ids.stream().forEach(id -> new Thread(new RunnableSubject(this) {
            @Override
            public void run() {
                try {
                    notifyListener(new RunnableEvent(STATUS.RUNNING,Thread.currentThread(),null));
                    System.out.println("query for the id " + id);
                    Thread.sleep(1000L);
                    notifyListener(new RunnableEvent(STATUS.DONE, Thread.currentThread(), null));
                }catch (Exception e){
                    notifyListener(new RunnableEvent(STATUS.ERROR, Thread.currentThread(), null));
                }
            }
        },id).start());
    }


    @Override
    public void onEvent(RunnableSubject.RunnableEvent event) {
        synchronized (LOCK) {
            System.out.println("The runnable [" + event.getThread().getName() + "] data changed and state is [" + event.getStatus() + "]");
            if (event.getCause() != null) {
                System.out.println("The runnable [" + event.getThread().getName() + "] process failed.");
                event.getCause().printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new QueryTheadObserver().queryThead(Arrays.asList("1","2"));
    }
}
