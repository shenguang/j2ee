package java8.javastream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @className order
 * @Description
 * @Date 2019/8/8 11:21
 * @Author shenguang
 * @Version 1.0
 **/
public class Order {
    String orderNo;
    String CreateOrderName;
    String priceItemName;
    Integer status;
    BigDecimal free;
    Date date;

    public Order(String orderNo, String createOrderName, String priceItemName, Integer status, BigDecimal free) {
        this.orderNo = orderNo;
        CreateOrderName = createOrderName;
        this.priceItemName = priceItemName;
        this.status = status;
        this.free = free;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateOrderName() {
        return CreateOrderName;
    }

    public void setCreateOrderName(String createOrderName) {
        CreateOrderName = createOrderName;
    }

    public String getPriceItemName() {
        return priceItemName;
    }

    public void setPriceItemName(String priceItemName) {
        this.priceItemName = priceItemName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getFree() {
        return free;
    }

    public void setFree(BigDecimal free) {
        this.free = free;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", CreateOrderName='" + CreateOrderName + '\'' +
                ", priceItemName='" + priceItemName + '\'' +
                ", status=" + status +
                ", free=" + free +
                '}';
    }
}
