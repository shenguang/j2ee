package 多线程.obseversubject;

import java.util.ArrayList;
import java.util.List;

/**
 * @className Subject
 * @Description
 * @Date 2019/7/3 13:50
 * @Author shenguang
 * @Version 1.0
 **/
public class Subject {
    List<Observer> observers = new ArrayList<>();
    private int status;

    public int getStatus() {
        return status;
    }
    public void attach(Observer observer){
        observers.add(observer);
    }

    public void setStatus(int status){
        if(this.status == status){
            return;
        }
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        observers.stream().forEach(Observer::update);
    }

    public static void main(String[] args) {
        Subject subject   = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        subject.setStatus(8);
        System.out.println("================");
        subject.setStatus(12);

    }
}
