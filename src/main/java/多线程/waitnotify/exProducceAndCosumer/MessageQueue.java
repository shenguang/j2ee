package 多线程.waitnotify.exProducceAndCosumer;

import java.util.LinkedList;

/**
 * @className MessageQueue
 * @Description
 * @Date 2019/8/16 10:14
 * @Author shenguang
 * @Version 1.0
 **/
public class MessageQueue {
    private  LinkedList<Message> messages ;
    private Integer limit;
    private  Object LOCK = new Object();
    private MessageQueue(){
        this.messages = new LinkedList<Message>();
        this.limit = 2;
    }
    private static class MessageQueueHolder{
        private final static MessageQueue messageQueue = new MessageQueue();
    }
    public static   MessageQueue getMessageQueueInstance(){
        return  MessageQueueHolder.messageQueue;
    }

    public void put(Message message) throws Exception {
        synchronized (LOCK){
            if(getQueueSize()>=limit){
                LOCK.wait();
            }
            messages.addLast(message);
        }
    }
    public Message take() throws Exception {
        synchronized (LOCK){
            if(messages.isEmpty()){
                LOCK.wait();
            }
            Message first = messages.removeFirst();
            LOCK.notifyAll();
            return first;
        }
    }
    public Integer getQueueSize(){
        synchronized (LOCK){
            return messages.size();
        }
    }

    public Integer getLimit() {
        return limit;
    }
}
