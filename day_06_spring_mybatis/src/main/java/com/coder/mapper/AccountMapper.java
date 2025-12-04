package com.coder.mapper;

import com.coder.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    //增加账户
    void saveAccount(Account account);

    //查询显示所有账户
    List<Account> selectAllAccount();

    //用户登录
    Account login(String account, String password);

    //更新用户点券
    void updateCoupon(Account account);
}
