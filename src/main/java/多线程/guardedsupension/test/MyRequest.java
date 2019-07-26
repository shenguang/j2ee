package 多线程.guardedsupension.test;

/**
 * @className MyRequest
 * @Description
 * @Date 2019/7/8 16:38
 * @Author shenguang
 * @Version 1.0
 **/
public class MyRequest {
    final private String value;

    public MyRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
