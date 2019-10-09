package littiletest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

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
        Integer a = 4566;
        Integer b = 456611;
        System.out.println(a.compareTo(b));

        LocalTime mid = LocalTime.parse("12:00"); // 12:00:00
        LocalTime min = LocalTime.parse("12:00"); // 12:00:00
        System.out.println(mid.compareTo(min));

        Double distance = 754.55;
        Long rand =  Math.round(distance/1000);
        System.out.println(rand.intValue());


        System.out.println(new Date().compareTo(parse("2019-08-06 10:30:30","yyyy-MM-dd HH:mm:ss")));


        Date adate=parseDateStr("0000-00-00 00:00:00","yyyy-MM-dd HH:mm:ss");

        System.out.println(a);
        System.out.println(formatDateTime(adate));
    }
    public static Date parse(final String dateValue, final String fmt) {
        try{
            return new SimpleDateFormat(fmt).parse(dateValue);
        }catch(Exception ex) {
            return null;
        }
    }

    public static Date parseDateStr(String dateStr,String parttern){
        try{
            SimpleDateFormat format =  new SimpleDateFormat(parttern);
            return format.parse(dateStr);
        }catch (Exception e){
            return null;
        }
    }

    public static String formatDateTime(Date date) {
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return outFormat.format(date);
    }


}
