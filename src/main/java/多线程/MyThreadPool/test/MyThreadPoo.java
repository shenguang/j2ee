package 多线程.MyThreadPool.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className MyThreadPoo
 * @Description
 * @Date 2019/6/20 16:51
 * @Author shenguang
 * @Version 1.0
 **/
public class MyThreadPoo {
    private int threadSize;
    private static List<TaskThread> threadQueue = new ArrayList<>();

    private int taskSize;
    private static LinkedList<Runnable> taskQueue = new LinkedList<>();

    private static volatile boolean isDistory = false;

    public MyThreadPoo(int threadSize, int taskSize) {
        this.threadSize = threadSize;
        this.taskSize = taskSize;
        init();
    }

    public void init() {
        for (int i = 0; i < threadSize; i++) {
            createTaskThread(i);
        }
    }

    public void createTaskThread(int i) {
        TaskThread taskThread = new TaskThread("创建--工作线程--" + i);
        taskThread.start();
        threadQueue.add(taskThread);
    }

    public void submit(Runnable runnable) {
        synchronized (taskQueue) {
            if (taskSize < taskQueue.size()) {
                System.out.println("==task queue is full==");
                return;
            }
            taskQueue.addLast(runnable);
            taskQueue.notifyAll();
        }
    }

    public void shutDown() throws InterruptedException {
        while (!taskQueue.isEmpty()) {
            Thread.sleep(50);
        }
        synchronized (threadQueue) {
            int initValue = threadQueue.size();
            while (initValue > 0) {
                for (TaskThread taskThread : threadQueue) {
                    if (taskThread.getThreadStatus() == ThreadStatus.BLOCK) {
                        taskThread.interrupt();
                        taskThread.close();
                        initValue--;
                    }
                }
            }
        }
        this.isDistory = true;
        System.out.println("The thread pool disposed.");
    }


    public enum ThreadStatus {
        FREE, RUNNING, BLOCK, DEAD,
    }


    public class TaskThread extends Thread {
        private ThreadStatus threadStatus = ThreadStatus.FREE;

        public TaskThread(String name) {
            super(name);
        }

        public ThreadStatus getThreadStatus() {
            return this.threadStatus;
        }

        @Override
        public void run() {
            while (this.threadStatus != ThreadStatus.DEAD) {
                Runnable runnable = null;
                synchronized (taskQueue) {
                    try {
                        while (taskQueue.isEmpty()) {
                            threadStatus = ThreadStatus.BLOCK;
                            taskQueue.wait();
                        }
                        runnable = taskQueue.removeFirst();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (null != runnable) {
                    runnable.run();
                    threadStatus = ThreadStatus.FREE;
                }
            }
        }

        public void close() {
            this.threadStatus = ThreadStatus.DEAD;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPoo myThreadPoo = new MyThreadPoo(5, 10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadName: " + Thread.currentThread().getName() + " start.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 6; i++) {
            myThreadPoo.submit(runnable);
        }
        myThreadPoo.shutDown();
    }


}
