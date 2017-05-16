package com.jd.appstore.domain.utils;

import com.jd.appstore.domain.enumtype.DateConversionObj;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 该方法用于时间的转换
 */
public class DateConversion {

    public static String starTime;
    public static String endTime;

    /**
     * 拿日期取得年月日
     *
     * @param time
     * @return
     */
    public static DateConversionObj dataConversion(String time) {
        DateConversionObj dataConversionObj = new DateConversionObj();
        try {
            if (StringUtils.isNotBlank(time)) {
                Integer year = Integer.valueOf(time.substring(0, 4));
                dataConversionObj.setYear(year);
                Integer month = Integer.valueOf(time.substring(time.indexOf("-") + 1, time.indexOf("-") + 3));
                dataConversionObj.setMonth(month);
                Integer day = Integer.valueOf(time.substring(time.lastIndexOf("-") + 1, time.length()));
                dataConversionObj.setDay(day);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataConversionObj;
    }

    /**
     * 获取日期的中当月的最后一天
     *
     * @param time
     * @return
     */
    public static String lastDay(String time) {
        try {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(time);

            Calendar cDay1 = Calendar.getInstance();
            cDay1.setTime(date);
            final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
            Date lastDate = cDay1.getTime();
            lastDate.setDate(lastDay);
            return fmt.format(lastDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



   public static void  main(String args[]){
         System.out.print(DateConversion.lastDay("2014-09-30"));
    }
}
