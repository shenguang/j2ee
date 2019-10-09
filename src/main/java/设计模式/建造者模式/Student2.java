package 设计模式.建造者模式;

/**
 * @className Student
 * @Description
 * @Date 2019/8/22 9:04
 * @Author shenguang
 * @Version 1.0
 **/
public class Student2 {
    private String name ;
    private int age;
    private int gander;

    public Student2() {
    }

    public Student2 name(String name){
        this.name=name;
        return this;
    }
    public Student2 age(int age){
        this.age=age;
        return this;
    }
    public Student2 gander(int gander){
        this.gander=gander;
        return this;
    }
    public static   Student2 builder(){
        return new Student2();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gander=" + gander +
                '}';
    }
}
