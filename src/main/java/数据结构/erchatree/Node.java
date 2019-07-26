package 数据结构.erchatree;

/**
 * @Auther: shenguang
 * @Date: 2018/12/25 14:22
 * @Description: 二叉树节点
 */
public class Node {
	int iData;//关键数据，作为比较
	double dData;
	Node leftNode;
	Node rightNode;

	public double getdData() {
		return dData;
	}

	public void setdData(double dData) {
		this.dData = dData;
	}

	public int getiData() {
		return iData;
	}

	public void setiData(int iData) {
		this.iData = iData;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public void display(){
		System.out.println("====>:iData="+iData+",dData="+dData);
	}
}
