package java8.javastream;

/**
 * @className OrderType
 * @Description
 * @Date 2019/9/3 14:53
 * @Author shenguang
 * @Version 1.0
 **/
public class OrderType {

    private String typeName;
    private Integer status;

    public OrderType(String typeName, Integer status) {
        this.typeName = typeName;
        this.status = status;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
