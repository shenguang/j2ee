package java8.javadate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;

/**
 * @className TestCalender
 * @Description
 * @Date 2019/8/13 14:48
 * @Author shenguang
 * @Version 1.0
 **/
public class TestCalender {
    public static void localDate(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());

        LocalDateTime ld2 = LocalDateTime.of(2018, 8, 29, 8, 8, 20);
        System.out.println(ld2);
        LocalDateTime ld3 = ld2.plusYears(2);
        System.out.println(ld3);

        LocalDateTime ld4 = ld2.minusMonths(2);
        System.out.println(ld4);
    }
    public static void calendar(){
        Calendar calendar = Calendar.getInstance();
        //取出年
        System.out.println(calendar.get(Calendar.YEAR));
        //取出月
        System.out.println(calendar.get(Calendar.MONTH));
        //取出日
        System.out.println(calendar.get(Calendar.DATE));
        //分别设置年月日小时分钟 秒
        calendar.set(2003, 10, 23, 12, 32, 23);

        System.out.println(calendar.getTime());
        //将Calendar的年前推1年
        calendar.add(Calendar.YEAR, -1);
        System.out.println(calendar.getTime());
        //将Calendar的月前推8个月
        calendar.roll(Calendar.MONTH, -8);
        System.out.println(calendar.getTime());
    }
    public static void formatter(){
        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
                //直接使用常量创建  DateTimerFormatter 格式器
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                //使用本地化的不同风格来创建DateTimeFormatter格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.LONG),
                DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
                //根据模式化字符串来创建DateTimeFormatter 格式器
                DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        };
        LocalDateTime date = LocalDateTime.now();

        //依次使用不同的格式器对  LocalDateTime  进行格式化
        for (int i = 0; i < formatters.length; i++) {
            //下面两行代码的作用时间
            System.out.println(date.format(formatters[i]));
            System.out.println(formatters[i].format(date));
            System.out.println("------------------");
        }
    }

    public static void main(String[] args) {
        formatter();
    }


}
