package 数据结构.erchatree;

/**
 * @Auther: shenguang
 * @Date: 2018/12/25 14:23
 * @Description: 树的测试类
 */
public class AppTree {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(10,12.1);
		tree.insert(1,12.2);
		tree.insert(11,12.3);
		tree.insert(2,12.4);
		tree.insert(12,12.5);
		tree.insert(3,12.6);
		tree.insert(13,12.7);
		tree.insert(4,12.8);
		tree.insert(14,12.9);
		tree.insert(5,13.1);
		tree.inOrder(tree.find(10));
	}
}
