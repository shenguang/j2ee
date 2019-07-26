package littiletest;

import java.math.BigDecimal;

/**
 * @className test
 * @Description
 * @Date 2019/7/10 11:30
 * @Author shenguang
 * @Version 1.0
 **/
public class test {
    public static void main(String[] args) {

//        System.out.println("四舍五入取整:(2)=" + new BigDecimal("2").setScale(0, BigDecimal.ROUND_HALF_UP));
//        System.out.println("四舍五入取整:(2.1)=" + new BigDecimal("2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
//        System.out.println("四舍五入取整:(2.5)=" + new BigDecimal("2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
//        System.out.println("四舍五入取整:(2.9)=" + new BigDecimal("2.9").setScale(0, BigDecimal.ROUND_HALF_UP));
//
//        System.out.println("取整:(13)=" + new BigDecimal("13").setScale(0, BigDecimal.ROUND_HALF_UP));
//        System.out.println("取整:(13.1)=" + new BigDecimal("13.1").setScale(0, BigDecimal.ROUND_HALF_UP));
//        System.out.println("取整:(13.5)=" + new BigDecimal("13.5").setScale(0, BigDecimal.ROUND_HALF_UP));
//        System.out.println("取整:(13.9)=" + new BigDecimal("13.9").setScale(0, BigDecimal.ROUND_HALF_UP));
//
//        System.out.println("取整:(113)=" + new BigDecimal("113").setScale(0, BigDecimal.ROUND_DOWN));
//        System.out.println("取整:(113.1)=" + new BigDecimal("113.1").setScale(0, BigDecimal.ROUND_DOWN));
//        System.out.println("取整:(113.5)=" + new BigDecimal("113.5").setScale(0, BigDecimal.ROUND_DOWN));
//        System.out.println("取整:(113.9)=" + new BigDecimal("113.9").setScale(0, BigDecimal.ROUND_DOWN));

        //.multiply(new BigDecimal(50)).setScale(5, BigDecimal.ROUND_HALF_UP)
        System.out.println(new BigDecimal(10).compareTo(new BigDecimal(10.00)));
        System.out.println("========>: "+new BigDecimal(10).divide(new BigDecimal(3),BigDecimal.ROUND_HALF_UP));


    }
}
