package 数据结构.duilie;

/**
 * @Auther: shenguang
 * @Date: 2018/10/31 17:50
 * @Description: 队列==》先进先出
 */
public class Queue {
	//队列的在前元素的下标（队头）
	private int fount ;
	//队列的所有元素集合
	private char[] chars ;
	//队尾
	private int rear ;
	//队列的里的元素多少
	private int aIntems;

	private int maxSize ;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.chars = new char[maxSize];
		fount = 0;
		rear = -1;
		aIntems = 0;
	}
	//前提是队列未满的情况下
	public void insert(char in){
		if(isFull()){
			return ;
		}
		if (rear==(maxSize-1)){
			rear=-1;
		}
		chars[++rear]=in;
		aIntems++;
	}
	//先进先出
	public char remove(){
		char temp = chars[fount++];
		if(fount==maxSize){
			fount=0;
		}
		aIntems--;
		return temp;
	}
	//查看再队列最前的元素
	public char peekFount(){
		return chars[fount];
	}

	public boolean isEmpty(){
		return aIntems==0;
	}

	public boolean isFull(){
		return aIntems==maxSize;
	}
	public int size(){
		return aIntems;
	}

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.insert('h');
		queue.insert('e');
		queue.insert('l');
		queue.insert('l');
		queue.insert('o');
		System.out.println(queue.peekFount());

	}
}
