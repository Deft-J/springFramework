package com.coder.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceInvocationHandler implements InvocationHandler {

    private Object target;

    public ServiceInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        String methodName = method.getName();
        String className = target.getClass().getSimpleName();

        if (className.equals("SalesmanServiceImpl")) {
            if (methodName.equals("selectGoods")) {
                System.out.println("您好，欢迎光临");
                result = method.invoke(target, args);
            } else if (methodName.equals("scanPay")) {
                result = method.invoke(target, args);
                System.out.println("慢走，欢迎再来");
            }
        } else if (className.equals("WaiterServiceImpl")) {
            if (methodName.equals("orderMeal")) {
                System.out.println("您好，欢迎光临");
                result = method.invoke(target, args);
            } else if (methodName.equals("scanPay")) {
                result = method.invoke(target, args);
                System.out.println("请带好您的随身物品，慢走，欢迎再来");
            }
        }
        return result;
    }
}
