package java8.javastream;

import java8.javadate.DateTimeUtils;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @className TestOrder
 * @Description
 * @Date 2019/8/13 17:34
 * @Author shenguang
 * @Version 1.0
 **/
public class TestOrder2 {

    public static List<Order> freeMap(){
        List<Order> list = new ArrayList<>();
        List<OrderType> listOrderType = new ArrayList<>();
        Date date1 = DateTimeUtils.String2Date("2019-08-01 00:00:00");
        Date date2 = DateTimeUtils.String2Date("2019-08-21 24:00:00");

        String orderNo = "No:123456";
        for(int i= 0 ;i<10;i++){
            Order sg = new Order(orderNo, "sg", orderNo + "---" + i,1,new BigDecimal("100"+i));
            sg.setDate(date1);
            list.add(sg);
        }

        String orderNo2 = "No:987654";
        for(int i= 0 ;i<10;i++){
            Order sg = new Order(orderNo2, "cyq", orderNo + "---" + i,2,new BigDecimal("200"+i));
            sg.setDate(date2);
            list.add(sg);
        }


        for(int i= 0 ;i<10;i++){
            OrderType orderType = new OrderType("支付宝订单",1);
            listOrderType.add(orderType);
        }
        List<Order> collect = list.stream().filter(order -> find(order.getStatus(), listOrderType) > -1)
                .collect(Collectors.toList());


        return collect;

    }
    public static void main(String[] args) {
        System.out.println(freeMap());
    }

    static  int find(int id, List<OrderType> list){
        int res = -1;
        for(int i = 0; i < list.size(); i ++){
            if (list.get(i).getStatus() == id){
                res = i;
                break;
            }
        }
        return res;
    }

}
