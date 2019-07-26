package 递归;

/**
 * @Auther: shenguang
 * @Date: 2018/11/26 18:00
 * @Description:
 */
public class DoAnagram {
	static int size;
	static int count;
	static char[] arrChar = new char[100];

	public static void main(String[] args) {
		String input = "abc";
		size = input.length();
		count=0;
		for (int j = 0;j<size;j++)
			arrChar[j]= input.charAt(j);
		doanagram(size);
	}
	public static void doanagram(int newsize){
		if(newsize == 1){
			return;
		}
		for (int j = 0;j<newsize;j++){
			doanagram(newsize-1);
			if(newsize==2)
				display();
			rotate(newsize);
		}
	}

	private static void rotate(int newsize) {
		int j;
		int postion = size-newsize;
		char temp = arrChar[postion];
		for(j=postion+1;j<size;j++){
			arrChar[j-1]=arrChar[j];
		}
		arrChar[j-1]=temp;
	}

	private static void display() {
		if(count<99){
			System.out.print(" ");
		}
		if(count<9){
			System.out.print(" ");
		}
		System.out.print(++count+" ");
		for(int j=0;j<size;j++){
			System.out.print(arrChar[j]);
		}
		System.out.print("   ");
		System.out.flush();
		if(count%6==0){
			System.out.println(" ");
		}
	}
}
