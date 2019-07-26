package 数据结构.hashbiao;

/**
 * @Auther: shenguang
 * @Date: 2018/11/22 15:15
 * @Description:使用链表方法解决hash冲突的问题
 */
public class HashChain {
}

class SortList{
	private LinkNode first;

	public SortList() {
		this.first = null;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void insert(LinkNode node){
		int key =node.getKey();
		if(isEmpty()){
			first=node;
			return;
		}
		node.setNext(first);
		first=node;
	}
	public void display(){
		LinkNode curr = first;
		while (null != curr){
			curr.displayLink();
			curr=curr.getNext();
		}
	}
	public LinkNode find(int key){
		if(isEmpty()){
			return null;
		}
		LinkNode curr = first;
		while (null != curr){
			if(curr.getKey()==key){
				return curr;
			}
			curr = curr.getNext();
		}
		return null;
	}
	public void delete(int key){
		if(isEmpty()){
			return;
		}
		LinkNode pre = first;
		LinkNode curr = first;
		while (key!=curr.getKey()){
			if (null == curr.getNext()) {
				return;
			}
			if(curr.getKey()!=key){
				pre=curr;
				curr = curr.getNext();
			}
		}
		if(curr==first){
			first = first.getNext();
		}else{
			pre.setNext(curr.getNext()) ;
		}

	}
	public static void main(String[] args) {
		SortList sortList = new SortList();
		LinkNode node1 = new LinkNode(1);
		LinkNode node2 = new LinkNode(2);
		LinkNode node3 = new LinkNode(3);

		sortList.insert(node1);
		sortList.insert(node2);
		sortList.insert(node3);


		sortList.display();

		sortList.delete(2);

		sortList.display();


	}
}
/**
 * 节点类
 */
class LinkNode{
	private int iDate;
	private LinkNode next;

	public LinkNode(int iDate) {
		this.iDate = iDate;
	}

	public int getKey() {
		return iDate;
	}

	public void setkey(int iDate) {
		this.iDate = iDate;
	}

	public LinkNode getNext() {
		return next;
	}

	public void setNext(LinkNode next) {
		this.next = next;
	}

	public void displayLink() {
		String info = "LinkNode{" +
		              "iDate=" + iDate +
		              '}';
		System.out.println(info);
	}

	@Override
	public String toString() {
		return "LinkNode{" +
		       "iDate=" + iDate +
		       '}';
	}
}