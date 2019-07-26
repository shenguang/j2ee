package 数据结构.erchatree;

/**
 * @Auther: shenguang
 * @Date: 2018/12/25 14:22
 * @Description: 树
 */
public class Tree {
	private Node root;
	//复杂度：O(logN)
	public Node find(int key){
		Node cur = root;
		while (null!=cur){
			int iData = cur.getiData();
			if(iData == key){
				return cur;
			}
			if(iData>key){
				cur=cur.getRightNode();
			}
			if(iData<key){
				cur=cur.getLeftNode();
			}
		}
		return cur;
	}
	public void insert(int id,double dd){
		Node node = new Node();
		node.setiData(id);
		node.setdData(dd);
		Node cur = root;
		if(null==cur){
			root=node;
			return;
		}
		while (null!=cur){
			int idata = cur.getiData();
			if(idata==id){
				cur.setdData(dd);
				return;
			}
			Node leftNode = cur.getLeftNode();
			if(idata > id){
				if(leftNode == null){
					cur.setLeftNode(node);
					return;
				}else{
					cur= leftNode;
				}
			}
			if(idata<id){
				Node rightNode = cur.getRightNode();
				if(rightNode == null){
					cur.setRightNode(node);
					return;
				}else{
					cur= rightNode;
				}
			}
		}

	}
	//中序遍历 先左再中再右   什么类型的遍历是更具访问根节点的先后
	public void inOrder(Node node){
		if(null!=node){
			inOrder(node.leftNode);
			node.display();
			inOrder(node.rightNode);
		}
	}

	public void delete(int key){
		//删除key：
		//1：没有子节点
		//2：有一个子节点
		//3：有两个子节点
	}
}
