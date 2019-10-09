package 小问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 一个关于"null","isEmpty","" 的小问题
 */
public class StringProblem1 {
    @Test
    public void currentHashMapInfo(){
        Map<String ,String> map = new HashMap<>();
        String put = map.put("map", "map");
        map.get("map");
        System.out.println(put);
        ConcurrentMap<String,String> cmap = new ConcurrentHashMap<>();
        String cput = cmap.put("面试1", "面试1");
        String cput2 = cmap.put("面试2", "面试2");
        System.out.println( cput);

    }
    @Test
    public void stringBuliderAndList(){
        StringBuilder sb = new StringBuilder("StringBuilder ");
        String str1 = "String1";
        String str2 = new String("String2");
        List lsb = new ArrayList<>();
        lsb.add(sb);
        sb.append(" fuck");

        lsb.add(str1);
        str1 = "fuck";

        lsb.add(str2);
        str2="fuck";
        Object x = lsb.get(0);
        System.out.println(x);
        Object y =  lsb.get(1);
        System.out.println(y);
        Object z = lsb.get(2);
        System.out.println(z);
    }
    @Test
    public void eqpbm() {
        String a = new String();
        String b = "";
        String c = null;

        testString(a);
        testString(b);
        testString(c);
    }

    private void testString(String str){
        if (str == null){
            System.out.println("null");
        }
        if (str.isEmpty()){
            System.out.println("isEmpty");
        }
        if (str.equals("")){
            System.out.println("\"\"");
        }
        System.out.println("-------------");
    }


    @Test
    public void testa(){
        int a = 1;
        int b = a;
        a=20;

        System.out.println("a = "+a +" b = "+b);
        Person p = new Person("shenguang");
        Person p2 = p;

        p.age=21;
        p.name="sum";
        System.out.println("p ："+p+" p2 :"+p2);

        p2.age=22;
        p2.name="kang";
        System.out.println("p ："+p+" p2 :"+p2);
    }
    @Test
    public void strReverse(){
        String abcd = "abcd";
        char[] chars = abcd.toCharArray();
        for(int i =(chars.length-1);i>0;i--){
            char aChar = chars[-i];
            System.out.println(aChar);
        }
    }
    @Test
    public void strEq(){
        String abcd = "abcd";
        String abcd2 = "abcd";
        System.out.println(abcd==abcd2);

        String abcd3 = new String("abcd");
        System.out.println(abcd==abcd3);

        String abcd4 = "abc"+"d";
        System.out.println(abcd==abcd4);


        String abcd5 = "abc";
        String abcd6 = "d";
        String abcd7 = abcd5+abcd6;
        System.out.println(abcd==abcd7);

        int a = 10;

        a = 11;


    }
}