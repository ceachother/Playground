/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-09-20 17:42
 * @Description:
 */
package com.cecil.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;

/**
 * @author LiMingChi 2016-09-20 17:42
 * @version V1.0
 */
public class JodaTest {

    public static void main(String[] args) {
//        DateTimeUtils.setCurrentMillisFixed(1);
        DateTime dateTime = new DateTime();
        System.out.println(dateTime);
        System.out.println(dateTime.toString("yyyymmdd"));
    }

}