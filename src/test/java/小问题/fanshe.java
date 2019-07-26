package 小问题;

import java.lang.reflect.Method;

/**
 * 因为在反射中基本类型的 class 和其对应包装类的 class 是不同的,
 * 基本类型参数 int 是无法使用包装类型 Integer 来获得的
 */
public class fanshe {
    public void age(int age) {
        System.out.println("int age="+age);
    }

    public void age(Integer age) {
        System.out.println("Integer age="+age);
    }

    public static void main(String[] args) throws Exception {
        fanshe obj = new fanshe();
        Method m1 = obj.getClass().getMethod("age", int.class);
//        m1.invoke(obj, new Integer(27)); //1
//        m1.invoke(obj, 28); //2
        Method m2 = obj.getClass().getMethod("age", Integer.class);
        m2.invoke(obj, new Integer(27)); //3
        m2.invoke(obj, 28); //4
    }
}