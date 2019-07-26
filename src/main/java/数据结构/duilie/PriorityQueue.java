package 数据结构.duilie;

/**
 * @Auther: shenguang
 * @Date: 2018/11/1 10:27
 * @Description:优先级
 */
public class PriorityQueue {
	private int nIntem;
	private int maxSize;
	private long[] array;

	public PriorityQueue(int maxSize){
		nIntem=0;
		this.maxSize = maxSize;
		this.array = new long[maxSize];
	}
	//这样就保证了优先级大的先出，
	public void insert(long in){
		int j;
		if(0==nIntem){
			array[nIntem++]=in;
		}else{
			//优先级一样的谁先进入谁先出，>=很关键
			for( j = nIntem-1;j>0;j--){
				if(in>=array[j]){
					array[j+1]=array[j];
				}else {
					break;
				}
				array[j]=in;
			}
		}
		nIntem++;
	}
	public long remove(){
		return array[--nIntem];
	}
	public static void main(String[] args) {
		String s = Integer.toString(1213);
		System.out.println(s);
	}
}
