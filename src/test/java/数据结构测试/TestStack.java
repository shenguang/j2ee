package 数据结构测试;

import 数据结构.zhan.StackList;
import 数据结构.zhan.StackXI;

/**
 * @Auther: shenguang
 * @Date: 2018/10/31 13:53
 * @Description: 1：用栈可以反转字符串 2：解析某种类型的文本串：文本串是计算机语言写代码行 如java代码中检测编译时错误
 */
public class TestStack {
    private String input;

    public TestStack(String input) {
        this.input = input;
    }

    public void check() {
        StackList<Character> stackList = new StackList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stackList.add(c);
            }
            if (c == '}' || c == ']' || c == ')') {
                Character pop = stackList.pop();
                if(pop==null){
                    System.out.println("error near : "+c);
                    return;
                }
                if(c == '}'){
                    if(pop!='{'){
                        System.out.println("error near : "+c);
                        return;
                    }
                }
                if(c == ']'){
                    if(pop!='['){
                        System.out.println("error near : "+c);
                        return;
                    }
                }
                if(c == ')'){
                    if(pop!='('){
                        System.out.println("error near : "+c);
                        return;
                    }
                }
            }
        }
        System.out.println("perfect");
    }

    public static void main(String[] args) {
        TestStack testStack = new TestStack("a{b[c(asdf)]d}f}");
        testStack.check();
    }


}
