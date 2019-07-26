package 多线程.threadGroup;

/**
 * @className ThreadGroupCreate
 * @Description
 * @Date 2019/6/13 13:49
 * @Author shenguang
 * @Version 1.0
 **/
public class ThreadGroupCreate {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("TG1");
        Thread thread  = new Thread(threadGroup,"t1"){
            @Override
            public void run() {
                System.out.println(getThreadGroup().getName());
                System.out.println(getThreadGroup().getParent());
                System.out.println(getThreadGroup().getParent().activeCount());
            }
        };
        thread.start();
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup,"TG2");
        System.out.println("threadGroup2's parent :"+threadGroup2.getParent());
    }

}
