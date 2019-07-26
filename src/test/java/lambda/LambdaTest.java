package lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

/**
 * @Auther: shenguang
 * @Date: 2018/12/11 14:54
 * @Description:
 */
public class LambdaTest {

	@Test
	public void mytest1(){
		func((y) -> System.out.println("hello world!"+y));
	}
	private void func(MyInterface myInterface){
		myInterface.test(8);
	}


	@Test
	public void mytest2(){
		Predicate<String> startsWithJ = (n) -> n.startsWith("D");
		Predicate<String> fourLetterLong = (n) -> n.length() >= 4;
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API",
		                              "Date and Time API");
//		features.stream().forEach(str -> System.out.println(str));
		features.stream().filter(startsWithJ.and(fourLetterLong)).forEach(n ->System.out.println(n));
		IntBinaryOperator intBinaryOperator = (int a, int b) -> a + b;
		int i = intBinaryOperator.applyAsInt(1, 2);
		System.out.println(i);
	}
	@Test
	public void mytest3(){
		MathOperation  add = ((a, b) -> a+b);//对接口的实现
		MathOperation  sub = ((a, b) -> a-b);
		MathOperation  dev = ((a, b) -> a*b);
		int operation = add.operation(1, 2);
		System.out.println(operation);
	}
	interface  MathOperation{
		int operation(int a ,int b );
	}

}
