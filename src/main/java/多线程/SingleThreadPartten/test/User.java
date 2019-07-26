package 多线程.SingleThreadPartten.test;


/**
 * @className User
 * @Description
 * @Date 2019/7/4 14:49
 * @Author shenguang
 * @Version 1.0
 **/
public class User extends Thread{
    public String name;
    public String from ;
    public MyGate myGate;
    public User(String name, String from, MyGate myGate) {
        this.name = name;
        this.from = from;
        this.myGate = myGate;
    }
    @Override
    public void run(){
        System.out.println("********BEGIN********");
        while (true){
            this.myGate.pass(name,from);
        }

    }

    public static void main(String[] args) {
        MyGate gate = new MyGate();
        User bj = new User("Baobao", "Beijing", gate);
        User sh = new User("ShangLao", "ShangHai", gate);
        User gz = new User("GuangLao", "GuangZhou", gate);

        bj.start();
        sh.start();
        gz.start();
    }
}
