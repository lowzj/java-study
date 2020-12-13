package com.github.lowzj.studyjava.aop;

/**
 * @author lowzj
 * @date 2020/12/13
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "hello world";
    }
}
