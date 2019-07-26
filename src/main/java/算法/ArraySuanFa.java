package 算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: shenguang
 * @Date: 2018/10/9 17:22
 * @Description:常见的数组算法
 */
public class ArraySuanFa {
	//1 一个连续的数组，查找缺少的一个值   数列求和  减去 连续数列的和
	public void checkMiss(int[] arr){
		int frist = arr[0];
		int len = arr.length;
		int end = len+frist;
		int all = ((frist+end)*(len+1))/2;
		int a = 0;
		for (int i :arr){
			a+=i;
		}
		int miss = all-a;
		System.out.println(miss);
	}


	//2 一个连续的数组，查找缺少的多个值
	public void checkMissAll(int[] arr){
		int[] arrmax=new int[arr[arr.length-1]+1];

		for(int i=1;i<arr.length;i++){
			arrmax[arr[i]]=arr[i];
		}
		System.out.println(Arrays.toString(arrmax));
	}

	//3 重复最多的元素
	public void checkRep(int[] arr){
		int count=1;
		int tempCount=1;
		int index=0;
		int value=0;
		int len = arr.length;
		for (int i=0;i<len;i++){
			for(int j = i+1;j<len;j++){
				if(arr[i]==arr[j]){
					tempCount++;
				}
			}
			if(tempCount>count){
				count=tempCount;
				index=i;
				value=arr[i];
			}
			tempCount=1;
		}
		System.out.println("次数："+count+",下标："+index+",值："+value);
	}
	//4 连续出现重复的最高的元素
	public void continuWord(int[] arr){
		int count =0;
		int tempCount=1;
		int value=0;
		int index=0;
		for(int i =0;i<arr.length-1;i++){
			if(arr[i]==arr[i+1]){
				tempCount++;
			}else {
				if(tempCount>count){
					count=tempCount;
					value=arr[i];
					index=i-(tempCount-1);
				}
				tempCount=1;
			}

		}
		System.out.println("次数："+count+",下标："+index+",值："+value);
	}


	public int maxSub(Integer[] iArray){
		List<Integer> out = new ArrayList<Integer>();
		int i;
		int max=0;
		int temp_sum=0;
		for(i=0;i<iArray.length;i++){
			temp_sum+=iArray[i];
			if (temp_sum>max){
				max=temp_sum;
			}else if (temp_sum<0) {
				temp_sum=0;
				out.clear();
			}
			System.out.println(out);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] iArray={1,1,1,3,3,2,2,2,2,6,8,1};
		ArraySuanFa arraySuanFa = new ArraySuanFa();
		arraySuanFa.checkRep(iArray);
		arraySuanFa.continuWord(iArray);
	}
}
