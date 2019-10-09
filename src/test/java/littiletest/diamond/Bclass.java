package littiletest.diamond;

/**
 * @className Bclass
 * @Description
 * @Date 2019/8/19 10:19
 * @Author shenguang
 * @Version 1.0
 **/
public class Bclass extends Aclass{
    @Override
    public void foo() {
        super.foo();
    }
    //无法重写父类的静态方法，但是可以写一个方法名称和父类一样的静态方法，称作方法隐藏
    public static void foo2(){};
}
