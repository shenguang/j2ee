package 算法;

import 数据结构.hashbiao.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * @Auther: shenguang
 * @Date: 2018/10/19 14:24
 * @Description: 排序
 */
public class PaiXu {
    /**
     * 冒泡排序
     *
     * @param in
     * @return
     */
    public List<Integer> maoPaoPaiXu(List<Integer> in) {
        for (int i = 0; i < in.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (in.get(i) < in.get(j)) {
                    Integer temp = in.get(j);
                    in.set(j, in.get(i));
                    in.set(i, temp);
                }
            }
        }

        return in;
    }

    /**
     * 选择排序
     * 交换得次数少，但是比较得次数和冒泡得次数一致 ：每次选出最小得
     *
     * @param inArray
     * @return
     */


    public Integer[] xuanZhePaiXu(Integer[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            for (int j = i + 1; j < inArray.length; j++) {
                if (inArray[i] > inArray[j]) {
                    Integer temp = inArray[i];
                    inArray[i] = inArray[j];
                    inArray[j] = temp;
                }
            }
        }
        return inArray;

    }

    public Integer[] charuPaiXu(Integer[] inArray) {


        Integer nElems = inArray.length;
        for (int out = 1; out < nElems; out++) {
            Integer temp = inArray[out];
            Integer in = out;
            while (in > 0 && inArray[in - 1] > temp) {
                inArray[in] = inArray[in - 1];
                in--;
            }
            inArray[in] = temp;
        }
        return inArray;
    }


    public static void shellSort(int[] arr) {
        //排序前: [13,27,49,55,4,50]
        int length = arr.length;
        int gap = 1;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int j = i - gap;
                int temp = arr[i];
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    arr[j] = temp;
                    j -= gap;
                }
            }
            gap = gap >>> 1;
        }
        System.out.println(" Sorting:  " + Arrays.toString(arr));


        //int[] in = {33,88,22,1,54,74,65,12};
//		int gap = arr.length / 2;
//		for (; gap > 0; gap /= 2) {      //不断缩小gap，直到1为止
//			for (int j = 0; (j+gap) < arr.length; j++){     //使用当前gap进行组内插入排序
//				for(int k = 0; (k+gap)< arr.length; k += gap){
//					if(arr[k] > arr[k+gap]) {
//						int temp = arr[k+gap];      //交换操作
//						arr[k+gap] = arr[k];
//						arr[k] = temp;
//						System.out.println("    Sorting:  " + Arrays.toString(arr));
//					}
//				}
//			}
//		}
    }


    /**
     * 快速排序
     * 基本思想：
     * 在待排序表中L[1...n]先取一个元素作为基准pivot
     * 通过一次排序把L分成两个部分
     * 一部分为：L[1...k-1]这里面的元素都是小于pivot
     * 二部分为：L[k+1...n]这里面的元素都是大于pivot
     * 而pivot是放在L[k]的位置上
     * 然后分别递归这两部分，直到每个部分是一个元素或者为空为止
     */
    private void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pivotpos = partition(A, low, high);
            quickSort(A, low, pivotpos - 1);
            quickSort(A, pivotpos + 1, high);
        }
    }

    private int partition(int[] a, int low, int high) {

        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) {
                high -= 1;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivot) {
                low += 1;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }


    public static void main(String[] args) {
        PaiXu px = new PaiXu();
//		List<Integer> in = new ArrayList<Integer>();
//		in.add(213);
//		in.add(3);
//		in.add(4);
//		in.add(89);
//		in.add(1);
//		System.out.println(px.maoPaoPaiXu(in));

        int[] srcArray = {6, 4, 8, 9, 2, 3, 1};
//        System.out.println(px.partition(srcArray,0,srcArray.length-1));
//		System.out.println(Arrays.asList(px.xuanZhePaiXu(srcArray)));
//		System.out.println(Arrays.asList(px.charuPaiXu(srcArray)));
        int[] in = {33, 88, 22, 1, 54, 74, 65, 12};
        shellSort(in);
        px.quickSort(srcArray, 0, srcArray.length - 1);
        Arrays.stream(srcArray).forEach(System.out::print);

    }


}
