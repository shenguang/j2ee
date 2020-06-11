package 数据结构.zhan;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @className StackList
 * @Description
 * @Date 2019/7/9 13:51
 * @Author shenguang
 * @Version 1.0
 **/
public class StackList<T> {
    private List<T> list = new ArrayList<>();
    private int top = -1;

    public T pop() {
        if (top >= 0) {
            T remove = list.remove(top);
            top--;
            return remove;
        }
        return null;
    }

    public T peek() {
        if (top >= 0) {
            T remove = list.get(top);
            return remove;
        }
        return null;
    }

    public boolean add(T value) {
        top++;
        return list.add(value);
    }

    public boolean isEmpet() {
        if (top < 0 || list.size() <= 0) {
            return true;
        }
        return false;
    }

    public void display() {
        list.stream().forEach(System.out::print);
    }

    public static void main(String[] args) {
//        StackList<Character> stringStack = new StackList<>();
//        String str = "113{123{1(1231[we23])2}";
//        checkKuoHao(stringStack,str);
        String str = "1+2+4/2-3*2+1+1";
        String all = getAll(str);
        System.out.println(all);
    }

    private static void checkKuoHao(StackList<Character> stringStack, String str) {

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stringStack.add(c);
            }

            if (c == '}') {
                char pop = stringStack.pop().charValue();
                if (pop == '{') {
                    System.out.println("'{' is ok");
                } else {
                    System.out.println("'{' is error");
                    break;
                }
            }
            if (c == ']') {
                char pop = stringStack.pop().charValue();
                if (pop == '[') {
                    System.out.println("'[' is ok");
                } else {
                    System.out.println("'[' is error");
                    break;
                }
            }
            if (c == ')') {
                char pop = stringStack.pop().charValue();
                if (pop == '(') {
                    System.out.println("'(' is ok");
                } else {
                    System.out.println("'(' is error");
                    break;
                }
            }
        }
        if (!stringStack.isEmpet()) {
            char pop = stringStack.pop().charValue();
            System.out.println(pop + " is error");
        }


    }

    private static String getAll(String str) {
        StackList<String> stackFuhao = new StackList<>();
        StackList<String> stackNum = new StackList<>();
        for (int i = 0; i < str.length(); i++) {
            getRes(stackFuhao, stackNum, str.charAt(i) + "",str.length()-1,i);
        }
        return stackNum.peek();
    }

    private static void getRes(StackList<String> stackFuhao, StackList<String> stackNum, String s,int size ,int index ) {
        // String str = "1+2*3-4/2+1-2+6/3";
        String[] fuhao = {"+", "-", "*", "/"};
        if (ArrayUtils.contains(fuhao, s)) {
            if (stackFuhao.isEmpet()) {
                stackFuhao.add(s);
            } else {
                String peek = stackFuhao.peek();
                if (peek.equals(s)) {
                    jiSuan(stackFuhao, stackNum);
                    stackFuhao.add(s);
                }
                if (!peek.equals(s)) {
                    if (s.equals("+") || s.equals("-")) {
                        jiSuan(stackFuhao, stackNum);
                        stackFuhao.add(s);
                    }else {
                        if(s.equals("*") || s.equals("/")){
                            if (peek.equals("+") || peek.equals("-")) {
                                stackFuhao.add(s);
                            }else {
                                jiSuan(stackFuhao, stackNum);
                                stackFuhao.add(s);
                            }

                        }
                    }
                }
            }
        } else {
            stackNum.add(s);
        }
        if(size == index){
            jiSuan(stackFuhao, stackNum);
        }

    }

    private static void jiSuan(StackList<String> stackFuhao, StackList<String> stackNum) {
        if(stackFuhao.isEmpet() || stackNum.isEmpet()){
            return;
        }
        String pop = stackFuhao.pop();
        String pop1 = stackNum.pop();
        String pop2 = stackNum.pop();
        switch (pop) {
            case "+":
                stackNum.add(Integer.valueOf(pop2 + "") + Integer.valueOf(pop1 + "") + "");
                break;
            case "-":
                stackNum.add(Integer.valueOf(pop2 + "") - Integer.valueOf(pop1 + "") + "");
                break;
            case "*":
                stackNum.add(Integer.valueOf(pop2 + "") * Integer.valueOf(pop1 + "") + "");
                break;
            case "/":
                stackNum.add(Integer.valueOf(pop2 + "") / Integer.valueOf(pop1 + "") + "");
                break;
        }
        jiSuan(stackFuhao,stackNum);

    }
}
