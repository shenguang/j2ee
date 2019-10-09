package java8.javastream;

import java8.javadate.DateTimeUtils;

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
public class TestOrder {

    public void freeMap() {
        String[] words = new String[]{"Hello", "World"};
        Stream<String[]> stream = Arrays.stream(words)
                .map(word -> word.split(""));


        String[] word2s = new String[]{"Hello", "World"};
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)//这里是将多个流连接起来合并为一个
                .distinct()
                .collect(toList());
        a.forEach(System.out::print);
    }

    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        Date date1 = DateTimeUtils.String2Date("2019-08-01 00:00:00");
        Date date2 = DateTimeUtils.String2Date("2019-08-21 24:00:00");

        String orderNo = "No:123456";
        for (int i = 0; i < 10; i++) {
            Order sg = new Order(orderNo, "sg", orderNo + "---" + i, 1, new BigDecimal("100" + i));
            sg.setDate(date1);
            list.add(sg);
        }

        String orderNo2 = "No:987654";
        for (int i = 0; i < 10; i++) {
            Order sg = new Order(orderNo2, "cyq", orderNo + "---" + i, 2, new BigDecimal("200" + i));
            sg.setDate(date2);
            list.add(sg);
        }
        List<Order> list2 = new ArrayList<>();

        String orderNo3 = "No:963852";
        for (int i = 0; i < 10; i++) {
            Order sg = new Order(orderNo3, "shi", orderNo3 + "---" + i, 3, new BigDecimal("300" + i));
            list2.add(sg);
        }
        BigDecimal decimal = list.stream().filter(c -> {
//            System.out.println(c.getFree());
//            System.out.println(c.status+"   "+(c.getFree().compareTo(new BigDecimal(1005))>=0));

            if (c.status == 1 && (c.getFree().compareTo(new BigDecimal(1005))) >= 0) {
                return true;
            }
//            System.out.println(c.status+"   "+(c.getFree().compareTo(new BigDecimal(1005))>=0));
            return false;


        }).map(o -> o.getFree()).reduce(BigDecimal.ZERO, (sum, item) -> sum.add(item));


//        System.out.println(decimal);

        Optional<Order> first = list.stream().filter(order -> order.getStatus() == 2).findFirst();
        first.isPresent();
        System.out.println(first.get());


        Order order = new Order(orderNo3, "shi", orderNo3 + "---" + 1, 3, new BigDecimal("300"));
        order.setCreateOrderName(null);
//        System.out.println(order);

        Map<String, List<Order>> collect = list.stream().collect(Collectors.groupingBy(o -> DateTimeUtils.Date2StringYMD(o.getDate())));
        System.out.println(collect);

        StringBuilder cs = new StringBuilder("");
        System.out.println("substring" + cs.toString());

        String bac = null;
        String res = Optional.ofNullable(bac).orElse("空");
        System.out.println(res);
        Map<String, String> abc = new HashMap<>();

        Order sg = new Order(orderNo3, "shi", abc.get("abc") == null ? "" : abc.get("abc") + "", 3, new BigDecimal("300"));
        sg.setOrderNo(abc.get("abc"));
        BigDecimal couponDeductAmount = new BigDecimal("100");
        BigDecimal couponDeductAmount2 = new BigDecimal("10");
        BigDecimal couponDeductAmount3= new BigDecimal("5");
        BigDecimal subtract = couponDeductAmount.subtract(couponDeductAmount2).subtract(couponDeductAmount3);
        System.out.println("subtract   " + subtract);
    }

}
