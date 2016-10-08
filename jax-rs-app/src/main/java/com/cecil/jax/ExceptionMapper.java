/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-09-01 19:15
 * @Description:
 */
package com.cecil.jax;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * @author LiMingChi 2016-09-01 19:15
 * @version V1.0
 */
@Provider
public class ExceptionMapper  implements javax.ws.rs.ext.ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception exception) {
        exception.printStackTrace();
        return Response.status(500).build();
    }

}