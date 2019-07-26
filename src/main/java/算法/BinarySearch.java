package 算法;

/**
 * @Auther: shenguang
 * @Date: 2018/10/9 15:20
 * @Description:二分查找
 */
public class BinarySearch {
	/**
	 *
	 * @param srcArray
	 * @param target
	 * @return 二分查找得实现
	 */
	int bSearch(int[] srcArray,int target){
		int low =0;
		int high = srcArray.length-1;
		while (low<=high){
			//计算出中间索引位置
			int middle = (high + low)>>>1 ;
			int arrayMiddle = srcArray[middle];
			if(arrayMiddle==target){
				return middle;
			}else if(target<arrayMiddle){
				high=middle-1;
			}else {
				low=middle+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int[] srcArray = {1,12,22,33,54,65,74,88};
		System.out.println(binarySearch.bSearch(srcArray,88));
	}

}
