package 数据结构.zhan;

/**
 * @Auther: shenguang
 * @Date: 2018/10/31 13:37
 * @Description:基于数组的栈
 */
public class StackXI {
	public int top;
	public char[] array;
	public int maxSize;


	public StackXI(int s) {
		this.maxSize = s;
		this.array = new char[maxSize];
		this.top = -1;
	}

	public void push(char j) {
		array[++top] = j;
	}

	public char pop() {
		return array[top--];
	}

	public long peek() {
		return array[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}
}
