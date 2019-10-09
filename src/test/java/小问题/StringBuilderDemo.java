package 小问题;

import org.apache.commons.lang.StringUtils;

public class StringBuilderDemo {
    public static String trimComma (String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        while (',' == str.charAt(0) || ',' == str.charAt(str.length() - 1)) {
            char begin = str.charAt(0);
            if (',' == begin) {
                str = str.substring(1);
            }
            char end = str.charAt(str.length() - 1);
            if (',' == end) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++){
                        stringBuilder.append("a");
                    }
                }
            }).start();
        }

//        Thread.sleep(100);
//        System.out.println(stringBuilder.length());
        System.out.println(trimComma(",  asdfas  ,"));


    }
}