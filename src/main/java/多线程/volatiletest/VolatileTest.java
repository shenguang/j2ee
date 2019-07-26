package 多线程.volatiletest;

/* *
 * @Author shenguang
 * @Description //volatile : 作用保证线程可见性  防止指令重排序  但是不能保证原子性
 * @Date 10:28 2019/6/24
 * @Param
 * @return
 **/
public class VolatileTest {

    private static volatile int INIT_VALUE = 0;

    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("The value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
//                System.out.println(" INIT_VALUE = "+ INIT_VALUE +" localValue="+localValue);  sout  在多线程中注意：  会去同步主内存的数据
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "UPDATER").start();
    }
}