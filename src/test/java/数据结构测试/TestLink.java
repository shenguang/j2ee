package 数据结构测试;

import org.junit.Test;
import 数据结构.lianbiao.LinkList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: shenguang
 * @Date: 2018/10/25 19:08
 * @Description:
 */
public class TestLink {
	@Test
	public void main(){
		LinkList linkList = new LinkList();

		linkList.addFrist("root","123456");
		linkList.addFrist("xiaoming","xiaoming");
		linkList.addFrist("xiaocao","xiaocao");

		linkList.displayList();
		linkList.delete("xiaoming");
		linkList.displayList();
	}
	//	String str = "{你好  你好 你   好 \n \r ";
//	String s = str.replaceAll("\\s*", "");//可以替换大部分空白字符， 不限于空格 ；
//		s.replace()
//				System.out.println(s);
	@Test
	public void updateStateByEmrID() {

		String str = "{你,好  你/好  你 你\\好! ￥  ()（）";
		String regEx = "[`~@#$%^&*\\-+=':;,\\[\\].<>/?￥%…（）_+|【】‘”“’\\s*]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		System.out.println(m.replaceAll(""));
	}
}
