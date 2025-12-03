package com.coder.aop.proxy;

import java.lang.reflect.Proxy;

public class ServiceProxyUtil {
    public static Object getServiceProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ServiceInvocationHandler(target)
        );
    }
}
