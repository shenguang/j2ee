package 多线程.MyThreadPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @className SimpleThreadPool
 * @Description:自己写得线程池
 * @Date 2019/6/17 16:02
 * @Author shenguang
 * @Version 1.0
 **/
public class SimpleThreadPool extends Thread {
    private int size;
    //默认线程池的线程数量（核心线程数）
    private final static int DEFAULT_SIZE = 5;

    //任务队列数
    private final int queueSize;

    //默认任务队列数
    private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static List<WorkTask> THREAD_QUEUE = new ArrayList<>();

    private volatile boolean isDistory = false;
    //拒绝策列
    private final DiscardPolicy discardPolicy;

    //
    private int min;
    //
    private int max;
    //
    private int active;

    public final static DiscardPolicy DEFAULT_DISCARD_POLICY = () -> {
        throw new DiscardException("Discard This Task.");
    };

    public SimpleThreadPool() {
        this(DEFAULT_SIZE, 10, 20, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISCARD_POLICY);
    }

    public SimpleThreadPool(int min, int active, int max, int queueSize, DiscardPolicy discardPolicy) {
        this.size = min;
        this.min=min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
        this.start();
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean isDistory() {
        return isDistory;
    }

    //构建
    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
    }

    @Override
    public void run() {
        while (!isDistory) {
            System.out.printf("Pool#Min:%d,Active:%d,Max:%d,Current:%d,QueueSize:%d,THREAD_QUEUE:%d\n",
                    this.min, this.active, this.max, this.size, TASK_QUEUE.size(),THREAD_QUEUE.size());
            try {
                Thread.sleep(5000);
                int taskSize = TASK_QUEUE.size();
                if(taskSize > this.active && size<this.active && taskSize<max){
                    for (int i = size; i < max; i++) {
                        createWorkTask();
                    }
                    System.out.println("The pool incremented to active.");
                    size = active;
                }

                if(taskSize > this.max && size<this.max){
                    for (int i = size; i < max; i++) {
                        createWorkTask();
                    }
                    System.out.println("The pool incremented to max.");
                    size = max;
                }
                //线程回收
                synchronized (THREAD_QUEUE) {
                    if (TASK_QUEUE.isEmpty() && size > active) {
                        System.out.println("=========Reduce========");
                        int releaseSize = size - active;
                        for (Iterator<WorkTask> it = THREAD_QUEUE.iterator(); it.hasNext(); ) {
                            if (releaseSize <= 0)
                                break;

                            WorkTask task = it.next();
                            task.close();
                            task.interrupt();
                            it.remove();
                            releaseSize--;
                        }
                        size = active;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void submit(Runnable runnable) {
        if (isDistory)
            throw new IllegalStateException("The thread pool already destroy and not allow submit task.");
        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() >= queueSize) {
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private void createWorkTask() {
        WorkTask task = new WorkTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }

    private enum TaskState {
        FREE, RUNNING, BLOCK, DEAD
    }

    //拒绝策略
    public interface DiscardPolicy {

        void discard() throws DiscardException;
    }

    public static class DiscardException extends RuntimeException {

        public DiscardException(String message) {
            super(message);
        }
    }

    public void shutDown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty())
            Thread.sleep(50);

        synchronized (THREAD_QUEUE) {

            int initValue = THREAD_QUEUE.size();
            while (initValue > 0) {
                for (WorkTask task : THREAD_QUEUE) {
                    if (task.getTaskState() == TaskState.BLOCK) {
                        task.interrupt();
                        task.close();
                        initValue--;
                    } else {
                        Thread.sleep(50);
                    }
                }
            }
        }
        this.isDistory = true;
        System.out.println("The thread pool disposed.");
    }

    private static class WorkTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public WorkTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        @Override
        public void run() {
            //OUTER   TODO：看看用法
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                //取任务
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCK;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("The runnable is serviced by " + " group " + Thread.currentThread().getThreadGroup() + " name :" + Thread.currentThread().getName() + " start .");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 100; i++) {
            simpleThreadPool.submit(runnable);
        }
        Thread.sleep(5000);
        simpleThreadPool.shutDown();
//        simpleThreadPool.submit(runnable);
    }

}
