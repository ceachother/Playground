/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-08-31 18:45
 * @Description:
 */
package com.cecil.jax.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author LiMingChi 2016-08-31 18:45
 * @version V1.0
 */
@XmlRootElement
public class Account {

    private Integer id;
    private String userName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}