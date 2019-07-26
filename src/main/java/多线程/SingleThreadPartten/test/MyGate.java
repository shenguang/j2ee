package 多线程.SingleThreadPartten.test;

/**
 * @className MyGate
 * @Description:每次通过这个门时进行记录通过者的信息
 * @Date 2019/7/4 14:46
 * @Author shenguang
 * @Version 1.0
 **/
public class MyGate {
    Integer count =0;
    String name ;
    String from ;

     void  pass(String name ,String from){
         synchronized (this){
             count++;
             this.name = name;
             this.from = from;
             verify();
         }

    }
    private void verify() {
        if (this.name.charAt(0) == this.from.charAt(0)) {
            System.out.println("*******BROKEN********" +"this.name : "+this.name+" this.from :"+this.from);
        }
    }

}
