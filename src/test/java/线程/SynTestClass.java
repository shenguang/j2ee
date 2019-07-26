package 线程;

/**
 * @Auther: shenguang
 * @Date: 2018/12/28 17:07
 * @Description:保证一个线程没有执行完毕时其他线程不能执行
 */
public class SynTestClass {
	public static synchronized void staticFunction(){
		int i = 5;
		while (i>0){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+i);
			i--;
		}
	}
	public synchronized void  usuFunction(){
		int i = 5;
		while (i>0){
			String threadName = Thread.currentThread().getName();
			System.out.println("usuFunction=>"+threadName+i);
			i--;
		}
	}
	public void fun(){
		synchronized (this){
			int i = 5;
			while (i>0){
				String threadName = Thread.currentThread().getName();
				System.out.println("fun==>"+threadName+i);
				i--;
			}
//可重入性
			usuFunction();
		}
	}
}
