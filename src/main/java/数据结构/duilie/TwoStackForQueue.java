package 数据结构.duilie;

import 数据结构.zhan.StackList;

/**
 * @className TwoStackForQueue
 * @Description
 * @Date 2019/7/9 14:49
 * @Author shenguang
 * @Version 1.0
 **/
public class TwoStackForQueue<T> {
    private StackList<T> stackList1 = new StackList<>();
    private StackList<T> stackList2 = new StackList<>();
    public T pop(){
        change(stackList1,stackList2);
        T pop = stackList2.pop();
        change(stackList2,stackList1);
        return pop;
    }
    public boolean add(T value){
        return  stackList1.add(value);
    }
    public void display(){
        stackList1.display();
    }
    public boolean isEmpty(){
        return stackList1.isEmpet();
    }



    private void change(StackList<T> stackList1,StackList<T> stackList2){
        while (!stackList1.isEmpet()){
            T pop = stackList1.pop();
            stackList2.add(pop);
        }
    }

    public static void main(String[] args) {
        TwoStackForQueue<String> tTwoStackForQueue = new TwoStackForQueue<>();
        tTwoStackForQueue.add("我");
        tTwoStackForQueue.add("爱");
        tTwoStackForQueue.add("我");
        tTwoStackForQueue.add("的");
        tTwoStackForQueue.add("家");
        tTwoStackForQueue.add(",");
        tTwoStackForQueue.add("我");
        tTwoStackForQueue.add("的");
        tTwoStackForQueue.add("天");
        tTwoStackForQueue.add("堂");
        tTwoStackForQueue.add(".");

        while (!tTwoStackForQueue.isEmpty()){
            tTwoStackForQueue.display();
            System.out.println();
            System.out.print(tTwoStackForQueue.pop());
            System.out.println("\n----------");
        }

    }


}
