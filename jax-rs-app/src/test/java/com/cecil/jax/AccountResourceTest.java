package com.cecil.jax;

import com.cecil.jax.rest.AccountResource;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.ws.rs.core.Application;
/**
 * @author LiMingChi 2016-09-01 16:10
 * @version V1.0
 */
@ComponentScan(basePackageClasses = {AccountResource.class})
public class AccountResourceTest extends JerseyTest{

    @Override
    protected Application configure() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        return new JerseyConfig().property("contextConfig", context);
    }

    @Test
    public void testAccounts() {
        final String account = target("accounts/cecil.xml").request().get(String.class);
        System.out.println(account);
    }

    @Test
    public void testHello() {
        final String hello = target("accounts/hello").request().get(String.class);
        System.out.println(hello);
    }

}