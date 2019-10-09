package 设计模式.建造者模式;

/**
 * @className TestBuilder
 * @Description
 * @Date 2019/8/22 9:10
 * @Author shenguang
 * @Version 1.0
 **/
public class TestBuilder {
    public static void main(String[] args) {
        Student student = Student.builder().age(1).gander(2).name("团团").builder();
        System.out.println(student);
        Student2 student2 =new Student2();
        student2.age(1).gander(2).name("圆圆");
        System.out.println(student2);
        Student2 student21 =Student2.builder().age(11).gander(1).name("康康");
        System.out.println(student21);


    }
}
