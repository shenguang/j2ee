package 递归;

/**
 * @Auther: shenguang
 * @Date: 2018/12/17 10:29
 * @Description:
 */
public class DeiGuiBinarySearch {
	public int arr[] = {12, 22, 34, 45, 67, 123, 345};

	public Integer find(int traget, Integer left, Integer right) {
		if (left > right) {
			return -1;
		}
		Integer mid = (left + right) >> 1;
		if (arr[mid] == traget) {
			return mid;
		}
		if (arr[mid] > arr[right]) {
			return find(traget, left, mid-1);
		} else {
			return find(traget, mid+1, right);
		}
	}

	public static void main(String[] args) {
		DeiGuiBinarySearch deiGuiBinarySearch = new DeiGuiBinarySearch();
		Integer integer = deiGuiBinarySearch.find(345, 0, deiGuiBinarySearch.arr.length - 1);
		System.out.println(integer);
//		Integer integer = new Integer(345);
//		Integer i = 345;
//		Integer b = 345;
//		System.out.println((integer ==i));
//		Integer a = new Integer(200);
//		Integer b = new Integer(200);
//		Integer c = 200;
//		Integer e = 200;
//		System.out.println("两个用int赋值的Integer    ==判断(c == e)" + (c == e));//超过128
//		int d = 200;
//
//		System.out.println("两个new出来的对象    ==判断(a == b)" + (a == b));
//		System.out.println("两个new出来的对象    equal判断a.equals(b)" + a.equals(b));
//		System.out.println("new出的对象和用int赋值的Integer   ==判断(a == c)" + (a == c));
//		System.out.println("new出的对象和用int赋值的Integer   equal判断(a.equals(c))" + (a.equals(c)));
//
//		System.out.println("两个用int赋值的Integer    equal判断(c.equals(e))" + (c.equals(e)));
//		System.out.println("基本类型和new出的对象   ==判断(d == a)" + (d == a));
//		System.out.println("基本类型和new出的对象   equal判断" + (a.equals(d)));
//		System.out.println("基本类型和自动装箱的对象   ==判断" + (d == c));
//		System.out.println("基本类型和自动装箱的对象   equal判断" + (c.equals(d)));

	}
}
