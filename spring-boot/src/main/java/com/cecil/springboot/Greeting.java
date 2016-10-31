/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-05-18 11:58
 * @Description:
 */
package com.cecil.springboot;

/**
 * @author LiMingChi 2016-05-18 11:58
 * @version V1.0
 */
//@XmlRootElement
public class Greeting {

    private long id;

    private String content;

    public Greeting() {
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}