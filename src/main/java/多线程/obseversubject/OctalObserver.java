package 多线程.obseversubject;

/**
 * @className OctalObserver
 * @Description
 * @Date 2019/7/3 14:24
 * @Author shenguang
 * @Version 1.0
 **/
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal Observer:"+Integer.toOctalString(subject.getStatus()));
    }
}
