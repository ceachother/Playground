/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-10-31 17:18
 * @Description:
 */
package com.cecil.springboot;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author LiMingChi 2016-10-31 17:18
 * @version V1.0
 */
@XmlRootElement(name = "pushtocenter")
@XmlAccessorType(XmlAccessType.FIELD)
public class PushRequest {

//    @XmlElementWrapper(name = "pushtocenter")
    @XmlElement(name = "instanceuid")
    private List<String> instanceuid;

    public List<String> getInstanceuid() {
        return instanceuid;
    }

    public void setInstanceuid(List<String> instanceuid) {
        this.instanceuid = instanceuid;
    }
}