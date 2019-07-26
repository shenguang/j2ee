package 线程;

/**
 * @Auther: shenguang
 * @Date: 2018/12/28 17:13
 * @Description:
 */
public class App {
	public static void main(String[] args) {

		SynTestClass synTestClass = new SynTestClass();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					synTestClass.fun();
				}
			}, "thread name-0" + i + "：");
			thread.start();
		}
//		SynTestClass synTestClass1 = new SynTestClass();
//		for (int i = 0; i < 5; i++) {
//			Thread thread = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					synTestClass1.fun();
//				}
//			}, "thread name-1" + i + "：");
//			thread.start();
//		}

	}
}
