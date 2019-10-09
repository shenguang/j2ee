package 设计模式.建造者模式;

/**
 * @className Student
 * @Description
 * @Date 2019/8/22 9:04
 * @Author shenguang
 * @Version 1.0
 **/
public class Student {
    private String name ;
    private int age;
    private int gander;

    public Student(String name, int age, int gander) {
        this.name = name;
        this.age = age;
        this.gander = gander;
    }

    public static StudentBuilder builder(){
        return  new StudentBuilder();
    }

    public   static class StudentBuilder{
        private String name ="";
        private int age = 0;
        private int gander =0;

        public StudentBuilder name(String name){
            this.name=name;
            return this;
        }
        public StudentBuilder age(int  age){
            this.age=age;
            return this;
        }
        public StudentBuilder gander(int  gander){
            this.gander=gander;
            return this;
        }

        public Student builder(){
            return new Student(this.name,this.age,this.gander);
        }

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
