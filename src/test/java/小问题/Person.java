package 小问题;

/**
 * @className Person
 * @Description
 * @Date 2019/7/18 10:44
 * @Author shenguang
 * @Version 1.0
 **/
public class Person {
    public int age = 20;
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
