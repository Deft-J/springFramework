package com.coder.aop.impl;

import com.coder.aop.WaiterService;

public class WaiterServiceImpl implements WaiterService {
    @Override
    public void orderMeal() {
        System.out.println("请看一下菜单");
    }

    @Override
    public void scanPay() {
        System.out.println("请扫码支付");
    }
}
