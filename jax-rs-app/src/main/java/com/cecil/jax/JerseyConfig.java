/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-09-01 12:08
 * @Description:
 */
package com.cecil.jax;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiMingChi 2016-09-01 12:08
 * @version V1.0
 */
@Configuration
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("com.cecil.jax.rest");
        register(LoggingFilter.class);
        register(ExceptionMapper.class);
    }
}