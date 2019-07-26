package 多线程.guardedsupension.test;

import java.util.LinkedList;

/**
 * @className MyRequestQueue
 * @Description
 * @Date 2019/7/8 16:38
 * @Author shenguang
 * @Version 1.0
 **/
public class MyRequestQueue {
     private LinkedList<MyRequest> queue = new LinkedList<>();
     MyRequest getRequest() throws Exception {
         synchronized (queue){

             while (queue.size()<=0){
                 queue.wait();
             }
             return queue.removeFirst();
         }
     }

     void putRequest(MyRequest request){
         synchronized (queue){
             queue.addLast(request);
             queue.notifyAll();
         }
     }

}
