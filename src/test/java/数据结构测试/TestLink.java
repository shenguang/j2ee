package 数据结构测试;

import org.junit.Test;
import 数据结构.lianbiao.LinkList;

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
}
