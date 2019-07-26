package 数据结构.duilie;

import java.util.ArrayList;
import java.util.List;

/**
 * @className QueueList
 * @Description
 * @Date 2019/7/9 14:13
 * @Author shenguang
 * @Version 1.0
 **/
public class QueueList<T> {
    private List<T> queue = new ArrayList<>();
    private int top = -1;
    public T peek(){
        if(!isEmpty()){
            return queue.get(top);
        }
        return null;
    }

    public void add(T v){
        top++;
        queue.add(0,v);
    }

    public T remove(){
        if(!isEmpty()){
            T remove = queue.remove(top);
            top--;
            return remove;
        }
        return null;

    }
    public boolean isEmpty(){
        if(top<0||queue.size()<=0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        QueueList<String> stringQueue = new QueueList<>();
        stringQueue.add("我");
        stringQueue.add("爱");
        stringQueue.add("我");
        stringQueue.add("的");
        stringQueue.add("家");
        stringQueue.add("我");
        stringQueue.add("的");
        stringQueue.add("天");
        stringQueue.add("堂");
        while (!stringQueue.isEmpty()){
            System.out.print(stringQueue.remove());
        }
    }
}
