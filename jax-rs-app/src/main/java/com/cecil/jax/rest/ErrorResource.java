/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-08-31 18:44
 * @Description:
 */
package com.cecil.jax.rest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author LiMingChi 2016-08-31 18:44
 * @version V1.0
 */
@Path("/error")
@Component
@Scope("prototype")
public class ErrorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "ERROR";
    }


}