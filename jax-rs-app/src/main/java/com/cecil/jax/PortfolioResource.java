/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-08-31 18:46
 * @Description:
 */
package com.cecil.jax;

import javax.ws.rs.core.UriInfo;

/**
 * @author LiMingChi 2016-08-31 18:46
 * @version V1.0
 */
public class PortfolioResource {

    private AccountRepository accountRepository;
    private String username;
    private UriInfo uriInfo;

    public PortfolioResource(AccountRepository accountRepository, String username, UriInfo uriInfo) {
        this.accountRepository = accountRepository;
        this.username = username;
        this.uriInfo = uriInfo;
    }

}