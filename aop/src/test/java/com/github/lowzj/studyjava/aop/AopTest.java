package com.github.lowzj.studyjava.aop;

import org.junit.Test;

/**
 * @author lowzj
 * @date 2020/12/13
 */
public class AopTest {
    @Test
    public void testDynamicProxy() {
        HelloService hello = (HelloService) ProxyFactory.newInstance(new HelloServiceImpl());
        hello.say();
    }

    @Test
    public void cglibTest() {
        HelloService hello = (HelloService) ProxyFactory.getCglibProxy(HelloServiceImpl.class);
        hello.say();
    }
}

