package 多线程.obseversubject;

/**
 * @className 观察者设计模式
 * @Description
 * @Date 2019/7/3 13:50
 * @Author shenguang
 * @Version 1.0
 **/
public abstract class Observer {
    public Subject subject;
    public Observer(Subject subject){
        this.subject = subject;
        subject.attach(this);

    }
    public abstract void update();
}
