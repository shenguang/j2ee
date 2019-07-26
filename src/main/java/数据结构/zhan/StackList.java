package 数据结构.zhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @className StackList
 * @Description
 * @Date 2019/7/9 13:51
 * @Author shenguang
 * @Version 1.0
 **/
public class StackList<T> {
    private List<T> list = new ArrayList<>();
    private int top = -1;
    public T pop(){
        if(top>=0){
            T remove = list.remove(top);
            top--;
            return remove;
        }
        return null;
    }
    public T  peek(){
        if(top>=0){
            T remove = list.get(top);
            return remove;
        }
        return null;
    }

    public boolean add(T value){
        top++;
        return  list.add(value);
    }

    public boolean isEmpet(){
        if(top<0 || list.size()<=0){
            return true;
        }
        return false;
    }
    public void display(){
        list.stream().forEach(System.out::print);
    }

    public static void main(String[] args) {
        StackList<String> stringStack = new StackList<>();
        stringStack.add("我");
        stringStack.add("爱");
        stringStack.add("我");
        stringStack.add("的");
        stringStack.add("家");
        stringStack.add("我");
        stringStack.add("的");
        stringStack.add("天");
        stringStack.add("堂");
        while (!stringStack.isEmpet()){
            System.out.print(stringStack.pop());
        }

    }
}
