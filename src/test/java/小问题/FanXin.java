package 小问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shenguang
 * @Date: 2018/11/27 12:02
 * @Description:
 */
public class FanXin {
	public static void main(String[] args) {
		List<String> stringArrayList = new ArrayList<String>();
		List<Integer> integerArrayList = new ArrayList<Integer>();
		String abc = null;
		Class classStringArrayList = stringArrayList.getClass();
		Class classIntegerArrayList = integerArrayList.getClass();
		if (classStringArrayList.equals(classIntegerArrayList)) {
			System.out.println(classStringArrayList);
			System.out.println(classIntegerArrayList);
		}
	}
}
