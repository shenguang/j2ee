package 多线程.obseversubject.listener;

/**
 * @className RunnableSubject
 * @Description
 * @Date 2019/7/3 15:27
 * @Author shenguang
 * @Version 1.0
 **/
public abstract class RunnableSubject implements Runnable {
    public TheadObserver theadObserver;

    public RunnableSubject(TheadObserver theadObserver) {
        this.theadObserver = theadObserver;
    }
    public void notifyListener(RunnableEvent event){
        theadObserver.onEvent(event);
    };
    public  enum STATUS {
        RUNNING, ERROR, DONE
    }
    public static class RunnableEvent{
        private final STATUS status;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(STATUS status, Thread thread, Throwable cause) {
            this.status = status;
            this.thread = thread;
            this.cause = cause;
        }

        public STATUS getStatus() {
            return status;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }

}
