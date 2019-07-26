package VO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private static List<Integer> sSorted = new ArrayList<>();
    public static void addElement(int e) {
        int i = 0;
        for(;i<sSorted.size();i++){
            if(e>sSorted.get(i)){
                break;
            }
        }
        sSorted.add(i,e);
        System.out.println(sSorted);
    }
    public static void add(int index ,int element) {
//将index放上element 其他元素后移一位  System.arraycopy
        sSorted.add(index,element);

        System.out.println(sSorted);
    }



    public static void main(String[] args) {

        addElement(3);
        addElement(1);
        addElement(4);
        addElement(2);
        addElement(7);
        addElement(9);
//        sSorted.sort(null);
        add(2,6);

        System.out.println(sSorted);


    }

}