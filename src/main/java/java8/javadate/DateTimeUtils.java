package java8.javadate;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class DateTimeUtils {
    public static String dtf = "yyyy-MM-dd HH:mm:ss";
    public static String dtfYMD = "yyyy-MM-dd";
    public static String dtfNoFormat = "yyyyMMddHHmmss";

    public DateTimeUtils() {
    }

    public static boolean isWeekend(LocalDateTime now) {
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public static Date localDate2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static Date localDate2Date(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static LocalDate date2LcalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    public static long lcalDateTimeReduce(LocalDateTime date1, LocalDateTime date2) {
        return date1.toLocalDate().toEpochDay() - date2.toLocalDate().toEpochDay();
    }

    public static long lcalDateTimeReduceAll(LocalDateTime date1, LocalDateTime date2) {
        return date1.toLocalDate().toEpochDay() - date2.toLocalDate().toEpochDay() + 1L;
    }

    public static boolean existenceDay(String dayStr, Date starTime, Date endTime) {
        LocalDate date = LocalDate.parse(dayStr);
        LocalDate starLocalDate = date2LcalDate(starTime);
        LocalDate endlocalDate = date2LcalDate(endTime);
        return starLocalDate.compareTo(date) <= 0 && endlocalDate.compareTo(date) >= 0;
    }

    public static String Date2String(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(dtf);
            return sdf.format(date);
        }
    }

    public static Date String2Date(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return new Date();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(dtf);

            try {
                return sdf.parse(dateStr);
            } catch (ParseException var3) {
                var3.printStackTrace();
                return new Date();
            }
        }
    }

    public static String Date2StringYMD(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(dtfYMD);
            return sdf.format(date);
        }
    }

    public static int existenceDay(Date starTime, Date endTime) {
        if (starTime.after(endTime)) {
            Date dateFormat = null;
            dateFormat = endTime;
            endTime = starTime;
            starTime = dateFormat;
        }

        Long nd = 86400000L;
        Long nh = 3600000L;
        Long nm = 60000L;
        Long diff = endTime.getTime() - starTime.getTime();
        Long day = diff / nd;
        Long hour = diff % nd / nh;
        Long min = diff % nd % nh / nm;
        Long second = diff % nd % nh % nm / 1000L;
        if (hour.intValue() > 0) {
            return day.intValue() + 1;
        } else {
            return hour.intValue() != 0 || min.intValue() <= 0 && second.intValue() <= 0 ? day.intValue() : day.intValue() + 1;
        }
    }

    public static Date conversionDay(Date date) {
        try {
            LocalDate localDate = date2LcalDate(date);
            LocalTime localTime = LocalTime.of(23, 59, 59);
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            return localDate2Date(localDateTime);
        } catch (Exception var4) {
            return date;
        }
    }

    public static String createCurrentIdentity(Date date, int num) {
        if (date == null) {
            date = new Date();
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dtfNoFormat);
        String format = sdf.format(date);
        double i = (Math.random() * 9.0D + 1.0D) * Math.pow(10.0D, (double)num);
        return format + (int)i;
    }

    public static void main(String[] args) throws Exception {
        //1:判断时间
        //1.1 开始时间不能大于结束时间
        //1.2 开始时间要大于不能小于2019.05.01
        //1.3 结束时间不能大于等于今天
        //1.4 最多导出93天数据

        Date date1 = DateTimeUtils.String2Date("2019-08-01 00:00:00");
        Date date2 = DateTimeUtils.String2Date("2019-08-21 24:00:00");
        if(date1.getTime()>date2.getTime()){
            System.out.println("开始时间不能大于结束时间");
        }

        Date date3 = DateTimeUtils.String2Date("2019-05-01 00:00:00");
        if(date3.getTime()>date1.getTime()){
            System.out.println("开始时间要大于不能小于2019.05.01");
        }
        String s = DateTimeUtils.Date2StringYMD(date1);
        System.out.println("结束时间不能大于等于今天:"+s);
        int i = DateTimeUtils.existenceDay(date1, date2);
        System.out.println(i);
        if(i>93){
            System.out.println(i);
        }

    }
}