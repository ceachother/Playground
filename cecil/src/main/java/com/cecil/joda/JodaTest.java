/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-09-20 17:42
 * @Description:
 */
package com.cecil.joda;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * @author LiMingChi 2016-09-20 17:42
 * @version V1.0
 */
public class JodaTest {

    public static void main(String[] args) {
        stringToJoda();
//        jodaToString();
    }

    public static void jodaToString() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime);
        System.out.println(dateTime.toString("yyyyMMdd"));
        System.out.println(new DateTime(new Date().getTime()).toString("yyyyMMdd"));
    }
    public static void stringToJoda() {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");
//        DateTime dateTime = DateTime.parse("20161020",dateTimeFormatter);
//        System.out.println(dateTime);
//        dateTime = dateTime.plusDays(-1);
//        System.out.println(dateTime.toString("yyyyMMdd"));
//        dateTime = dateTime.withTime(23,59,59,0);
//        System.out.println(dateTime);

        DateTime end = DateTime.now().minusDays(5);
        System.out.println(end);
        String endDate = "1".isEmpty() ? end.toString("yyyyMMdd"):"";
        System.out.println(endDate);
        System.out.println(DateTime.now().toString("yyyyMMdd"));

    }

}