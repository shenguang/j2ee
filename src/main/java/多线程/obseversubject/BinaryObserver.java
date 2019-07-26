package 多线程.obseversubject;

import 多线程.obseversubject.Observer;
import 多线程.obseversubject.Subject;

/**
 * @className OctalObserver
 * @Description
 * @Date 2019/7/3 14:24
 * @Author shenguang
 * @Version 1.0
 **/
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary Observer:"+Integer.toBinaryString(subject.getStatus()));
    }
}
