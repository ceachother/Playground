/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-11-10 16:06
 * @Description:
 */
package com.cecil.activemq;

import java.io.Serializable;

/**
 * @author LiMingChi 2016-11-10 16:06
 * @version V1.0
 */
public class Person implements Serializable{

    private static final long serialVersionUID = -2749977649306134186L;

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}