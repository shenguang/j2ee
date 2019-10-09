package littiletest.diamond;

/**
 * @className Bclass
 * @Description 如果此处进行多重继承，他不知到具体会去重载那个class的foo方法  所以不能多重继承
 * 那为什么c语言可以支持多继承：
 * @Date 2019/8/19 10:19
 * @Author shenguang
 * @Version 1.0
 **/
public class Dclass extends Bclass{
    @Override
    public void foo() {
        super.foo();
    }

}
