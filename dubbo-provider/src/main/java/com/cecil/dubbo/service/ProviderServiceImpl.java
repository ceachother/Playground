/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-08-25 11:58
 * @Description:
 */
package com.cecil.dubbo.service;

import org.springframework.stereotype.Service;

/**
 * @author LiMingChi 2016-08-25 11:58
 * @version V1.0
 */
@Service("providerService")
public class ProviderServiceImpl implements ProviderService{

    public String getString() {
        return "Provider";
    }

}