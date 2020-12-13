package com.github.lowzj.studyjava.aop;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author lowzj
 * @date 2020/12/14
 */
public class ProxyFactory {
    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                new Class<?>[]{HelloService.class}, new DynamicProxyHandler(obj));
    }

    public static Object getCglibProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibProxy());
        return enhancer.create();
    }
}
