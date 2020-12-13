package com.github.lowzj.studyjava.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author lowzj
 * @date 2020/12/13
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
            throws Throwable {
        String msg = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        System.out.println("cglib proxy - before invoking " + msg);

        System.out.println("args:");
        Parameter[] ps = method.getParameters();
        for (int i = 0; i < args.length; i++) {
            System.out.println(ps[i].getType().getSimpleName() + " "
                    + ps[i].getName() + " =  " + args[i]);
        }

        Object result = proxy.invokeSuper(obj, args);

        System.out.println("cglib proxy - after invoking " + msg);
        System.out.println("return type: " + method.getReturnType().getSimpleName());
        System.out.println("return value: " + result);
        return result;
    }

}
