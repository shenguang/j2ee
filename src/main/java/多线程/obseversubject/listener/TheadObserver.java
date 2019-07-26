package 多线程.obseversubject.listener;

import 多线程.obseversubject.listener.RunnableSubject;

public interface TheadObserver {
    void onEvent(RunnableSubject.RunnableEvent event);
}
