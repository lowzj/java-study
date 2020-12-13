package com.github.lowzj.studyjava.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lowzj
 * @date 2020/12/13
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object obj;
    public DynamicProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String msg = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        System.out.println("dynamic proxy - before invoking " + msg);
        Object result = method.invoke(obj, args);
        System.out.println("dynamic proxy - after invoking " + msg);
        System.out.println("return value: " + result);
        return result;
    }
}
