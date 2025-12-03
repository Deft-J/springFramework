package com.coder.aop.impl;

import com.coder.aop.SalesmanService;

public class SalesmanServiceImpl implements SalesmanService {
    @Override
    public void selectGoods() {
        System.out.println("购买什么商品");
    }

    @Override
    public void scanPay() {
        System.out.println("请扫码支付");
    }
}
