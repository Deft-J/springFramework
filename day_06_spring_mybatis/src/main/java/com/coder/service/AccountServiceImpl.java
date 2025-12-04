package com.coder.service;

import com.coder.entity.Account;
import com.coder.entity.ChangeRecord;
import com.coder.mapper.AccountMapper;
import com.coder.mapper.RecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private RecordMapper recordMapper;

    @Override
    public void addAccount(Account account) {
        accountMapper.saveAccount(account);
    }

    @Override
    public List<Account> listAllAccount() {
        return accountMapper.selectAllAccount();
    }

    @Override
    public Account userLogin(String account, String password) {
        return accountMapper.login(account, password);
    }

    @Override
    public void rechargeCoupon(String account, Integer num) throws InterruptedException {
        //事务超时回滚
        TimeUnit.SECONDS.sleep(6);
        //更新用户点券
        accountMapper.updateCoupon(new Account().setAccount(account).setCoupon(num));
        //新增充值记录
        recordMapper.saveRecord(new ChangeRecord()
                .setAccount(account)
                .setUpdateTime(new Date())
                .setCategory("充值")
                .setNum(num));
    }

    @Override
    public void consumeCoupon(String account, Integer num) {
        //更新用户点券
        accountMapper.updateCoupon(new Account().setAccount(account).setCoupon(-num));
        //新增消费记录
        recordMapper.saveRecord(new ChangeRecord()
                .setAccount(account)
                .setUpdateTime(new Date())
                .setCategory("消费")
                .setNum(num));
    }
}
