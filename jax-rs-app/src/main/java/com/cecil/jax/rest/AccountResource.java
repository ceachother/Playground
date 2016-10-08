/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-08-31 18:44
 * @Description:
 */
package com.cecil.jax.rest;

import com.cecil.jax.AccountRepository;
import com.cecil.jax.entity.Account;
import com.cecil.jax.entity.Han;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * @author LiMingChi 2016-08-31 18:44
 * @version V1.0
 */
@Path("/accounts")
@Component
//@Scope("prototype")
public class AccountResource {

    @Context
    UriInfo uriInfo;

    @Autowired
    private AccountRepository accountRepository;

    private Han han = new Han();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hello")
    public String hello() {
        return "Hello World";
    }

//    @GET
//    @Path("{username}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Account getAccount(@PathParam("username") String username) {
//        Account account = new Account();
//        account.setUserName(username);
//        return account;
//    }

//    @GET
//    @Path("{username}.xml")
//    @Produces(MediaType.APPLICATION_XML)
//    public Account getAccountXML(@PathParam("username") String username) {
//        Account account = new Account();
//        account.setUserName(username);
//        account.setId(0);
//        return account;
//    }
//
//    @Path("{username}/portfolios/")
//    public PortfolioResource getPortfolioResource(@PathParam("username") String username) {
//        return new PortfolioResource(accountRepository, username, uriInfo);
//    }

    @POST
    @Path("ac/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Account getAccount(Account account) {
        return account;
    }

    @GET
    @Path("money/{integer}")
    @Produces(MediaType.APPLICATION_JSON)
    public Han getTotle(@PathParam("integer") String integer) {
        han.setPpl(han.getPpl()+1);
        han.setMoney(han.getMoney()+Integer.parseInt(integer));
        return han;
    }

    @GET
    @Path("money")
    @Produces(MediaType.APPLICATION_JSON)
    public Han getMoney() {
        return han;
    }
}