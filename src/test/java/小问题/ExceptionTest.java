package 小问题;

/**
 * @Auther: shenguang
 *局部变量
 * @Date: 2019/1/17 16:52
 * @Description:
 */
public class ExceptionTest {
	public static int test (int b){
		int a  =0;
		try {
			a = 5/b;
		} catch (Exception e) {
			int test = test(5);
			System.out.println(test);
		}
		return a;
	}

	public static int testa (int b){
		int a  =0;
		try {
			int x = a/b;

		} catch (Exception e) {
			a=100;
			System.out.println("catch : " +a);
			return a;
		}
		return a;
	}

	public static void main(String[] args) {
//		System.out.println(test(0));
		System.out.println(testa(0));
	}
}
