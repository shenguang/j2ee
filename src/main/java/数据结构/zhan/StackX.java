package 数据结构.zhan;

/**
 * @Auther: shenguang
 * @Date: 2018/10/31 13:37
 * @Description:基于数组的栈  先进后出
 */
public class StackX {
	public int top;
	public long[] array;
	public int maxSize;


	public StackX(int s) {
		this.maxSize = s;
		this.array = new long[maxSize];
		this.top = -1;
	}

	public void push(long j) {
		array[++top] = j;
	}

	public long pop() {
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
