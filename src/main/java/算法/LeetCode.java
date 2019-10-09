package 算法;

import 数据结构.zhan.StackList;

import java.util.*;

/**
 * @className LeetCode
 * @Description
 * @Date 2019/7/17 17:27
 * @Author shenguang
 * @Version 1.0
 **/
public class LeetCode {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

    //使用标记位进行进位处理    用链表计算（2-4-3）+（5-6-4）
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int addNum = 0;
        while(q!=null){
            if(p.next==null && q.next!=null)
                p.next = new ListNode(0);
            if(q.next==null && p.next!=null)
                q.next = new ListNode(0);
            int sumAll = addNum + p.val + q.val;
            p.val = sumAll % 10;
            addNum = sumAll / 10;
            if(p.next == null && q.next == null && addNum!=0)
                p.next = new ListNode(addNum);
            p = p.next;
            q = q.next;
        }
        return l1;
    }
    //查看字符串中最长不重复且连续的子串的长度
    public int lengthOfLongestSubstring(String s) {
        int len = 1;
        for(int i = 0 ;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                int start = i;
                int end = j ;
                Set<Character> set = new HashSet<>();
                for(;start<end;start++){
                    char c = s.charAt(start);
                    if(set.contains(c)){
                        len = Math.max(len,set.size());
                        break;
                    }else {
                        set.add(c);
                    }
                }
            }
        }
        return len;
    }
    //查看字符串中最长不重复且连续的子串的长度---滑动窗口的方法
    public int lengthOfLongestSubstringRep(String s) {
        int n = s.length();
        List<Character> list = new ArrayList<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (list.size()<=0||list.contains(s.charAt(j))){
                list.add(s.charAt(j++));
                System.out.println("j = "+j);
                ans = Math.max(ans, j - i);
            }else {
                char index = s.charAt(i++);
                //注意：
                list.remove(new Character(index));
                System.out.println("i = "+i);
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                System.out.println("j = "+j);
                ans = Math.max(ans, j - i);
            }
            else {
                char o = s.charAt(i++);
                System.out.println("i = "+i);
                set.remove(o);
            }
        }
        return ans;
    }
    public String longestPalindrome(String s) {
        int len = 1;
        String sub = null;
        for(int i =0 ;i<s.length();i++){
            for(int j=(i+1);j<=s.length();j++){
                String substring = s.substring(i, j);
                int i1 = strReverse(substring);
                if(len<i1){
                    len = i1;
                    sub = substring;
                }
            }
        }
        return sub;
    }
    private int strReverse(String substring){
        char[] chars = substring.toCharArray();
        StackList<Character> stackList = new StackList<>();
        for(int k=0;k<chars.length;k++){
            stackList.add(chars[k]);
        }
        StringBuffer sb = new StringBuffer();
        while (!stackList.isEmpet()){
            sb.append(stackList.pop());
        }
        if(substring.equals(sb.toString())){
            return substring.length();
        }
        return 1;
    }
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int ans = 0;
        for(int i = 0;i < s.length();) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();

        int[] in = {9,4,7,3,5,8};
        Arrays.stream(twoSum(in, 9)).forEach(System.out::print);

//        ListNode l1 = new ListNode(2);
//        l1.add(4);
//        l1.add(3);
//        ListNode l2 = new ListNode(5);
//        l2.add(6);
//        l2.add(4);
//        ListNode listNode = addTwoNumbers(l1, l2);

//        int abcabcbb = leetCode.lengthOfLongestSubstring2("abcabcbb");
//        int abcabcbb2 = leetCode.lengthOfLongestSubstringRep("abqsdfaaaaacabcbbb");
//        String babad = leetCode.longestPalindrome("aaaacdfgdcaba");

//        System.out.println(leetCode.romanToInt("XCD"));
    }


}
