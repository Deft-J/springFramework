package com.coder.aop.test;

import com.coder.aop.SalesmanService;
import com.coder.aop.WaiterService;
import com.coder.aop.impl.SalesmanServiceImpl;
import com.coder.aop.impl.WaiterServiceImpl;
import com.coder.aop.proxy.ServiceProxyUtil;

public class ProxyTest {
    public static void main(String[] args) {
        SalesmanService salesman = (SalesmanService) ServiceProxyUtil.getServiceProxy(new SalesmanServiceImpl());
        System.out.println("售货员业务:");
        salesman.selectGoods();
        salesman.scanPay();

        System.out.println("\n服务员业务:");
        WaiterService waiter = (WaiterService) ServiceProxyUtil.getServiceProxy(new WaiterServiceImpl());
        waiter.orderMeal();
        waiter.scanPay();
    }
}
