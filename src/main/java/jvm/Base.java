package jvm;

public class Base {
    public String name = "base" ;
    public  static String Sname = "Sbase" ;
    public Base(){
        callName();
    }
    public void callName(){
        System.out.println(name+"========"+Sname);
    }

    public static void main(String[] args) {
        Base b = new sub();
    }
}

class sub extends Base{
    public String name = "sub" ;
    public sub(){
        callName();
    }
    public void callName(){
        System.out.println(name);
        System.out.println(super.name+"========"+super.Sname);
        //初始化先会父类的构造方法，成员变量会提前于构造方法赋值



//输出结果：
//        null    先调用父类的构造方法，但是发现是子类  所以执行子类的callName方法，此时子类的还没有进行初始化  name还没有进行赋值
//        base========Sbase 父类的构造方法，执行完了，那么父类的成员变量已经赋值完毕
        //以上是父类的初始化


//接下来是子类的赋值
//        sub   成员变量会提前于构造方法赋值
//        base========Sbase 父类的成员变量已经赋值完毕
    }
}