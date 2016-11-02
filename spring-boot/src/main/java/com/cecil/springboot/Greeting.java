/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-05-18 11:58
 * @Description:
 */
package com.cecil.springboot;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author LiMingChi 2016-05-18 11:58
 * @version V1.0
 */
@XmlRootElement(name = "Greeting")
public class Greeting {

    private long id;

    @XmlElement(name = "content")
    private String content;

    private List<String> instance;

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

    public List<String> getInstance() {
        return instance;
    }

    public void setInstance(List<String> instance) {
        this.instance = instance;
    }
}