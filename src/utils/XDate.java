package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {

    static SimpleDateFormat formater = new SimpleDateFormat();

    public static Date toDate(String date, String pattern) {//chuyển String thành date(để đưa vào database)
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Date date, String pattern) {//chuyển Date thành String(từ database đưa lên form )
        formater.applyPattern(pattern);
        if (date == null) {
            return null;
        }
        return formater.format(date);
    }
    
    public static Date addDays(Date date, long days){//bổ sung bao nhiu ngày vào sau hoặc trc thời gian đã có 
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
    
    public static Date now() {
        return new Date();
    }
}
