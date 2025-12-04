package com.coder.service;

import com.coder.entity.Account;

import java.util.List;

public interface AccountService {
    // 新增帐户
    void addAccount(Account account);

    // 查询所有帐户
    List<Account> listAllAccount();

    // 登录验证
    Account userLogin(String account, String password);

    // 充值点券
    void rechargeCoupon(String account, Integer num) throws InterruptedException;

    // 消费点券
    void consumeCoupon(String account, Integer num);
}
